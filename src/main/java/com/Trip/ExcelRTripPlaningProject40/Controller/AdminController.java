package com.Trip.ExcelRTripPlaningProject40.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trip.ExcelRTripPlaningProject40.Entity.Flight;
import com.Trip.ExcelRTripPlaningProject40.Service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService aService;

    public AdminController(AdminService aService) {
        this.aService = aService;
    }

    @PostMapping("/addFlight")
    public Flight addFlight(@RequestBody Flight flight){
        return aService.addFlight(flight);
    }

    @GetMapping("/viewFlights")
    public List<Flight> viewFlights(){
        return aService.viewAllFlights();
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<?> deleteFlight(@RequestBody Flight flight, @PathVariable Long id){
        aService.deleteFlight(flight, id);
        return ResponseEntity
               .status(HttpStatus.OK)
               .body("Delete Flight Successfully");
               
    }

    @PutMapping("/updateFlight/{id}")
    public ResponseEntity<?> editFlight(@RequestBody Flight flight, @PathVariable Long id){
        aService.updateFlight(flight, id);
        return ResponseEntity
               .status(HttpStatus.ACCEPTED)
               .body("Flight Updated Successfully with id "+id);
    }

}
