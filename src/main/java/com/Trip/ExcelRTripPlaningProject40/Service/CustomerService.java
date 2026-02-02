package com.Trip.ExcelRTripPlaningProject40.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Trip.ExcelRTripPlaningProject40.DTO.LoginRequest;
import com.Trip.ExcelRTripPlaningProject40.Entity.Customer;
import com.Trip.ExcelRTripPlaningProject40.Repository.CustomerRepository;


@Service
public class CustomerService {

    private CustomerRepository cRepository;
    private PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository cRepository, PasswordEncoder passwordEncoder) {
        this.cRepository = cRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer Register(Customer customer) {
        boolean existCustomer = cRepository.existsByEmail(customer.getEmail());
        if (existCustomer) {
            throw new RuntimeException("Email already Exist");
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setIsActive(false);
        return cRepository.save(customer);
    }

    public Customer Login(LoginRequest request) {
        Customer customer = cRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }
        return customer;
    }
}
