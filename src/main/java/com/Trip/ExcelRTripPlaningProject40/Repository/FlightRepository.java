package com.Trip.ExcelRTripPlaningProject40.Repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Trip.ExcelRTripPlaningProject40.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

     Optional<Flight> 
      findBySourceIgnoreCaseAndDestinationIgnoreCaseAndFlightDate(String source,
            String destination, LocalDate flightDate);
}
