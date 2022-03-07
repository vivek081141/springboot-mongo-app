package com.springboot.starter.exception;

import org.springframework.validation.BindingResult;

public class BadInputException extends RuntimeException
{
    private BindingResult bindingResult;

    public BadInputException(String message)
    {
        super(message);
    }

    public BadInputException(BindingResult bindingResult)
    {
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult()
    {
        return bindingResult;
    }
}
