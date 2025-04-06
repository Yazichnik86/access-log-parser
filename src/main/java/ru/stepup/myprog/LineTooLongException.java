package ru.stepup.myprog;

public class LineTooLongException extends RuntimeException {
    public LineTooLongException(String message) {

        super(message);
    }
}
