package com.example.toshe.myapplication;

/**
 * Created by toshe on 4.11.2015 г..
 */
public class Words {

    String wordBg, wordEn;
    public Words(String wordBg, String wordEn){
        this.wordBg = wordBg;
        this.wordEn = wordEn;
    }

    public Words(){}

    public Words(String wordEn ){
        
    }

    public String getWordBg() {
        return wordBg;
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
        this.wordEn = wordEn;
    }

    public void setWordBg(String wordBg) {
        this.wordBg = wordBg;
    }
}
