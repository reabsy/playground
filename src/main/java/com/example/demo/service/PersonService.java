package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonModel> getAll() {
        return personRepository.findAll()
                .stream()
                .map(this::convertToPersonModel)
                .collect(Collectors.toList());
    }

    public void add(PersonModel personModel) {
        Person person = Person.builder().name(personModel.getName()).build();
        personRepository.save(person);
    }

    private PersonModel convertToPersonModel(Person person) {
        return PersonModel.builder().name(person.getName()).build();
    }
}
