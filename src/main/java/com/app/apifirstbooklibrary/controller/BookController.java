package com.app.apifirstbooklibrary.controller;

import com.app.apifirstbooklibrary.api.BooksApi;
import com.app.apifirstbooklibrary.models.Book;
import com.app.apifirstbooklibrary.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class BookController implements BooksApi {

    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<Book> addBook(Book body) {
        return new ResponseEntity<>(bookRepository.save(body), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @Override
    public ResponseEntity<Book> getBookById(Integer id) {
        return ResponseEntity.ok(bookRepository.findById(Long.valueOf(id)));
    }
}
