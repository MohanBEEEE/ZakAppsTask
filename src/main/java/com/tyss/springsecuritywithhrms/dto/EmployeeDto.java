package com.tyss.springsecuritywithhrms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
	private static final long serialVersionUID = 3582985655209286924L;
	
	private int empId;
	private String empName;
	private String empAddress;
	private String empPhoneNum;
	private int empLeaveDetails;
}
