package com.ocheret.springbootexample;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@GetMapping("/greet")
		public GreetResponse greet(){
			return new GreetResponse(
					"Hello",
					List.of("Java","Golang", "JavaScript"),
					new Person("Vlad", 23, 30000)
			);
		};

	record Person(String name, int age, double savings){

	}
	record GreetResponse(
			String greet,
			List<String> favProgrammingLang,
			Person person

	){}

	/*class GreetResponse{
		private final String greet;

		GreetResponse(String greet){
			this.greet = greet;
		}

		public String getGreet(){
			return greet;
		}
	}*/
}
