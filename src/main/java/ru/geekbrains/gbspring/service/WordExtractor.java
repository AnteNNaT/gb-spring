package ru.geekbrains.gbspring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class WordExtractor {

    public List<String> extractWords(String book){

        StringTokenizer stringTokenizer = new StringTokenizer(book.toLowerCase()
                .replaceAll(" - ", " ")
                .replaceAll(" '", " ")
                .replaceAll("' ", " "),
                " .,;:!?()\n\r\"");
        List<String> result = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        return result;
    }
}
