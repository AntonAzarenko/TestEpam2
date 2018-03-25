package com.azarenko.model;

import java.util.Arrays;
import java.util.List;

public class Symbol {
    private  char[] chars;

    public Symbol(char[] chars) {
        this.chars = chars;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "chars=" + Arrays.toString(chars) +
                '}';
    }
}
