package com.example.employeedirappmvc.controller;

import com.example.employeedirappmvc.model.Employee;
import com.example.employeedirappmvc.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee e) {
        return employeeService.createEmployee(e);
    }

    @GetMapping("/read")
    public List<Employee> readAll() {
        return employeeService.readAllEmployees();
    }


    @GetMapping("/readByLastName/{lastName}")
    public List<Employee> readByLastName(@PathVariable String lastName) {
        return employeeService.readEmployeeByLastName(lastName);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        return employeeService.updateEmployee(id, e);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


}
