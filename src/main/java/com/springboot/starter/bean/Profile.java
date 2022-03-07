package com.springboot.starter.bean;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "profile")
public class Profile {
    @Id
    private String id;
    private String type;
    private String fileSize;
    private String personId;
    private Binary resume;
}
