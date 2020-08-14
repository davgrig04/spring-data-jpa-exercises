package org.springframework.data.samples.jpa;
/*
* Copyright 2012 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.samples.jpa.domain.Customer;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext-jpa.xml")
@Transactional
@Rollback
public class JpaTest {

	@Autowired
	private CustomersRepository repository;

	@Test
	public void should_find_one_customer_by_id() {
        // Find the customer with id 42
		Customer customer = null; // TODO, using repository

		assertThat(customer).isNotNull();
        // Check it matches the given email
		assertThat(customer.getEmail()).isEqualTo(
				"CAROLYN.PEREZ@sakilacustomer.org");
	}

	@Test
	public void should_find_all_customers() {
        // Find all customers
		Iterable<Customer> customers = null; // TODO, using repository
		assertThat(customers).hasSize(599);
	}

	@Test
	public void should_find_second_next_5_customers_sorted_by_last_name() {
        // Retrieve the 5-sized 2nd page of customers, sorted by last name in descending order
        Iterable<Customer> customers = null; // TODO, using the PageRequest

        // Check their last names
        Iterable<String> lastNames = extractProperty("lastName", String.class).from(customers);
        assertThat(lastNames)
				.containsOnly( //
						"WREN", "WOODS", "WOOD", "WOFFORD", "WINDHAM" //
				);
	}

	@Test
	public void can_use_explicit_queries() {
        // Find customers whose first and last names are both 8 chars long
		Iterable<Customer> customers = repository.findWithEqualLengthNames(8); // TODO using an annotated method

		assertThat(extractProperty("id", Long.class).from(customers))
				.containsOnly(514L, 362L, 290L, 207L, 165L);

	}

	
	@Test
	public void should_find_first_10_customers_by_lastname_sorted() {
		
		//Find first 10 customers whose lastName begins with CA, sort by firstName ascending then lastName descending
		Iterable<Customer> customers = null; // TODO, using repository

        Iterable<String> firstNames = extractProperty("firstName", String.class).from(customers);
        assertThat(firstNames)
		.containsExactly( //
				"ALFRED", "ALFRED", "CHAD","CHAD","DANIEL", "EILEEN", "GERTRUDE", "JENNY", "JUNE", "KAY" //
		);
        
        // Check their last names
        Iterable<String> lastNames = extractProperty("lastName", String.class).from(customers);
        assertThat(lastNames)
				.containsExactly( //
						"CASILLAS", "CARTER", "CARBONE", "CAMPBELL", "CABRAL", "CARR", "CASTILLO", "CASTRO", "CARROLL", "CALDWELL" //
				);
	}
	
	@Test
	public void find_customers_in_list_of_countries() {
		// Customers who live in Chad and Chile
		Iterable<Customer> customers = null; // TODO, using repository

		assertThat(extractProperty("email", String.class).from(customers))
				.containsOnly("JANET.PHILLIPS@sakilacustomer.org",
						      "JEROME.KENYON@sakilacustomer.org",
						      "ANDRE.RAPP@sakilacustomer.org",
						      "JAVIER.ELROD@sakilacustomer.org");
	}
	
	
	@Test
	public void find_customers_by_last_updated() {
		// Customers who where last updated before 02/15/2006
		Stream<Customer> customers  = null; // TODO, using repository

		assertThat(customers)
				.isNotNull()
		        .flatExtracting(Customer::getEmail)
				.containsOnly(	"MARY.SMITH@sakilacustomer.org",
							    "PATRICIA.JOHNSON@sakilacustomer.org",
							    "LINDA.WILLIAMS@sakilacustomer.org");
	}
	
	@Test
	public void stream_inactive_customers() {
		// Customers who are INACTIVE
		Stream<Customer> customers  = null; // TODO, using repository

		assertThat(customers)
				.isNotNull()
		        .flatExtracting(Customer::getEmail)
				.containsOnly(	"SANDRA.MARTIN@sakilacustomer.org",
							    "JUDITH.COX@sakilacustomer.org",
							    "SHEILA.WELLS@sakilacustomer.org",
							    "ERICA.MATTHEWS@sakilacustomer.org",
							    "HEIDI.LARSON@sakilacustomer.org",
							    "PENNY.NEAL@sakilacustomer.org",
							    "KENNETH.GOODEN@sakilacustomer.org",
							    "HARRY.ARCE@sakilacustomer.org",
							    "NATHAN.RUNYON@sakilacustomer.org",
							    "THEODORE.CULP@sakilacustomer.org",
							    "MAURICE.CRAWLEY@sakilacustomer.org",
							    "BEN.EASTER@sakilacustomer.org",
							    "CHRISTIAN.JUNG@sakilacustomer.org",
							    "JIMMIE.EGGLESTON@sakilacustomer.org",
							    "TERRANCE.ROUSH@sakilacustomer.org");
	}
	
	@Test
	public void update_inactive_customers() {
		// Customers who are INACTIVE
		Long inactiveCustomers = -1L;// TODO, get count using repository
		assertThat(inactiveCustomers).isGreaterThan(0L);
		
		// TODO, update customers to Active using repository
		
		inactiveCustomers = -1L;// TODO, get count using repository
		assertThat(inactiveCustomers).isEqualTo(0L);
	}
	
	@Test
	public void query_by_nested_properties() {
		// Customers whose firstName starts with "Car" (ignore case)
//		// and whose city address is Tallahassee
		Iterable<Customer> customers = null; // TODO, using repository

		assertThat(extractProperty("email", String.class).from(customers))
				.containsOnly("CAROLINE.BOWMAN@sakilacustomer.org");
	}
}
