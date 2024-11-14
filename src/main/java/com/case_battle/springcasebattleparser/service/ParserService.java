package com.case_battle.springcasebattleparser.service;

import com.case_battle.springcasebattleparser.model.Case;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {
    public List<Case> parseCasesFromUrl(String url) throws IOException {
        List<Case> cases = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        doc.select("a[data-title]").forEach(element -> {
            String title = element.select(".title h3").text();
            String caseUrl = element.attr("href");
            String priceText = element.select(".border-box span").text();

            int price = 0;
            if (priceText != null && !priceText.isEmpty()) {
                price = Integer.parseInt(priceText.replaceAll("\\D+", ""));
            }

            cases.add(new Case(title, caseUrl, price));
        });

        return cases;
    }
}
