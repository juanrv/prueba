package com.recreationManager.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnathorizazed extends Exception {

    public ApiUnathorizazed(String message){
        super(message);
    }
}
