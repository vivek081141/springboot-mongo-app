package com.springboot.starter.dao;

import com.springboot.starter.bean.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
}
