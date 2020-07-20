package ru.geekbrains.gbspring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import ru.geekbrains.gbspring.model.Word;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WordCountServiceTest {

    @Autowired
    WordCountService wordCountService;

    @Test
    void countWords() throws IOException {
       // File resource1 = new ClassPathResource("The_Hobbit_chapter_1.txt").getFile();
       // String book1 = new String(Files.readAllBytes(resource1.toPath()));
        File resource2 = new ClassPathResource("dune.txt").getFile();
        String book2 = new String(Files.readAllBytes(resource2.toPath()));
        //File resultFile=new ClassPathResource("result.txt").getFile();
       // List<Word> result1 = wordCountService.countWords(book1);
        List<Word> result2 = wordCountService.countWords(book2);
       /* Path path= resultFile.toPath();
        Files.write(path, "".getBytes());
        for (Word word : result) 
        {String string = word.getWord()+": "+word.getCount()+"\n";
            Files.write(path,string.getBytes(),StandardOpenOption.APPEND);
        */
       //assertEquals("the", result1.get(0).getWord());
       assertEquals("the", result2.get(0).getWord());
       for (int i = 0; i < (result2.size()-1); i++){
        assertTrue(result2.get(i).getCount()>=result2.get(i+1).getCount());
       }
    }


}