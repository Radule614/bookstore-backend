package com.example.bookstorebackend.book;

import com.example.bookstorebackend.book.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.bookstorebackend.utils.ObjectsMapper.convertBooksToDTOs;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/bookstore/book")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookService.getAll(), OK);
    }

    @GetMapping(path = "recommended")
    public ResponseEntity<List<BookDTO>> getRecommended() {
        List<BookDTO> books = convertBooksToDTOs(bookService.getRecommendedBooks());
        return new ResponseEntity<>(books, OK);
    }
}
