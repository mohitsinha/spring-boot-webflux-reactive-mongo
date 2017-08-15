package com.spring.example.controllers;

import com.spring.example.models.Person;
import com.spring.example.repositories.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private PersonRespository personRespository;

    @GetMapping
    public Mono<Person> index(){
        Mono<Person> person = personRespository.save(new Person("John Doe", 24));
        return person;
    }
}
