package com.example.employeedirappmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Department with given id does not exist.")
public class DepartmentNotFoundException extends EntityNotFoundException {

    public DepartmentNotFoundException() {

    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
