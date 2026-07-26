package org.trial.inventory.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.trial.inventory.dto.CustomException;

@RestControllerAdvice
@Slf4j
public class ErrorHandler extends RuntimeException{

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleException(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(
                CustomException.builder()
                        .statusCode("400")
                        .errorMessage(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<CustomException> handleExceptionWhenServiceIsUnavailable(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.internalServerError().body(
                CustomException.builder()
                        .statusCode("500")
                        .errorMessage(e.getMessage())
                        .build()
        );
    }
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<CustomException> handleExceptionWhenNotFound(Exception e) {
//        log.error(e.getMessage());
//        return ResponseEntity.badRequest().body(
//                CustomException.builder()
//                        .statusCode("400")
//                        .errorMessage(e.getMessage())
//                        .build()
//        );
//
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<CustomException> handleException(Exception e) {
//        log.error(e.getMessage());
//        return ResponseEntity.badRequest().body(
//                CustomException.builder()
//                        .statusCode("400")
//                        .errorMessage(e.getMessage())
//                        .build()
//        );
//    }
}
