package com.azarenko.util;

import com.azarenko.model.Punctuations;
import com.azarenko.model.Sentence;
import com.azarenko.model.Symbol;
import com.azarenko.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParcer {
    private static final String REGEX_SENTENCE = "\\.\\s+";
    private static final String REGEX_WORD = "\\,*\\s+\\\"*";
    private static final String REGEX_PUNCTUATION = "([\\,|\\)|\\:|\\(|\\\"])";
    public static List<Sentence> sentenceList;

    public TextParcer() {
        this.sentenceList = new ArrayList<>();
    }

    /**
     * Initialize list. Parse text to sentence and word and symbol.
     *
     * @param text
     */
    public void initialize(String text) {
        splitTextToSentence(text);
    }

    private void splitTextToSentence(String text) {
        String[] sentenceArray = text.split(REGEX_SENTENCE);
        for (String s : sentenceArray) {
            //  add a sentence containing an array of words to the array
            sentenceList.add(new Sentence(splitTexttoWord(s)));
        }
    }

    /**
     *
     * @param text
     * @return list
     */
    private List<Word> splitTexttoWord(String text) {
        List<Word> wordList = new ArrayList<>();
        String[] words = text.split(REGEX_WORD);
        for (String w : words) {
            List<Punctuations> punctuationsList = splitWordToPunctuation(w);
            text = splitWordWithoutPunctuations(w);
            List<Symbol> symbolList = splitWordToSymbol(text);
            wordList.add(new Word(symbolList, punctuationsList));
        }
        return wordList;
    }

    /**
     *
     * @param text
     * @return
     */
    private List<Punctuations> splitWordToPunctuation(String text) {
        Pattern pattern = Pattern.compile(REGEX_PUNCTUATION);
        Matcher matcher = pattern.matcher(text);
        List<Punctuations> punctuationsList = new ArrayList<>();
        while (matcher.find()) {
            punctuationsList.add(new Punctuations(matcher.group()));
        }
        return punctuationsList;
    }

    /**
     *
     * @param text
     * @return
     */
    private List<Symbol> splitWordToSymbol(String text) {
        char[] ch = text.toCharArray();
        List<Symbol> symbolList = new ArrayList<>();
        for (char pair : ch) {
            symbolList.add(new Symbol(ch));
        }
        return symbolList;
    }

    /**
     *
     * @param text
     * @return
     */
    private String splitWordWithoutPunctuations(String text) {
        List<Punctuations> punctuationsList = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_PUNCTUATION);
        Matcher matcher = pattern.matcher(text);
        String test = text;
        while (matcher.find()) {
            punctuationsList.add(new Punctuations(matcher.group()));
            test = text.replace(matcher.group(), "");
        }
        return test;
    }

}
