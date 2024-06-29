package com.vivek.learn.graph_ql.controller;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.graphql.execution.ErrorType;

@Getter
@Setter
public class ServiceException extends RuntimeException{

    private  ErrorType errorType = ErrorType.BAD_REQUEST;
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }


}
