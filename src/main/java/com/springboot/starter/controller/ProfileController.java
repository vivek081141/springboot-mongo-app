package com.springboot.starter.controller;

import com.springboot.starter.bean.Person;
import com.springboot.starter.bean.Profile;
import com.springboot.starter.dao.ProfileRepository;
import com.springboot.starter.dao.PersonRepository;
import java.io.IOException;
import java.util.Optional;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/upload") // //new annotation since 4.3
    public ResponseEntity singleFileUpload(@RequestParam("file") MultipartFile file,
                                           @RequestParam("id") String id) {
        Profile profileEntity = null;
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Optional<Person> personEntity = personRepository.findById(id);
            if (personEntity.isPresent()) {
                Binary binary = new Binary(BsonBinarySubType.BINARY, file.getBytes());
                Profile profile = new Profile();
                profile.setResume(binary);
                profile.setType(file.getContentType());
                profile.setFileSize(String.valueOf(file.getSize()));
                profile.setPersonId(personEntity.get().getPersonId());
                profileEntity = profileRepository.save(profile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(profileEntity);
    }
}
