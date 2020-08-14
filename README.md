# spring-data-jpa-exercises
SPRING DATA JPA

<br/><h2>Foreword</h2>
<br/>The exercise consists of making the corresponding tests pass. This will require some adaptation within the tests themselves as well as other related classes (Repository...).

<br/>This Hands On has been tested with Eclipse, but any other IDE should work.

<br/><h2>JPA Tests</h2>
<br/>Basically, the application stores customer locations.


<br/><h2>TODO</h2>
<br/>The required setup and data set are already provided. Please complete classes JpaTest and CustomersRepository. This test suite relies on an embedded H2 database.

<br/>Find a customer by its ID (lookup user with id 42)
<br/>Find all customers
<br/>Get paginated customer results (2nd page [page indices are 0-based], 5 people per page)
<br/>Find customers with name equal length chars using explicit queries
<br/>Find first 10 customers by last name (compound sorting)
<br/>Find customers which live in specific countries (Chad & Chile)
<br/>Find customers last updated before a provided date (02/15/2006)
<br/>Stream a list of inactive customers
<br/>Reactivate inactive customers
<br/>Query by nested properties (First name starts with "Car" and live in "Tallahassee" )
