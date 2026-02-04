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

    public void deleteFlight(Flight flight, Long id){
        Flight exisFlight = fRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Flight are Not Found with id "+id));

            fRepository.deleteById(id);
    }

    public void updateFlight(Flight flight, Long id){
        Flight existFlight = fRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Flight are Not Found with id "+id));

            existFlight.setSource(flight.getSource());
            existFlight.setDestination(flight.getDestination());
            existFlight.setFlightDate(flight.getFlightDate());
            existFlight.setDistance(flight.getDistance());
            existFlight.setBasePrice(flight.getBasePrice());
            fRepository.save(existFlight);
    }

}
