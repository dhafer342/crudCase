package com.inventiv.crudCase.exception;

import com.inventiv.crudCase.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CaseControllerErrorHandler {

    @ExceptionHandler(CaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handlerPlayerNotFoundException(CaseNotFoundException ex){
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler(CaseAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handlerPlayerAlreadyExistException(CaseAlreadyExistException ex){
        return new ErrorDto(ex.getMessage());
    }

}
