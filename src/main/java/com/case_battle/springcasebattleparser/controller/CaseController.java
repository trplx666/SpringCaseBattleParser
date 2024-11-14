package com.case_battle.springcasebattleparser.controller;

import com.case_battle.springcasebattleparser.model.Case;
import com.case_battle.springcasebattleparser.repository.InMemoryCaseDAO;
import com.case_battle.springcasebattleparser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {
    @Autowired
    private final InMemoryCaseDAO caseRepository;

    @Autowired
    private final ParserService parserService;

    public CaseController(InMemoryCaseDAO caseRepository, ParserService parserService) {
        this.caseRepository = caseRepository;
        this.parserService = parserService;
    }

    @GetMapping("/get_all")
    public List<Case> getAllCases() {
        return caseRepository.findAllCases();
    }

    @GetMapping("/parse")
    public String parseAndSaveCases() {
        String url = "https://case-battle.skin";
        try {
            List<Case> cases = parserService.parseCasesFromUrl(url);
            caseRepository.saveCases(cases);
            return "Cases parsed and saved successfully!";
        } catch (IOException e) {
            return "Failed to parse cases: " + e.getMessage();
        }
    }
}
