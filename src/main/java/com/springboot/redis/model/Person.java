package com.springboot.redis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RedisHash
public class Person implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @Size(min = 3, max = 50)
    @NotBlank
    private String name;

    @Positive
    private Integer age;

    @Valid
    @NotEmpty
    @Reference
    private List<Subject> subjects;

}
