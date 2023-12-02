package com.ocheret.springbootexample.customer;

import com.ocheret.springbootexample.exception.APIExceptionHandler;
import com.ocheret.springbootexample.exception.APIRequestException;
import com.ocheret.springbootexample.exception.DuplicateResourceException;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){

       //breaks when rtying to generate query(Maybe) but
        //without it works fine so i have commented it for now.
        String email = customerRegistrationRequest.email();
//        if(customerDao.existsPersonWithEmail(email)){
//            throw new DuplicateResourceException("Record with a given email is already taken");
//        }
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        );
        customerDao.insertCustomer(customer);
    }
}
