/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Component // <1>
public class DatabaseLoader implements CommandLineRunner { // <2>

	private final EmployeeRepository employeeRepository;
	private final CarRepository carRepository;

	@Autowired // <3>
	public DatabaseLoader(EmployeeRepository employeeRepository, CarRepository carRepository) {
		this.employeeRepository = employeeRepository;
		this.carRepository = carRepository;
	}

	@Override
	public void run(String... strings) throws Exception { // <4>
		this.employeeRepository.save(new Employee("Frodo", "Baggins", "ring bearer"));

		this.carRepository.save(new Car("BMW", "M3", "black", 2019));
		this.carRepository.save(new Car("Mercedes", "AMG S65", "white", 2017));
		this.carRepository.save(new Car("Audi", "RS5", "grey", 2015));
		this.carRepository.save(new Car("Ferrari", "Testarossa", "red", 1989));
		this.carRepository.save(new Car("Porsche", "911 GT2", "orange", 2011));
	}
}
// end::code[]
