package com.example.employeedirappmvc.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    private int department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Department> departmentList = new ArrayList<>();

//
//@ManyToOne
//@JoinColumn(name = "id")
//private Employee employee;

}
