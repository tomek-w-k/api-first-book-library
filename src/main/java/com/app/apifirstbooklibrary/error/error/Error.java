package com.app.apifirstbooklibrary.error.error;

import org.springframework.http.HttpStatus;


public class Error {

    private String message;
    private HttpStatus httpStatus;


    public Error() {}

    public Error(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Error message(String message) {
        this.message = message;
        return this;
    }

    public Error httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
