package com.personregistration.repository;

import com.personregistration.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByCpf(String cpf);
    Optional<Person> findByCpf(String cpf);
}
