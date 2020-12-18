package nl.davinci.example.airline.manager;

import org.junit.jupiter.api.Test;

import nl.davinci.example.airline.manager.model.flight.Flight;

import static nl.davinci.example.airline.manager.model.flight.FlightBuilder.aFlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FlightManagerTest {

	private static final String FLIGHT_NO = "LO1533";

	private final FlightManager flightManager = new FlightManager();

	@Test
	public void addNewFlight() {
		Flight flight = createFlight();
		flightManager.addNewFlight(flight);
		assertThat(flightManager.findFlight(FLIGHT_NO).isPresent(), equalTo(true));
	}

	@Test
	public void doesNotAddDuplicateFlight() {
		Flight flight = createFlight();
		Flight duplicateflight = createFlight();
		assertThat(flightManager.addNewFlight(flight), equalTo(true));
		assertThat(flightManager.addNewFlight(duplicateflight), equalTo(false));
	}

	private Flight createFlight() {
		return aFlight().withFlightNo(FLIGHT_NO).createFlight();
	}
}
