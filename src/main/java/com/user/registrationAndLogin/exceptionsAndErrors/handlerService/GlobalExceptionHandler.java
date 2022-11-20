/*
package com.user.registrationAndLogin.exceptionsAndErrors.handlerService;

import com.user.registrationAndLogin.exceptionsAndErrors.errorResponse.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handle(IllegalStateException exception, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(new ErrorResponse("exception.getMessage()", "exception.getCause().getLocalizedMessage()", "exception.getLocalizedMessage()"));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handle(SQLException exception, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(new ErrorResponse("exception.getMessage()", "exception.getCause().getLocalizedMessage()", "exception.getLocalizedMessage()"));
    }
   */
/* @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handle(HttpMessageNotReadableException exception, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(new ErrorResponse("exception.getMessage()", "exception.getCause().getLocalizedMessage()", "exception.getLocalizedMessage()"));
    }*//*

}
*/
