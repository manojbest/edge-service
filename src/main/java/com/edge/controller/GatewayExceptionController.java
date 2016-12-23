package com.edge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.edge.model.ErrorResponse;

@ControllerAdvice
@RestController
public class GatewayExceptionController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<ErrorResponse> handleException(final HttpClientErrorException ex) {
		logger.error("> handleException");
		logger.error("- Exception: ", ex);
		logger.error("< handleException");
		
		ResponseEntity<ErrorResponse> errorResponseEntity = null;
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("failure");
		errorResponse.setStackTrace(ex.getStackTrace());
		errorResponse.setRootCause(ex.getResponseBodyAsString());
		if (400 == ex.getRawStatusCode()) {
			errorResponse.setMessage("Invalid Request Parameters");
			errorResponseEntity = new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		return errorResponseEntity;
	}
	
	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<ErrorResponse> handleException(final ResourceAccessException ex) {
		logger.error("> handleException");
		logger.error("- Exception: ", ex);
		logger.error("< handleException");
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("error");
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<ErrorResponse> handleException(final IllegalStateException ex) {
		logger.error("> handleException");
		logger.error("- Exception: ", ex);
		logger.error("< handleException");
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("error");
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(final Exception ex) {
		logger.error("> handleException");
		logger.error("- Exception: ", ex);
		logger.error("< handleException");
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("error");
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
