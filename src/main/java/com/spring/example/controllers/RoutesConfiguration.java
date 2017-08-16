package com.spring.example.controllers;

import com.spring.example.models.Person;
import com.spring.example.repositories.PersonRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfiguration {

    @Bean
    RouterFunction<?> routes(PersonRespository personRespository) {
        return route(RequestPredicates.GET("/person"),
          request->ok().body(personRespository.findAll(), Person.class))
          .andRoute(RequestPredicates.GET("/person/{id}"),
            request->ok().body(personRespository.findById(request.pathVariable("id")), Person.class));
    }
}
