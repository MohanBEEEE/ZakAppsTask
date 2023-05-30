package com.tyss.springsecuritywithhrms.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springsecuritywithhrms.dto.EmployeeDto;
import com.tyss.springsecuritywithhrms.exception.EmployeeNotFoundException;
import com.tyss.springsecuritywithhrms.response.HrmsResponseClass;
import com.tyss.springsecuritywithhrms.response.StandardResponse;
import com.tyss.springsecuritywithhrms.service.HrmsService;

@RestController
@RequestMapping(path = "/api/v1")
public class HrmsController {

	@Autowired
	private HrmsService hrmsService;

	@GetMapping(path = "/test")
	public String test() {
		return "<h1> Hello </h1>";
	}

	@PostMapping(path = "/addEmp")
	public ResponseEntity<HrmsResponseClass> createEmployee(@RequestBody EmployeeDto employeeDto) {
		try {
			if (employeeDto != null) {
				ResponseEntity<HrmsResponseClass> addEmployee = hrmsService.addEmployee(employeeDto);
				if (addEmployee != null)
					return addEmployee;
				else
					throw new EmployeeNotFoundException("Please provide all the fields with valid data!");
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
		return null;
	}

	@GetMapping(path = "/readAllEmp")
	public ResponseEntity<HrmsResponseClass> getAllEmployee() {
		try {
			ResponseEntity<HrmsResponseClass> allEmployee = hrmsService.getAllEmployee();
			if (allEmployee != null) {
				return allEmployee;
			} else {
				throw new EmployeeNotFoundException("No Employee found!");
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		}
	}

	@DeleteMapping(path = "/deleteById/{empId}")
	public ResponseEntity<StandardResponse> deleteById(@PathVariable int empId) {
		try {
			if(empId !=0) {
				ResponseEntity<StandardResponse> deleteById = hrmsService.deleteById(empId);
				return deleteById;
			}else {
				throw new EmployeeNotFoundException("No Employee found! for give ID: "+empId);
			}
		}catch(Exception e) {
			throw new NoSuchElementException("No employee exist with employeeId: "+empId + " please pass the valid employeeId..!");
		}
	}
	
}
