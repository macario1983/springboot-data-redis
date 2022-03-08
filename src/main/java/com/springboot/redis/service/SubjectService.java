package com.springboot.redis.service;

import com.springboot.redis.dto.SubjectDTO;
import com.springboot.redis.exception.SubjectNotFoundException;
import com.springboot.redis.mapper.SubjectMapper;
import com.springboot.redis.model.Subject;
import com.springboot.redis.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SubjectService {

    private final SubjectRepository repository;
    private final SubjectMapper subjectMapper;

    public Subject findById(final String id) {
        return repository.findById(id).orElseThrow(SubjectNotFoundException::new);
    }

    public List<Subject> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Transactional
    public Subject insert(SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toModel(subjectDTO);
        return repository.save(subject);
    }

    @Transactional
    public Subject update(final String id, SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toModel(subjectDTO);
        return repository.save(subject);
    }

    @Transactional
    public void delete(final String id) {
        repository.deleteById(id);
    }
}
