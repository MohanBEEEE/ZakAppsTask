package com.tyss.springsecuritywithhrms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_details")
public class EmployeeDetails implements Serializable{

	private static final long serialVersionUID = 8634395894768198805L;
	
	@Id
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_address")
	private String empAddress;
	
	@Column(name = "emp_phone_num")
	private String empPhoneNum;
	
	@Column(name = "emp_leave_details")
	private int empLeaveDetails;

}
