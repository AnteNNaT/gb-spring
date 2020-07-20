package ru.geekbrains.gbspring.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.gbspring.model.Word;

import java.util.List;

/*
 * 1. Написать приложение, которое получает на вход текст (String),
 * а возвращает список слов в этой строке, отсортированный по убыванию популярности.
 * 2. Интерфейс:
 *   public class WordCountService{
 *   List<Word> countWords(String book) {
 *   //logic
 *   }
 * 3. Слова в List<Word> должны быть отсортированы по убыванию популярности
 * 4. Слова не чувствительны к регистру – AM, am, Am – это одно слово.
 * 5. Текст может содержать запятые, тире, кавычки – все что угодно.
 * 6. Задание со звездочкой:
 *       1. Используйте Spring
 *       2. выведите результат в формате JSON при помощи ObjectMapper.
 *       3. Декомпозируйте логику на отдельные классы/методы,
 *          каждый из которых имеет единственную зону ответственности (Single Responsibility Principle, SRP).
 */

@Service
public class WordCountService {

    private WordExtractor wordExtractor;
    private WordCounter wordCounter;

    public WordCountService(WordExtractor wordExtractor, WordCounter wordCounter) {
        this.wordExtractor = wordExtractor;
        this.wordCounter = wordCounter;
    }

    public List<Word> countWords(String book) {
        List<String> strings = wordExtractor.extractWords(book);
        List<Word> count = wordCounter.countWords(strings);
        return count;
    }

}

