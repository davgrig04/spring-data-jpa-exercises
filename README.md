# spring-data-jpa-exercises
SPRING DATA JPA

Foreword
The exercise consists of making the corresponding tests pass. This will require some adaptation within the tests themselves as well as other related classes (Repository...).

This Hands On has been tested with Eclipse, but any other IDE should work.

JPA Tests
Basically, the application stores customer locations. The domain is modeled as follows:

Customers Data Model

TODO
The required setup and data set are already provided. Please complete classes JpaTest and CustomersRepository. This test suite relies on an embedded H2 database.

Find a customer by its ID (lookup user with id 42)
Find all customers
Get paginated customer results (2nd page [page indices are 0-based], 5 people per page)
Find customers with name equal length chars using explicit queries
Find first 10 customers by last name (compound sorting)
Find customers which live in specific countries (Chad & Chile)
Find customers last updated before a provided date (02/15/2006)
Stream a list of inactive customers
Reactivate inactive customers
Query by nested properties (First name starts with "Car" and live in "Tallahassee" )
