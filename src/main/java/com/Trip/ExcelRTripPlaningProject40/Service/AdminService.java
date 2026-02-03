package com.Trip.ExcelRTripPlaningProject40.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Trip.ExcelRTripPlaningProject40.Entity.Flight;
import com.Trip.ExcelRTripPlaningProject40.Repository.CustomerRepository;
import com.Trip.ExcelRTripPlaningProject40.Repository.FlightRepository;

@Service
public class AdminService {

    private FlightRepository fRepository;

    public AdminService(FlightRepository fRepository) {
        this.fRepository = fRepository;
    }

    public Flight addFlight(Flight flight){
        return fRepository.save(flight);
    }

    public List<Flight> viewAllFlights(){
        return fRepository.findAll();
    }
}
