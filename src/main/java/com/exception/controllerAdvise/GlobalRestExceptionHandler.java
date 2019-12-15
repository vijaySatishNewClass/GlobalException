package com.exception.controllerAdvise;

import com.exception.globalCustomException.ResourceNotFoundException;
import com.exception.model.ErrorMO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMO errorMO=new ErrorMO(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(errorMO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorMO errorMO=new ErrorMO(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(errorMO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
