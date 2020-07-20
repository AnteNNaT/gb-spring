package ru.geekbrains.gbspring.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.gbspring.model.Word;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordCounter {

    public List<Word> countWords(List<String> words){
        List<Word> result = new ArrayList<>();
        HashSet<String> uniqueWords = new HashSet<>(words);
        Map<String, Long> map = new HashMap<>();

        for (String word : uniqueWords
        ) {
            map.put(word, (long) Collections.frequency(words, word));
        }

        result=toList(sortMapByValue(map));
        return result;
    }

    private List<Word> toList(Map<String, Long> stringLongMap) {
        List<Word> words = new ArrayList<>();
        for (Map.Entry<String, Long> stringLongEntry : stringLongMap.entrySet()) {
            words.add(new Word(stringLongEntry.getKey(), stringLongEntry.getValue()));
        }
        return words;
    }

   private Map<String, Long> sortMapByValue(Map<String, Long> map){
       Map<String, Long> sortedMap = map.entrySet().stream()
               .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
   }
}
