package com.springboot.redis.service;

import com.springboot.redis.dto.PersonDTO;
import com.springboot.redis.exception.PersonNotFoundException;
import com.springboot.redis.mapper.PersonMapper;
import com.springboot.redis.model.Person;
import com.springboot.redis.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public Person findById(String id) {
        return repository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    public List<Person> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Transactional
    public Person insert(PersonDTO personDTO) {
        Person person = mapper.toModel(personDTO);
        return repository.save(person);
    }

    @Transactional
    public Person update(String id, PersonDTO personDTO) {
        Person person = mapper.toModel(personDTO);
        return repository.save(person);
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
    }
}
