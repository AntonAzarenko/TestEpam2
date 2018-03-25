package com.azarenko.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence {
    private List<Word> wordList;

    public Sentence(List<Word> wordList) {
        this.wordList = wordList;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }
}
