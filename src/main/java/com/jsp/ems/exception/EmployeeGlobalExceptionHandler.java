package com.jsp.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
	ResponseEntity<String> EmployeeNotFoundExceptionHandler(EmployeeNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(InvalidCredentialsException.class)
   	ResponseEntity<String> InvalidCredentialsException(InvalidCredentialsException ex) {
   		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   	}
}
