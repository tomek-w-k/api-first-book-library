package com.app.apifirstbooklibrary.error.exception;

public class BookNotFoundException extends RuntimeException{

    private static final String MESSAGE = "A Book for the given 'id' does not exist.";


    public BookNotFoundException() {
        super(MESSAGE);
    }

    public static String getMESSAGE() {
        return MESSAGE;
    }
}
