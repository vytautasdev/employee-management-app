package com.example.employeedirappmvc.repository;

import com.example.employeedirappmvc.dto.EmployeeDTO;
import com.example.employeedirappmvc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.lastName = ?1")
    List<Employee> findEmployeeByLastName(String lastName);
//    List<EmployeeDTO> findEmployeeByLastName(String lastName);


    @Query("SELECT e FROM Employee e WHERE e.email = ?1 AND e.password = ?2")
    List<Employee> login(String email, String password);
}
