package com.tyss.springsecuritywithhrms.service;

import org.springframework.http.ResponseEntity;

import com.tyss.springsecuritywithhrms.dto.EmployeeDto;
import com.tyss.springsecuritywithhrms.response.HrmsResponseClass;
import com.tyss.springsecuritywithhrms.response.StandardResponse;

public interface HrmsService {

	public ResponseEntity<HrmsResponseClass> addEmployee(EmployeeDto employeeDto);

	public ResponseEntity<HrmsResponseClass> getAllEmployee();

	public ResponseEntity<StandardResponse> deleteById(int empId);

}
