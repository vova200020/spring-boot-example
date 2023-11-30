package com.ocheret.springbootexample.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;

    public void CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "api/v1/customers")
    public List<Customer> getCustomers(){
       //return ResponseEntity.ok(this.customerRepository.findAll());
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "api/v1/customers/{customerId}")
    public Optional<Customer> getCustomers(@PathVariable("customerId")Integer customerId)  {

        return customerService.getCustomer(customerId);
    }
}
