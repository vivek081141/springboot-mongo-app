package com.springboot.starter.exception;

import java.io.IOException;
import java.util.List;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException exception)
            throws IOException
    {
        StringBuffer errors = new StringBuffer();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String error = fieldError.getField() + ": " + fieldError.getDefaultMessage() + ";";
            errors.append(error);
        }

        ErrorMessage errorMessage = new ErrorMessage(errors.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadInputException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleBadInputException(BadInputException exception)
            throws IOException
    {
        StringBuffer errors = new StringBuffer();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String error = fieldError.getField() + ": " + fieldError.getDefaultMessage() + ";";
            errors.append(error);
        }

        ErrorMessage errorMessage = new ErrorMessage(errors.toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException() {
        ErrorMessage errorMessage = new ErrorMessage("Request format error");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
