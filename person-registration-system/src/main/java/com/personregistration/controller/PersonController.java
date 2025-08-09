package com.personregistration.controller;

import com.personregistration.dto.PersonDTO;
import com.personregistration.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Tag(name = "Person Management", description = "Endpoints for managing persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    @Operation(summary = "Get all persons", description = "Retrieve a list of all registered persons")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> persons = personService.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get person by ID", description = "Retrieve a person by their ID")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        PersonDTO person = personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    @Operation(summary = "Create a new person", description = "Register a new person in the system")
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        PersonDTO createdPerson = personService.save(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update person", description = "Update an existing person's information")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) {
        PersonDTO updatedPerson = personService.update(id, personDTO);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete person", description = "Remove a person from the system")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
