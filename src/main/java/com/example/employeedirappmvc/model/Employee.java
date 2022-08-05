package com.example.employeedirappmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Min(2)
    @Max(10)
    private String firstName;

    @NotNull
    @Min(2)
    @Max(10)
    private String lastName;

    @Column(unique = true)
    @NotNull
    private String email;

    @Column(unique = true)
    @NotNull
    private String password;

    @Column(unique = true)
    @NotNull
    private long phoneNumber;

    @Max(10)
    @NotNull
    private String dob;

    @NotNull
    @ManyToOne
    private Department department;


}
