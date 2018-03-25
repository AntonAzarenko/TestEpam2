package com.azarenko.model;

import java.util.ArrayList;
import java.util.List;

public class Punctuations {
    private String mark;


    @Override
    public String toString() {
        return "Punctuations{" +
                "mark='" + mark + '\'' +
                '}';
    }

    public Punctuations(String mark) {

        this.mark = mark;
    }

    public String getMark() {

        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
