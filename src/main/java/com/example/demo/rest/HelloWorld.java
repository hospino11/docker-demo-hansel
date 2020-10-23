package com.example.demo.rest;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.rest.dto.PersonDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class HelloWorld {

    private final MongoTemplate mongoTemplate;

    @GetMapping("/test/greeting")
    public String greeting() {
        return "Hello World";
    }

    @PostMapping("/person")
    public ResponseEntity createPerson(@RequestBody PersonDto newPerson) {

        MongoOperations mongoOps = mongoTemplate;
        mongoOps.insert(Person.builder().name(newPerson.getName()).age(newPerson.getAge()).build());
        log.info(mongoOps.findOne(new Query(where("name").is(newPerson.getName())), Person.class));

        return ResponseEntity.noContent().build();
    }
}
