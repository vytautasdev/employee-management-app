package com.example.employeedirappmvc.controller;

import com.example.employeedirappmvc.dto.EmployeeDTO;
import com.example.employeedirappmvc.model.Employee;
import com.example.employeedirappmvc.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/createEmployee")
    public EmployeeDTO createEmployee(@RequestBody Employee e) {
        return employeeService.addEmployee(e);
    }

    @GetMapping("/readAllEmployees")
    public List<EmployeeDTO> readAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/readByLastName/{lastName}")
//    public List<EmployeeDTO> readByLastName(@PathVariable String lastName) {
    public List<Employee> readByLastName(@PathVariable String lastName) {
        return employeeService.getEmployeeByLastName(lastName);
    }

    @PutMapping("/updateEmployee/{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable Long id, @RequestBody Employee e) {
        return employeeService.updateEmployee(id, e);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/login/{email}/{password}")
    public int login(@PathVariable String email, @PathVariable String password) {
        return employeeService.checkCredentials(email, password);
    }


}
