package org.trial.inventory.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.trial.inventory.dto.CustomException;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomException> handleBadRequest(IllegalArgumentException e) {

        log.error("Bad Request: {}", e.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        CustomException.builder()
                                .statusCode("400")
                                .errorMessage(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomException> handleGeneralException(Exception e) {

        log.error("Internal Server Error", e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        CustomException.builder()
                                .statusCode("500")
                                .errorMessage("Internal server error")
                                .build()
                );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomException> handleNotFound(ResourceNotFoundException e) {

        log.error("Resource not found: {}", e.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        CustomException.builder()
                                .statusCode("404")
                                .errorMessage(e.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<CustomException> handleAccessDenied(AccessDeniedException e) {

        log.error("Access Denied: {}", e.getMessage());

        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(
                        CustomException.builder()
                                .statusCode("403")
                                .errorMessage("You do not have permission to access this resource")
                                .build()
                );
    }
}
