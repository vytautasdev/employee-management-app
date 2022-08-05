package com.example.employeedirappmvc.repository;

import com.example.employeedirappmvc.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d WHERE d.departmentId = ?1")
        //    List<DepartmentDTO> findDepartmentById(Long id);
    List<Department> findDepartmentById(Long id);


}
