package com.azarenko.model;

public class Literal {
    private char[] chars;
    private char[] vovels;
    private char[] consotans;

    public Literal() {
        vovels = new char[]{'а','ы','о','и','ю','й','й','у','е','я','э'};
        consotans = new char[]{'ч','с','м','т','ф','в','т','б','п','р','л','д','ж','ц','к','н','г','ш','щ','з','х'};
    }

    public char[] getChars() {
        return chars;
    }

    public char[] getVovels() {
        return vovels;
    }

    public char[] getConsotans() {
        return consotans;
    }
}
