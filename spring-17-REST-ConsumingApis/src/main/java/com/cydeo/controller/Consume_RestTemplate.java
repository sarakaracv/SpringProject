package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate  {

    private final String URI="https://jsonplaceholder.typicode.com/users";
    private final RestTemplate restTemplate;


    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){
        return restTemplate.getForEntity(URI, User[].class);
    }
}
