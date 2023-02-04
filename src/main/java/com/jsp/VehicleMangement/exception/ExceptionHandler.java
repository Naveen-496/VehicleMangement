package com.jsp.VehicleMangement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> handleVehicleNotFoundException(VehicleNotFoundException vehicleNotFoundException){
        return new ResponseEntity<>( vehicleNotFoundException.getMessage() , HttpStatus.NOT_FOUND);
    }
}
