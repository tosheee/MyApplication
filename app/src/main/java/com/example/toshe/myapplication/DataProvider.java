package com.example.toshe.myapplication;

/**
 * Created by toshe on 4.11.2015 г..
 */
public class DataProvider {
    private String wordEn;
    private String wordBg;

    public DataProvider(String wordEn, String wordBg){

        this.wordEn = wordEn;
        this.wordBg = wordBg;
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
        this.wordEn = wordEn;
    }

    public String getWordBg() {
        return wordBg;
    }

    public void setWordBg(String wordBg) {
        this.wordBg = wordBg;
    }
}
