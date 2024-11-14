package com.case_battle.springcasebattleparser.repository;

import com.case_battle.springcasebattleparser.model.Case;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCaseDAO {
    private final List<Case> cases = new ArrayList<>();

    public List<Case> findAllCases() {
        return cases;
    }

    public void saveCases(List<Case> newCases) {
        cases.addAll(newCases);
    }
}
