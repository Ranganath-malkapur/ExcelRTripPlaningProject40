package com.Trip.ExcelRTripPlaningProject40.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Trip.ExcelRTripPlaningProject40.DTO.CustomerUserDetails;
import com.Trip.ExcelRTripPlaningProject40.Entity.Customer;
import com.Trip.ExcelRTripPlaningProject40.Repository.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private CustomerRepository cRepository;

    public CustomUserDetailsService(CustomerRepository cRepository) {
        this.cRepository = cRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         Customer customer = cRepository.findByEmail(email)
                          .orElseThrow(()-> 
                          new UsernameNotFoundException("User not found with email: "+email));

             return new CustomerUserDetails(customer);
    }


    
}
