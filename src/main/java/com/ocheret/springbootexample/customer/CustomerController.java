package com.ocheret.springbootexample.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private CustomerRepository customerRepository;

    public void CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
       //return ResponseEntity.ok(this.customerRepository.findAll());
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Optional<Customer> getCustomers(@PathVariable("customerId")Integer customerId)  {

        return customerService.getCustomer(customerId);
    }
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }
}
