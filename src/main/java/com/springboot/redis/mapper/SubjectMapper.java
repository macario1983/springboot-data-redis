package com.springboot.redis.mapper;


import com.springboot.redis.dto.SubjectDTO;
import com.springboot.redis.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDTO(Subject subject);

    Subject toModel(SubjectDTO subjectDTO);

}
