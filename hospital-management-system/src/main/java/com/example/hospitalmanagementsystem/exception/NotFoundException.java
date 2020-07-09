package com.example.hospitalmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="NotFoundException")
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private org.springframework.http.HttpStatus HttpStatus;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) { super(message); }

    public NotFoundException(String message, Throwable cause) { super(message, cause); }
}
