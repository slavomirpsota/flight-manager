You are working on an application that is responsible for managing flights data.

To complete this task you should fulfill following requirements:

- `Section#reserveSeat(Grade grade)` - reserve a seat in section for the given quality if possible.
- `Flight#reserveSeat` - which should perform a reservation for a passed grade.
- `FlightManager#findFlight(String flightNo)` - which should return an Optional with a flight for a passed flightNo.
- `FlightManager#findAvailableFlights(String destination)` - returns set of flights for the given destination
- `FlightManager#reserveSeatOnFlight(Flight flight, Grade grade)` - which should return an Optional with a seat for a passed flight and quality.
- `FlightManager#reserveSeatOnFlight(String destination, Grade grade)` - which should return an Optional with a seat for a passed destination and quality. If multiple destinations are found, select the one with the lowest duration for the flight. Upon registration of a seat it should be possible to extend existing functionality and reserve also business seat if requested .
- `FlightManager#cancelReservationForSeat(Flight flight, String seatNumber)` - cancel seat reservation for the given flight
- `FlightManager#getAvailableSeatsOnFlight(Flight flight)` - returns the overall number of available seats on given flight

Only implement methods marked with `TODO` or create additional methods or classes if necessary to create reusable/readable code, but do not alter existing method signatures ( their return type, throws clause etc ) , or their visibility/structure.

Do not use any commonly used frameworks such as Spring or Hibernate for implementation of this task - only plain Java is permitted, also no database connection or implementation of JDBC is required, only create main class with `public static void main(String[] args) {}` method which creates initial structure and call some methods to demonstrate the functionality.

Use best practices and pay attention to throws clauses, or abstract classes/methods which has to be properly implemented/extended.

The project is set up using Java 8.

Create a new feature branch (for example `assignment`), commit and push your changes. We will review your implementation after you acknowledge us that your work is finished.
