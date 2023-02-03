package com.app.apifirstbooklibrary.error.advice;

import com.app.apifirstbooklibrary.controller.BookController;
import com.app.apifirstbooklibrary.error.error.Error;
import com.app.apifirstbooklibrary.error.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Error> handleBookNotFoundException(BookNotFoundException exception) {
        return new ResponseEntity<>(
                new Error()
                        .message(exception.getMessage())
                        .httpStatus(HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return new ResponseEntity(exception.getBindingResult().getFieldErrors(), HttpStatus.BAD_REQUEST);
    }
}
