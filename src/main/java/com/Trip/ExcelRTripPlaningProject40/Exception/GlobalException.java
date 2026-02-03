package com.Trip.ExcelRTripPlaningProject40.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class GlobalException {
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> HandleRuntimeException(RuntimeException ex){
         Map<String, Object> error = new HashMap<>();
         error.put("Status", HttpStatus.UNAUTHORIZED);
         error.put("Message", ex.getMessage());
         error.put("TimeStamp", LocalDateTime.now());

         return error;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> HandleNullPointerException(NullPointerException ex){
        Map<String, Object> error = new HashMap<>();
        error.put("Status", HttpStatus.BAD_REQUEST);
        error.put("Message", ex.getMessage());
        error.put("TimeStamp", LocalDateTime.now());
        
        return error;
    }
}
