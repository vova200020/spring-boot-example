package com.ocheret.springbootexample;

import com.ocheret.springbootexample.customer.Customer;
import com.ocheret.springbootexample.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Main {


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args -> {


			Customer Alex = new Customer(
					"Alex",
					"alex@gmail.com",
					22
			);

			Customer Sam = new Customer(

					"Sam",
					"Sam@gmail.com",
					20
			);

			List<Customer> customers = List.of(Alex,Sam);
			customerRepository.saveAll(customers);

		};
	}
}
