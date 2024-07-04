package com.springboot.starter.controller;

import com.springboot.starter.bean.Person;
import com.springboot.starter.exception.ErrorCode;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return  Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (person.getResume() == null) {
            //errors.rejectValue("resume", ErrorCode.ERROR_USER_RESUME.getCode(), ErrorCode.ERROR_USER_RESUME.getMessage());
        }
        return;
    }
}
