package com.epam.task08.main.data.parser;

public class ParserException extends Exception {

    public ParserException(String message, Exception e) {
        super(message, e);
    }

    public ParserException(String message) {
        super(message);
    }
}