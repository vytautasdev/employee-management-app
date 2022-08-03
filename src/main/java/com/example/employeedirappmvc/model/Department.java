package com.example.employeedirappmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;

    @NotNull
    private String departmentName;

    private int numberOfEmployees;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id")
    private Employee employee;


}
