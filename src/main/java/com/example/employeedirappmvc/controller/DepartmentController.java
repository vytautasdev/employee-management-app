package com.example.employeedirappmvc.controller;

import com.example.employeedirappmvc.model.Department;
import com.example.employeedirappmvc.repository.DepartmentRepository;
import com.example.employeedirappmvc.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private DepartmentService departmentService;

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentService departmentService, DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/createDepartment")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping("/readAllDepartments")
    public List<Department> readAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/readDepartmentById/{id}")
    public List<Department> readDepartmentById(@PathVariable Long id) {
        return departmentRepository.findDepartmentById(id);
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
