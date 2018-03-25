package com.azarenko.dao;

import java.util.List;

public interface Text {
    /**
     *
     * @param text
     * @return
     */
    List<String> emailList(String text);

    /**
     *
     * @param text
     * @return
     */
    List<String> telNUmber(String text);

    /**
     *
     * @param countSymbol
     */
    void removeWord(int countSymbol);
}
