package com.Trip.ExcelRTripPlaningProject40.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trip.ExcelRTripPlaningProject40.DTO.LoginRequest;
import com.Trip.ExcelRTripPlaningProject40.Entity.Customer;
import com.Trip.ExcelRTripPlaningProject40.Service.CustomerService;


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

    @PutMapping("/setActive/{id}")
    public ResponseEntity<?> setCustomerActive(@PathVariable Long id){
        cService.setCustomerActive(id);
        return ResponseEntity
               .status(HttpStatus.ACCEPTED)
               .body("Customer is Actived with id "+id);
    }

    @PutMapping("/giveRole/{id}")
    public ResponseEntity<?> giveRole(@RequestBody Customer customer, @PathVariable Long id){
        cService.giveRole(customer, id);
        return ResponseEntity
               .status(HttpStatus.ACCEPTED)
               .body("Customer Role Updated for id "+id);
    }
}
