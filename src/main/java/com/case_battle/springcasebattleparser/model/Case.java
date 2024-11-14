package com.case_battle.springcasebattleparser.model;

import java.util.Objects;

public class Case {
    private String title;
    private String url;
    private int price;

    public Case(String title, String url, int price) {
        this.title = title;
        this.url = url;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return price == aCase.price && Objects.equals(title, aCase.title) && Objects.equals(url, aCase.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url, price);
    }

    @Override
    public String toString() {
        return "Case{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }
}
