package com.app.apifirstbooklibrary.repository;

import com.app.apifirstbooklibrary.error.exception.BookNotFoundException;
import com.app.apifirstbooklibrary.models.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class BookRepository {

    private List<Book> bookList = new ArrayList<>();
    private Long idCounter = 1L;


    public BookRepository() {
        save(new Book().title("Thinking in C++ vol 1").author("Bruce Eckel"));
        save(new Book().title("Thinking in Java").author("Bruce Eckel"));
        save(new Book().title("Thinking in C++ vol 2").author("Bruce Eckel"));
        save(new Book().title("Effective Java").author("Joshua Bloch"));
    }

    public Book save(Book book) {
        book.setId(idCounter++);
        bookList.add(book);

        return book;
    }

    public Book findById(Long id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElseThrow(() -> new BookNotFoundException());
    }

    public List<Book> findAll() {
        return bookList;
    }

    public void deleteById(Long id) {
        bookList.removeIf(book -> book.getId() == id);
    }
}
