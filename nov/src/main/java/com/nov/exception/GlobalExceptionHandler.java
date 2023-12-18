package com.nov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ProblemDetail> idNotFoundException(IdNotFoundException ex)
{
    ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    detail.setProperty("message",ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detail);
}
}
