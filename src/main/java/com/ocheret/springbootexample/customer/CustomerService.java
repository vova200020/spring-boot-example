package com.ocheret.springbootexample.customer;

import com.ocheret.springbootexample.exception.APIExceptionHandler;
import com.ocheret.springbootexample.exception.APIRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerDao customerDao;
    public Optional<Customer> getCustomer(Integer id) throws APIRequestException {
        if (customerDao.selectCustomerById(id).isEmpty()){
            throw new APIRequestException("Customer with a given id is not found");

        }
        else{
            return  customerDao.selectCustomerById(id);
        }


    }

    public CustomerService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }
}
