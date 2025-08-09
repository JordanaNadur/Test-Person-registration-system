package com.personregistration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Sex sex;
    
    @Email(message = "Email should be valid")
    @Column(length = 255)
    private String email;
    
    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    @Column(nullable = false)
    private LocalDate birthDate;
    
    @NotBlank(message = "Birthplace is required")
    @Column(nullable = false)
    private String birthplace;
    
    @NotBlank(message = "Nationality is required")
    @Column(nullable = false)
    private String nationality;
    
    @NotBlank(message = "CPF is required")
    @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    
    @Column(columnDefinition = "TEXT")
    private String observation;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // Constructors
    public Person() {}

    public Person(String name, Sex sex, String email, LocalDate birthDate, String birthplace, 
                  String nationality, String cpf, String observation) {
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.cpf = cpf;
        this.observation = observation;
    }

}
