package ru.netology.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> UnauthorizedUserHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
