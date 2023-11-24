package com.ocheret.springbootexample.customer;

import com.ocheret.springbootexample.exception.APIExceptionHandler;
import com.ocheret.springbootexample.exception.APIRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "api/v1/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "api/v1/customers/{customerId}")
    public Optional<Customer> getCustomers(@PathVariable("customerId")Integer customerId)  {
   // throw new APIRequestException("No Customer with this ID");

        return customerService.getCustomer(customerId);
    }
}
