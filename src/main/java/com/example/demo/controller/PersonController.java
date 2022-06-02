package com.example.demo.controller;

import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<PersonModel> getAll() {
        return personService.getAll();
    }

    @GetMapping("/add/{name}")
    public String add(@PathVariable String name) {
        personService.add(PersonModel.builder().name(name).build());
        return "added " + name;
    }
}
