package com.example.employeedirappmvc;

import com.example.employeedirappmvc.model.Department;
import com.example.employeedirappmvc.model.Employee;
import com.example.employeedirappmvc.repository.EmployeeRepository;
import com.example.employeedirappmvc.service.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class EmployeeServiceUnitTest {

    @Autowired
    private EmployeeService employeeService;


    private Department department;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    void testCreate() {
        // GIVEN is our testing data
        final Employee TEST_EMPLOYEE = new Employee(1l, "Upasana", "Dew", "uppu@gmail.com", "1234", 45465454l, "1990-01-01", null);
        final Employee TEST_SAVED_EMPLOYEE = new Employee(1l, "Upasana", "Dew", "uppu@gmail.com", "1234", 45465454l, "1990-01-01", null);
        // WHEN
        Mockito.when(employeeRepository.save(TEST_EMPLOYEE)).thenReturn(TEST_SAVED_EMPLOYEE);
        // THEN
        Assertions.assertThat(employeeService.addEmployee(TEST_EMPLOYEE)).isEqualTo(TEST_SAVED_EMPLOYEE);
        // verify that our repo was accessed exactly once
        Mockito.verify(employeeRepository, Mockito.times(1)).save(TEST_EMPLOYEE);
    }

}
