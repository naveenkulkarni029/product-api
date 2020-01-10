package org.nbk.product.global.exception;

import org.nbk.product.response.domain.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class ProductsControllerAdvice {

	@Autowired
	private ObjectMapper objectMapper;

	@ExceptionHandler(value = { HttpClientErrorException.class })
	public ResponseEntity<ServiceError> handleClientException(HttpClientErrorException exception) throws Exception {
		ServiceError se = objectMapper.readValue(exception.getResponseBodyAsString(), ServiceError.class);
		ServiceError serviceError = new ServiceError(HttpStatus.NOT_FOUND.toString(), se.getMessage(), se.getUri());
		return new ResponseEntity<ServiceError>(serviceError, HttpStatus.NOT_FOUND);
	}

}
