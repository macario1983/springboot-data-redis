package com.springboot.redis.controller;

import com.springboot.redis.dto.PersonDTO;
import com.springboot.redis.model.Person;
import com.springboot.redis.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService service;

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Person> insert(@Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(personDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@PathVariable String id, @Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(service.update(id, personDTO));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

