package com.tyss.springsecuritywithhrms.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.springsecuritywithhrms.response.StandardResponse;

@ControllerAdvice
public class HrmsExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<StandardResponse> empNotFoundExp(EmployeeNotFoundException exception){
		return ResponseEntity.badRequest().body(StandardResponse.badRequest(exception.getMsg()));
	}
	
	@ExceptionHandler(value = InternalError.class)
	public ResponseEntity<StandardResponse> empInternalServerError(InternalError exception){
		return new ResponseEntity<StandardResponse>(StandardResponse.internalServerError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<StandardResponse> empNoSuchElementException(NoSuchElementException exception){
		return new ResponseEntity<StandardResponse>(StandardResponse.failedError("400", exception.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<StandardResponse> empEmptyResultDataAccessException(EmptyResultDataAccessException exception){
		return new ResponseEntity<StandardResponse>(StandardResponse.failedError("400", exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
