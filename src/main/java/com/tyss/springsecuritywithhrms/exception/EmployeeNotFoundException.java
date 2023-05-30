package com.tyss.springsecuritywithhrms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6075832253189993051L;
	
	private String msg;

}
