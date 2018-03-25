package com.azarenko.dao;

import com.azarenko.model.Literal;
import com.azarenko.model.Sentence;
import com.azarenko.model.Symbol;
import com.azarenko.model.Word;
import com.azarenko.util.TextParcer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextImpl implements Text {
    private Literal literal;
    private Word word;
    private boolean isEmty;

    public TextImpl() {
        literal = new Literal();
        word = new Word();
        isEmty=true;
    }

    /**
     * find email adress.
     *
     * @param text
     * @return
     */
    @Override
    public List<String> emailList(String text) {
        Pattern emailPattern = Pattern.compile("(\\w+([\\.-]?\\w+))@(\\w+\\.)(\\w+)(\\.\\w+)*");
        Matcher matcher = emailPattern.matcher(text);
        List<String> emailList = new ArrayList<>();
        while (matcher.find()) {
            emailList.add(matcher.group());
        }
        return emailList;
    }

    /**
     * @param text
     * @return
     */
    @Override
    public List<String> telNUmber(String text) {
        Pattern telNumberPatern = Pattern.compile("8(\\d{10})");
        Matcher matcher = telNumberPatern.matcher(text);
        List<String> telNumList = new ArrayList<>();
        while (matcher.find()) {
            telNumList.add(matcher.group());
        }
        return telNumList;
    }

    /**
     * @param countSymbol
     */
    @Override
    public void removeWord(int countSymbol) {

       List<Sentence> sentenceList = TextParcer.sentenceList;
        for (int i = 0; i < sentenceList.size(); i++) {

            List<Word> wordList = sentenceList.get(i).getWordList();
            for (int k = 0; k < wordList.size(); k++) {

                //берем слово и делаем массив литералов
                List<Symbol> symbolList = wordList.get(k).getSymbolList();
                for (int h = 0; h < symbolList.size(); h++) {

                    char [] chars = symbolList.get(h).getChars();
                    //ищем слова на  согланую букву
                    for (int j = 0; j < literal.getConsotans().length; j++) {
                        // проверяем первую букву на соответсвие согласной и  заданной длинне
                        if (chars[0] == literal.getConsotans()[j]) {
                            if (chars.length == countSymbol) {
                                //удаляем слово
                                symbolList.remove(h);
                                //логируем в консоль
                                System.out.println("Удалено слово: " + symbolList.get(h).toString());
                            }
                        }
                    }
                }
            }
        }
    }




}
