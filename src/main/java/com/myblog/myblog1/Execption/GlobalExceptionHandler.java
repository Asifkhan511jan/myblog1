package com.myblog.myblog1.Execption;

import com.myblog.myblog1.payload.ErrorDetails;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> HandleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    ) {
        ErrorDetails errorDetails=new ErrorDetails(e.getMessage(), new Date(),webRequest.getDescription(true));
        return  new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
