package com.tyss.springsecuritywithhrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.springsecuritywithhrms.entity.EmployeeDetails;

@Repository
public interface HrmsRepository extends JpaRepository<EmployeeDetails, Integer> {

}
