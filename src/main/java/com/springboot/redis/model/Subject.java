package com.springboot.redis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RedisHash
public class Subject implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @NotBlank
    private String name;

}
