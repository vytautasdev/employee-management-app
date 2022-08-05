package com.example.employeedirappmvc.service;

import com.example.employeedirappmvc.exception.DepartmentNotFoundException;
import com.example.employeedirappmvc.model.Department;
import com.example.employeedirappmvc.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper mapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    private Department mapToDTO(Department department) {
        return mapper.map(department, Department.class);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
    }

    public Department updateDepartment(Long id, Department department) {
        var existingOptional = departmentRepository.findById(id);
        var existing = existingOptional.get();

        existing.setDepartmentName(department.getDepartmentName());
        existing.setDescription(department.getDescription());
        existing.setNumberOfEmployees(department.getNumberOfEmployees());
        existing.setEmployees(department.getEmployees());

        return departmentRepository.save(existing);
    }

    public boolean deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        var exists = departmentRepository.existsById(id);
        return !exists;
    }

}
