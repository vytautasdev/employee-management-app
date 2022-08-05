package com.example.employeedirappmvc;

import com.example.employeedirappmvc.model.Department;
import com.example.employeedirappmvc.repository.DepartmentRepository;
import com.example.employeedirappmvc.service.DepartmentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DepartmentServiceUnitTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @Test
    void testCreate() {
        // GIVEN is our testing data
        final Department TEST_DEPARTMENT = new Department(1l, "IT Department", 33, "AI & ML Department", null);
        final Department TEST_SAVED_DEPARTMENT = new Department(1l, "IT Department", 33, "AI & ML Department", null);
        // WHEN
        Mockito.when(departmentRepository.save(TEST_DEPARTMENT)).thenReturn(TEST_SAVED_DEPARTMENT);
        // THEN
        Assertions.assertThat(departmentService.addDepartment(TEST_DEPARTMENT)).isEqualTo(TEST_SAVED_DEPARTMENT);
        // verify that our repo was accessed exactly once
        Mockito.verify(departmentRepository, Mockito.times(1)).save(TEST_DEPARTMENT);
    }

}
