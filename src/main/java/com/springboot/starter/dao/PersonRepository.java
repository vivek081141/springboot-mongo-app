package com.springboot.starter.dao;

import com.springboot.starter.bean.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
