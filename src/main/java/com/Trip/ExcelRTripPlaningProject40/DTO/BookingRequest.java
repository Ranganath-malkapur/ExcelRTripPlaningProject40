package com.Trip.ExcelRTripPlaningProject40.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private Long id;
    private String passangerName;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private int adults;
}
