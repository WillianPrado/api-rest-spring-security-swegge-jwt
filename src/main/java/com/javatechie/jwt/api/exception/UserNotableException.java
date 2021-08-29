package com.javatechie.jwt.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotableException extends Exception {

    public UserNotableException(int level) {
        super(String.format("User with level %s doesn't have permition!", level));
    }
}
