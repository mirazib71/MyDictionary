package com.example.mirazib.my_dictionary_1_test;

/**
 * Created by M.I.RAZIB on 2/3/2018.
 */

public class Dictmodel_bmark extends Dictmodel {


    int id=0;
    String word=null;
    String meaning=null;

    public Dictmodel_bmark()
    {

    }

    public Dictmodel_bmark(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }


    public Dictmodel_bmark(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
