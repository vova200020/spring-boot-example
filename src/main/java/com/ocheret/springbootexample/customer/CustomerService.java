package com.ocheret.springbootexample.customer;

import com.ocheret.springbootexample.exception.APIExceptionHandler;
import com.ocheret.springbootexample.exception.APIRequestException;
import com.ocheret.springbootexample.exception.ApiException;
import com.ocheret.springbootexample.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    private final CustomerDao customerDao;
    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id);
                throw new APIExceptionHandler();
    }

    public CustomerService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }
}
