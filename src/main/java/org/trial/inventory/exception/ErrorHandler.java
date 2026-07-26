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
public class ErrorHandler {

    @ExceptionHandler
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
//
//    @ExceptionHandler --500
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<CustomException> handleException(Exception e) {
//        log.error(e.getMessage());
//        return ResponseEntity.badRequest().body(
//                CustomException.builder()
//                        .statusCode("400")
//                        .errorMessage(e.getMessage())
//                        .build()
//        );
//    }@ExceptionHandler -- 404
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<CustomException> handleException(Exception e) {
//        log.error(e.getMessage());
//        return ResponseEntity.badRequest().body(
//                CustomException.builder()
//                        .statusCode("400")
//                        .errorMessage(e.getMessage())
//                        .build()
//        );

//    }@ExceptionHandler --403
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
