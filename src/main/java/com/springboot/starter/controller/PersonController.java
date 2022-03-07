package com.springboot.starter.controller;

import com.springboot.starter.bean.Person;
import com.springboot.starter.dao.PersonRepository;
import com.springboot.starter.exception.BadInputException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/person")
public class PersonController {


    private BeanPropertyBindingResult error;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonValidator personValidator;

    @GetMapping(path = "/getPerson/{id}" )
    public ResponseEntity getPerson(@PathVariable @NotNull String id)  {
        Optional<Person> personEntity = personRepository.findById(id);
        return ResponseEntity.ok().body(personEntity);
    }

    @GetMapping(path = "/getPersons" )
    public ResponseEntity getPersons()  {
        List<Person> personEntity = personRepository.findAll();
        return ResponseEntity.ok().body(personEntity);
    }


    @PostMapping(path = "/createPerson" )
    public ResponseEntity createPerson(@Valid @RequestBody Person person, BindingResult bindingResult)  {
        //BindingResult bindingResult = new BeanPropertyBindingResult(person, "person");
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()){
            throw new BadInputException(bindingResult);
        }
        return ResponseEntity.ok().body(personRepository.save(person));
    }

    @PutMapping(path = "updatePerson")
    public ResponseEntity updatePerson(@RequestBody Person person)  {
        Optional<Person> personEntity = personRepository.findById(person.getPersonId());
        if (personEntity.isPresent()){
            personRepository.save(person);
        }
        return ResponseEntity.ok().body(personEntity);
    }





}
