package com.job.employee;

import com.job.employee.entity.Employee;
import com.job.employee.entity.EmployeePhone;
import com.job.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(EmployeeRepository employeeRepository) {
		return r -> {
			employeeRepository.save(new Employee("tom", Stream.of(
					new EmployeePhone("012", true),
					new EmployeePhone("013", false)
			).collect(Collectors.toSet())));
		};
	}
}
