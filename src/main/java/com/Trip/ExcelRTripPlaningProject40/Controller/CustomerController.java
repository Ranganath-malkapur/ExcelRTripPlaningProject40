package com.Trip.ExcelRTripPlaningProject40.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trip.ExcelRTripPlaningProject40.DTO.LoginRequest;
import com.Trip.ExcelRTripPlaningProject40.Entity.Customer;
import com.Trip.ExcelRTripPlaningProject40.Service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService cService;
    
    public CustomerController(CustomerService cService) {
        this.cService = cService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody Customer customer){
        cService.Register(customer);
        return ResponseEntity
               .status(HttpStatus.CREATED)
               .body("Customer Registered Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginRequest request){
         cService.Login(request);
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body("Customer Login Successfully");
    }
}
