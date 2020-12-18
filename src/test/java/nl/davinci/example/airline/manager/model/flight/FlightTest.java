package nl.davinci.example.airline.manager.model.flight;

import org.junit.jupiter.api.Test;

import nl.davinci.example.airline.manager.model.seat.NoSeatAvailableException;
import nl.davinci.example.airline.manager.model.seat.Seat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FlightTest {

	@Test
	public void reservesSeatInPlane() throws NoSeatAvailableException {
		Flight flight = FlightBuilder.aFlight().addSeats(Grade.ECONOMY).createFlight();
		Seat reservedSeat = flight.reserveSeat(Grade.ECONOMY);
		assertThat(reservedSeat.getStatus(), equalTo(Seat.Status.RESERVED));
	}
}
