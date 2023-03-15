package org.dev.springbootcrud.globalexceptions;

import java.util.NoSuchElementException;

import org.dev.springbootcrud.customexception.EmptyInputException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyException(EmptyInputException emptyInputException) {
		return new ResponseEntity<String>("Input field is empty, please have a look into it", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		return new ResponseEntity<String>("No value present in DB, please change the request", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(
			EmptyResultDataAccessException emptyResultDataAccessException) {

		return new ResponseEntity<String>("Cannot delete empty record, please change the request",
				HttpStatus.BAD_REQUEST);
	}
}
