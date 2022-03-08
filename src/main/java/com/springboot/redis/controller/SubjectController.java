package com.springboot.redis.controller;

import com.springboot.redis.dto.SubjectDTO;
import com.springboot.redis.model.Subject;
import com.springboot.redis.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("subjects")
public class SubjectController {

    private final SubjectService service;

    @GetMapping("{id}")
    public ResponseEntity<Subject> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Subject>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Subject> insert(@Valid @RequestBody SubjectDTO subjectDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(subjectDTO));
    }

    @PutMapping
    public ResponseEntity<Subject> update(@PathVariable String id, @Valid @RequestBody SubjectDTO subjectDTO) {
        return ResponseEntity.ok(service.update(id, subjectDTO));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
