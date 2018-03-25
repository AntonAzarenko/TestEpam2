package com.azarenko;


import com.azarenko.dao.TextImpl;
import com.azarenko.model.Sentence;
import com.azarenko.model.Symbol;
import com.azarenko.model.Word;
import com.azarenko.util.FileUtil;
import com.azarenko.util.TextParcer;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        TextParcer textParcer = new TextParcer();
        //читаем наш текст из файла
        String text = fileUtil.readFile("text.txt");
        // передаем наш текст в клас парсер
        textParcer.initialize(text);
        TextImpl text1 = new TextImpl();
        //выводим в консоль все адреса почты и телефонные номера заданного формата
        System.out.println(text1.emailList(text));
        System.out.println(text1.telNUmber(text));
        // удаляем все слова на согласную заданного параметра
        text1.removeWord(8);

    }

}
