package com.springboot.starter.bean;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Slf4j
@Document(collection = "Person")
public class Person {

    @Id
    private String personId;

    @NotBlank(message = "Name should not be blank.")
    private String name;

    @NotEmpty(message = "Address should not be empty")
    private String address;

    @NotEmpty(message = "Hobby should not be empty")
    private List<String> hobbies;

    private Binary resume;

    public String toString() {
        String var10000 = this.getName();
        String str = "Person(name=" + var10000 + ", id=" + this.getPersonId() + ", hobbies=" + this.getHobbies() + ")";
        log.info(str);
        return str;
    }
}
