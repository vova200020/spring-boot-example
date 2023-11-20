package com.ocheret.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class SpringBootExampleApplication {

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
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@GetMapping(path = "api/v1/customers")
	public List<Customer> getCustomers(){
		return customers;
	}

	@GetMapping(path = "api/v1/customers/{customerId}")
	public Customer getCustomers(@PathVariable("customerId")Integer customerId){
		Customer customer= customers.stream()
				.filter(c -> c.id.equals(customerId))
				.findFirst()
				.orElseThrow(
						() -> new IllegalArgumentException("Customer with a given ID not found"));
		return customer;
	}

	static class Customer {
		private Integer id;
		private String name;
		private String email;
		private Integer age;

		public Customer() {}
		public Customer(Integer id, String name, String email, Integer age) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.age = age;
		}

		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public Integer getAge() {
			return age;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Customer customer = (Customer) o;
			return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, name, email, age);
		}

		@Override
		public String toString() {
			return "Customer{" +
					"id=" + id +
					", name='" + name + '\'' +
					", email='" + email + '\'' +
					", age=" + age +
					'}';
		}
	}




}
