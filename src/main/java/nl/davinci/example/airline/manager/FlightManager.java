package nl.davinci.example.airline.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import java.util.stream.Collectors;
import nl.davinci.example.airline.manager.model.flight.Flight;
import nl.davinci.example.airline.manager.model.flight.Grade;
import nl.davinci.example.airline.manager.model.seat.Seat;

public class FlightManager {

	private Set<Flight> flights = new HashSet<>();

	public boolean addNewFlight(Flight flight) {
		if(flights.stream().anyMatch(o -> o.equals(flight)))
			return false;
		return flights.add(flight);
	}

	public Optional<Flight> findFlight(String flightNo) {
		return flights.stream().
						filter(p -> p.getFlightNo().
						equals(flightNo)).findFirst();
	}

	public Set<Flight> findAvailableFlights(String destination) {
		return flights.stream().
				filter(p -> p.getDestination().
				equals(destination)).
				collect(Collectors.toSet());
	}

	public Optional<Seat> reserveSeatOnFlight(Flight flight, Grade grade) {
		if(flight != null && grade != null) {
			try{
				return Optional.of(flight.reserveSeat(grade));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return Optional.empty();
	}

	public Optional<Seat> reserveSeatOnFlight(String destination, Grade grade) {
		if (destination != null && grade != null) {
			try {
				Set<Flight> flightsBasedOnDestination = new HashSet<>();
				Flight flight;

				for (Flight f : flights) {
					if (f.getDestination().equals(destination)) {
						flightsBasedOnDestination.add(f);
					}
				}
				if (flightsBasedOnDestination.size() > 1) {
					flight = Collections.min(flights, Comparator.comparing(Flight::getFlightDuration));
					try {
						return Optional.of(flight.reserveSeat(grade));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					return Optional.of(flightsBasedOnDestination.iterator().
							next().
							reserveSeat(grade));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Optional.empty();
	}

	public void cancelReservationForSeat(Flight flight, String seatNumber) {
		if(flight != null && seatNumber != null && flights.contains(flight))
			flights.stream().
					findAny().
					filter(p -> p.equals(flight)).
					get().
					cancelReservation(seatNumber);

	}

	public int getAvailableSeatsOnFlight(Flight flight) {
		int numberOfAvailableSeats = Math.toIntExact(flights.stream().
				findAny().
				filter(p -> p.equals(flight)).
				get().
				countAvailableSeats(Grade.BUSINESS));

		numberOfAvailableSeats += Math.toIntExact(flights.stream().
				findAny().
				filter(p -> p.equals(flight)).
				get().
				countAvailableSeats(Grade.ECONOMY));

		return numberOfAvailableSeats;
		// TODO: Implement - find all available seats for all grades that do exist for given flight
	}
}
