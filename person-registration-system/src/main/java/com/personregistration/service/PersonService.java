package com.personregistration.service;

import com.personregistration.dto.PersonDTO;
import com.personregistration.exception.ResourceNotFoundException;
import com.personregistration.exception.DuplicateResourceException;
import com.personregistration.model.Person;
import com.personregistration.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
        return convertToDTO(person);
    }

    public PersonDTO save(PersonDTO personDTO) {
        if (personRepository.existsByCpf(personDTO.getCpf())) {
            throw new DuplicateResourceException("Person with CPF " + personDTO.getCpf() + " already exists");
        }
        
        Person person = convertToEntity(personDTO);
        Person savedPerson = personRepository.save(person);
        return convertToDTO(savedPerson);
    }

    public PersonDTO update(Long id, PersonDTO personDTO) {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
        
        // Check if CPF is being changed to an existing one
        if (!existingPerson.getCpf().equals(personDTO.getCpf()) && 
            personRepository.existsByCpf(personDTO.getCpf())) {
            throw new DuplicateResourceException("Person with CPF " + personDTO.getCpf() + " already exists");
        }
        
        updateEntityFromDTO(existingPerson, personDTO);
        Person updatedPerson = personRepository.save(existingPerson);
        return convertToDTO(updatedPerson);
    }

    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Person not found with id: " + id);
        }
        personRepository.deleteById(id);
    }

    private PersonDTO convertToDTO(Person person) {
        return new PersonDTO(
            person.getId(),
            person.getName(),
            person.getSex(),
            person.getEmail(),
            person.getBirthDate(),
            person.getBirthplace(),
            person.getNationality(),
            person.getCpf(),
            person.getObservation()
        );
    }

    private Person convertToEntity(PersonDTO dto) {
        return new Person(
            dto.getName(),
            dto.getSex(),
            dto.getEmail(),
            dto.getBirthDate(),
            dto.getBirthplace(),
            dto.getNationality(),
            dto.getCpf(),
            dto.getObservation()
        );
    }

    private void updateEntityFromDTO(Person person, PersonDTO dto) {
        person.setName(dto.getName());
        person.setSex(dto.getSex());
        person.setEmail(dto.getEmail());
        person.setBirthDate(dto.getBirthDate());
        person.setBirthplace(dto.getBirthplace());
        person.setNationality(dto.getNationality());
        person.setCpf(dto.getCpf());
        person.setObservation(dto.getObservation());
    }
}
