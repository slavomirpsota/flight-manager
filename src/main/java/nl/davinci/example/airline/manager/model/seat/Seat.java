package nl.davinci.example.airline.manager.model.seat;

import nl.davinci.example.airline.manager.model.flight.Grade;

public abstract class Seat { //TODO - Properly implement necessary classes

	private final String number;

	private Status status = Status.AVAILABLE;

	public Seat(String number) {
		this.number = number;
	}

	public abstract Grade getGrade(); //TODO - implement

	public String getNumber() {
		return number;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isAvailable() {
		return status == Status.AVAILABLE;
	}

	public void reserve() throws SeatAlreadyTakenException {
		if (isAvailable()) {
			status = Status.RESERVED;
		} else {
			throw new SeatAlreadyTakenException();
		}
	}

	public void cancelReservation() {
		status = Status.AVAILABLE;
	}

	public enum Status {
		AVAILABLE, RESERVED
	}
}
