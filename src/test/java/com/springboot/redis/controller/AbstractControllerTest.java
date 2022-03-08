package com.springboot.redis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.redis.configuration.FixtureFactoryConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@AutoConfigureMockMvc(print = MockMvcPrint.LOG_DEBUG)
@DirtiesContext
@Import(FixtureFactoryConfiguration.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Testcontainers
public abstract class AbstractControllerTest {

    @Container
    private static final GenericContainer CONTAINER = new GenericContainer("redis:alpine3.15")
            .withExposedPorts(6379);

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("pring.redis.host", CONTAINER::getHost);
        registry.add("spring.redis.port", () -> CONTAINER.getMappedPort(6379));
    }
}
