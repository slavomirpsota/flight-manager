package nl.davinci.example.airline.manager.model.flight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import nl.davinci.example.airline.manager.model.seat.Seat;

public class FlightBuilder {

	private String flightNo;
	private String origin;
	private String destination;
	private long flightDuration;

	private HashMap<Grade, Set<Seat>> seats = new HashMap<>();

	public static FlightBuilder aFlight() {
		return new FlightBuilder();
	}

	public FlightBuilder withFlightNo(String flightNo) {
		this.flightNo = flightNo;
		return this;
	}

	public FlightBuilder withOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public FlightBuilder withDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public FlightBuilder withFlightDuration(long flightDuration) {
		this.flightDuration = flightDuration;
		return this;
	}

	public FlightBuilder addSeats(Grade grade) {
		Set<Seat> seatsForGrade = new HashSet<>();
		seatsForGrade.add(new Seat("1A") {

			@Override
			public Grade getGrade() {
				return grade;
			}
		});
		seatsForGrade.add(new Seat("1B") {

			@Override
			public Grade getGrade() {
				return grade;
			}
		});
		seats.put(grade, seatsForGrade);
		return this;
	}

	public Flight createFlight() {
		return new Flight(flightNo, origin, destination, flightDuration, seats);
	}
}