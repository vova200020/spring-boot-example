package com.ocheret.springbootexample.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CustomerAccessService implements CustomerDao{
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer Alex = new Customer(
                1,
                "Alex",
                "alex@gmail.com",
                22
        );
        customers.add(Alex);
        Customer Sam = new Customer(
                2,
                "Sam",
                "Sam@gmail.com",
                20
        );
        customers.add(Sam);
    }


    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

}
