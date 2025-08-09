package com.personregistration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personregistration.dto.AddressDTO;
import com.personregistration.dto.PersonDTO;
import com.personregistration.model.Sex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerV2IT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreatePersonWithAddress() throws Exception {
        AddressDTO addressDTO = new AddressDTO(
            null,
            "123 Main St",
            "456",
            "Apt 1",
            "Downtown",
            "New York",
            "NY",
            "10001"
        );

        PersonDTO personDTO = new PersonDTO(
            null,
            "John Doe",
            Sex.MALE,
            "john.doe@example.com",
            LocalDate.of(1990, 1, 1),
            "New York",
            "American",
            "12345678901",
            "Test person"
        );

        mockMvc.perform(post("/api/v2/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.address.street").value("123 Main St"));
    }
}
