package com.tyss.springsecuritywithhrms.response;

import java.io.Serializable;

import com.tyss.springsecuritywithhrms.entity.EmployeeDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrmsResponseClass implements Serializable {
	
	private static final long serialVersionUID = -2412838356588404369L;
	
	private StandardResponse stdResp;
	private Object data;

}
