package com.yong.springbootcoding.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private static final String READER = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }

    @GetMapping
    public String readersBooks(Model model){
        List<Book> books = readingListRepository.findByReader(READER);

        if(Objects.nonNull(books)){
            model.addAttribute("books", books);
        }

        return "readingList";
    }

    @PostMapping
    public String addToReadingList(Book book){
        book.setReader(READER);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
