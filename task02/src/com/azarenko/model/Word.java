package com.azarenko.model;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private   List<Symbol> symbolList;
    private List<Punctuations> punctuationsList;

    public Word() {
    }

    public Word(List<Symbol> symbolList, List<Punctuations> punctuationsList) {
        this.symbolList = symbolList;
        this.punctuationsList = punctuationsList;
    }

    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    public void setSymbolList(List<Symbol> symbolList) {
        this.symbolList = symbolList;
    }

    public List<Punctuations> getPunctuationsList() {
        return punctuationsList;
    }

    public void setPunctuationsList(List<Punctuations> punctuationsList) {
        this.punctuationsList = punctuationsList;
    }
}
