package com.Trip.ExcelRTripPlaningProject40.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trip.ExcelRTripPlaningProject40.DTO.BookingRequest;
import com.Trip.ExcelRTripPlaningProject40.Entity.Booking;
import com.Trip.ExcelRTripPlaningProject40.Service.BookingService;

@RestController
@RequestMapping("/api/booking/")
public class BookingController {

    private BookingService bService;

    public BookingController(BookingService bService) {
        this.bService = bService;
    }

    @PostMapping("/auto")
    public Booking bookFlight(@RequestBody BookingRequest request){
        return bService.bookFlight(request);
    }
}
