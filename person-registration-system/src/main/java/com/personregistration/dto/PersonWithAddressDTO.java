package com.personregistration.dto;

import com.personregistration.model.Sex;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PersonWithAddressDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private Sex sex;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotBlank(message = "Birthplace is required")
    private String birthplace;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "CPF is required")
    @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
    private String cpf;

    private String observation;

    @Valid
    @NotNull(message = "Address is required")
    private AddressDTO address;

    // Constructors
    public PersonWithAddressDTO() {}

    public PersonWithAddressDTO(Long id, String name, Sex sex, String email, LocalDate birthDate,
                                String birthplace, String nationality, String cpf, String observation,
                                AddressDTO address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.cpf = cpf;
        this.observation = observation;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Sex getSex() { return sex; }
    public void setSex(Sex sex) { this.sex = sex; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getBirthplace() { return birthplace; }
    public void setBirthplace(String birthplace) { this.birthplace = birthplace; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    public AddressDTO getAddress() { return address; }
    public void setAddress(AddressDTO address) { this.address = address; }
}
