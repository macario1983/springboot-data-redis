package com.springboot.redis.mapper;


import com.springboot.redis.dto.PersonDTO;
import com.springboot.redis.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO toDTO(Person person);

    Person toModel(PersonDTO personDTO);

}
