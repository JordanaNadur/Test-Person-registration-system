package com.personregistration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Builder
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street is required")
    @Column(nullable = false)
    private String street;

    @NotBlank(message = "Number is required")
    @Column(nullable = false)
    private String number;

    private String complement;

    @NotBlank(message = "Neighborhood is required")
    @Column(nullable = false)
    private String neighborhood;

    @NotBlank(message = "City is required")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(nullable = false, length = 2)
    private String state;

    @NotBlank(message = "ZIP code is required")
    @Column(nullable = false, length = 8)
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Person person;

    // Constructors
    public Address() {}

    public Address(String street, String number, String complement, String neighborhood, 
                   String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}
