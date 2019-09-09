package com.microservice.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	/**Gernal Exception
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value={Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorMessageDescripter = ex.getLocalizedMessage();

		if (errorMessageDescripter == null)
			errorMessageDescripter = ex.toString();

		ErrorMessage errormessage = new ErrorMessage(new Date(), errorMessageDescripter);

		return new ResponseEntity<>(
				errormessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * NullPointer Exception
	 * @param ex
	 * @param request
	 * @return
	 */
	
	@ExceptionHandler(value={NullPointerException.class})
	public ResponseEntity<Object> handleAnyNullPointerException(NullPointerException ex, WebRequest request) {

		String errorMessageDescripter = ex.getLocalizedMessage();

		if (errorMessageDescripter == null)
			errorMessageDescripter = ex.toString();

		ErrorMessage errormessage = new ErrorMessage(new Date(), errorMessageDescripter);

		return new ResponseEntity<>(
				errormessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}
