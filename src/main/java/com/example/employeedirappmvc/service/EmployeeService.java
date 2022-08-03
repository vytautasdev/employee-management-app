package com.example.employeedirappmvc.service;

import com.example.employeedirappmvc.dto.EmployeeDTO;
import com.example.employeedirappmvc.exception.EmployeeNotFoundException;
import com.example.employeedirappmvc.model.Employee;
import com.example.employeedirappmvc.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    private EmployeeDTO mapToDTO(Employee employee) {
        return mapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO addEmployee(Employee employee) {
        var saved = employeeRepository.save(employee);
        return mapToDTO(saved);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(Long id, Employee e) {
        var existingOptional = employeeRepository.findById(id);
        var existing = existingOptional.get();

        existing.setFirstName(e.getFirstName());
        existing.setLastName(e.getLastName());
        existing.setEmail(e.getEmail());
        existing.setPassword(e.getPassword());
        existing.setPhoneNumber(e.getPhoneNumber());
        existing.setDob(e.getDob());
        existing.setDepartment(e.getDepartment());

        var updated = employeeRepository.save(existing);
        return mapToDTO(updated);
    }

    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        var exists = employeeRepository.existsById(id);
        return !exists;
    }

    //    public List<EmployeeDTO> getEmployeeByLastName(String lastName) {
    public List<Employee> getEmployeeByLastName(String lastName) {
        return employeeRepository.findEmployeeByLastName(lastName);
    }

    public int checkCredentials(String email, String password) {

        var flag = 0;

        if (!employeeRepository.login(email, password).isEmpty()) {
            flag = 1;
            return flag;
        }
        return flag;
    }

}



