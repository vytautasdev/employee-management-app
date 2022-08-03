package com.example.employeedirappmvc.service;

import com.example.employeedirappmvc.exception.EmployeeNotFoundException;
import com.example.employeedirappmvc.model.Employee;
import com.example.employeedirappmvc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    public List<Employee> readAllEmployees() {
        return employeeRepository.findAll();
    }


    public List<Employee> readEmployeeByLastName(String lastName) {
        return employeeRepository.findEmployeeByLastName(lastName);
    }

    public Employee updateEmployee(Long id, Employee e) {
        var tempEmployee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        var employee = Optional.of(tempEmployee);
        var existing = employee.get();

        existing.setFirstName(e.getFirstName());
        existing.setLastName(e.getLastName());
        existing.setEmail(e.getEmail());


        return employeeRepository.save(existing);
    }

    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        var exists = employeeRepository.existsById(id);
        return !exists;
    }

}
