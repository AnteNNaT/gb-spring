package ru.geekbrains.gbspring.model;

import java.io.Serializable;

public class Word implements Serializable {

    private String word;
    private Long count = 0L;

    public Word(String word, Long count) {
        this.word = word;
        this.count = count;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
