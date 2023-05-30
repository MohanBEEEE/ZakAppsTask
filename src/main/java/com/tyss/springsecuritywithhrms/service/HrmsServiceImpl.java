package com.tyss.springsecuritywithhrms.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.springsecuritywithhrms.dto.EmployeeDto;
import com.tyss.springsecuritywithhrms.entity.EmployeeDetails;
import com.tyss.springsecuritywithhrms.exception.EmployeeNotFoundException;
import com.tyss.springsecuritywithhrms.repository.HrmsRepository;
import com.tyss.springsecuritywithhrms.response.HrmsResponseClass;
import com.tyss.springsecuritywithhrms.response.StandardResponse;

@Service
public class HrmsServiceImpl implements HrmsService {

	@Autowired
	private HrmsRepository repository;

	@Override
	public ResponseEntity<HrmsResponseClass> addEmployee(EmployeeDto employeeDto) {
		try {
			if (employeeDto.getEmpId() != 0) {

				EmployeeDetails details = new EmployeeDetails();
				BeanUtils.copyProperties(employeeDto, details);
				EmployeeDetails save = repository.save(details);
				if (save != null && save.getEmpId() != 0) {
					HrmsResponseClass responseClass = new HrmsResponseClass(
							StandardResponse.success("Successfully Created!"), save);
					return ResponseEntity.ok(responseClass);
				}
			} else {
				throw new EmployeeNotFoundException("Please pass valid Employee ID!");
			}
		} catch (Exception e) {
			throw new EmptyResultDataAccessException("Could not save bcz of incorrect/insufficient data! ", 0);
		}
		return null;
	}

	@Override
	public ResponseEntity<HrmsResponseClass> getAllEmployee() {
		List<EmployeeDetails> findAll = repository.findAll();
		if (!findAll.isEmpty()) {
			HrmsResponseClass response = new HrmsResponseClass();
			response.setStdResp(StandardResponse.success("Successfully fetch the emp details!"));
			response.setData(findAll);
			return ResponseEntity.ok(response);
		} else {
			throw new EmployeeNotFoundException("No Employess to fetch!");
		}
	}

	@Override
	public ResponseEntity<StandardResponse> deleteById(int empId) {
		Boolean isDelete = false;
		EmployeeDetails findById = repository.findById(empId).orElseThrow(() -> new NullPointerException("No employee exist with employeeId: "+empId + " please pass the valid employeeId..!"));
		if (findById != null && isDelete!= true) {
			repository.deleteById(empId);
			isDelete = true;
			return ResponseEntity.ok(StandardResponse.success("Successfully Deleted the emp details from DB!"));
		}else {
			throw new NoSuchElementException("No employee exist with employeeId: "+empId + " please pass the valid employeeId..!");
		}
	}

}
