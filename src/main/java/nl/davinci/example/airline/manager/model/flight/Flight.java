package nl.davinci.example.airline.manager.model.flight;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import nl.davinci.example.airline.manager.model.seat.NoSeatAvailableException;
import nl.davinci.example.airline.manager.model.seat.Seat;

public class Flight {

	private final String flightNo;

	private final String origin;

	private final String destination;

	private final long flightDuration;

	private Map<Grade, Section> sectionMap = new HashMap<>();

	public Flight(String flightNo, String origin, String destination, long flightDuration, Map<Grade, Set<Seat>> seats) {
		if (flightNo == null) {
			throw new IllegalArgumentException("Flight number cannot be empty");
		}
		this.flightNo = flightNo;
		this.origin = origin;
		this.destination = destination;
		this.flightDuration = flightDuration;
		seats.forEach((key, value) -> sectionMap.put(key, new Section(value)));
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public long getFlightDuration() {
		return flightDuration;
	}

	public Seat reserveSeat(Grade grade) throws NoSeatAvailableException {
		Section section = sectionMap.get(grade); // TODO: Implement
		return section.reserveSeat(grade);
	}
	
	public void cancelReservation(String seatNumber) {
		for(Section s : sectionMap.values()) {
			s.getSeats().stream().
					filter(p -> p.getNumber().
					equals(seatNumber)).
					findFirst().get().
					cancelReservation();
		}
	}

	public long countAvailableSeats(Grade grade) {
		return sectionMap.getOrDefault(grade, new Section(Collections.emptySet())).countAvailableSeats();
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Flight objToCompare = (Flight) obj;
		return this.getFlightNo().equals(objToCompare.getFlightNo());
	}
}
