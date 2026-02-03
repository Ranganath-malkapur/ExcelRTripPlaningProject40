package com.Trip.ExcelRTripPlaningProject40.Service;

import org.springframework.stereotype.Service;

import com.Trip.ExcelRTripPlaningProject40.DTO.BookingRequest;
import com.Trip.ExcelRTripPlaningProject40.Entity.Booking;
import com.Trip.ExcelRTripPlaningProject40.Entity.Customer;
import com.Trip.ExcelRTripPlaningProject40.Entity.Flight;
import com.Trip.ExcelRTripPlaningProject40.Repository.BookingRepository;
import com.Trip.ExcelRTripPlaningProject40.Repository.CustomerRepository;
import com.Trip.ExcelRTripPlaningProject40.Repository.FlightRepository;

@Service
public class BookingService {

    private FlightRepository fRepository;
    private BookingRepository bRepository;
    private CustomerRepository cRepository;

    public BookingService(FlightRepository fRepository, BookingRepository bRepository) {
        this.fRepository = fRepository;
        this.bRepository = bRepository;
    }

    public Booking bookFlight(BookingRequest request){


    
        Flight flight = 
        fRepository.findBySourceIgnoreCaseAndDestinationIgnoreCaseAndFlightDate(
            request.getSource(), request.getDestination(), request.getTravelDate())
            .orElseThrow(()-> new RuntimeException("No flight available for this route/date"));

         double totalPrice = flight.getBasePrice()*request.getAdults();

         Booking booking = new Booking();
         booking.setPassangerName(request.getPassangerName());
         booking.setAdults(request.getAdults());
         booking.setTotalPrice(totalPrice);
         booking.setFlight(flight);

         return bRepository.save(booking);
    }
}
