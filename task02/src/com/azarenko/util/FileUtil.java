package com.azarenko.util;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс предназначен для чтения Текстового файла
 */
public class FileUtil {

    private String text;

    public FileUtil() {
    }

    /**
     * read file to char array
     * @param name
     * @return
     */
    public String readFile(String name) {
        File file = new File(name);
        try {
            FileReader reader = new FileReader(file);
            char[] buffer = new char[5000];
            while (reader.ready()) {
                reader.read(buffer);
            }
            // преобразуем  массив в текст
            text = getStringToCharArray(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * parce array to string
     * @param buffer
     * @return
     */
    private String getStringToCharArray(char[] buffer) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char pair : buffer) {
            stringBuilder.append(pair);
        }
        Pattern pattern = Pattern.compile("\\t");
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()){
            matcher.replaceAll("");
        }
        return stringBuilder.toString();
    }

}


