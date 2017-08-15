package com.spring.example.repositories;

import com.spring.example.models.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRespository extends ReactiveCrudRepository<Person, String> {
    Flux<Person> findByName(String name);
}
