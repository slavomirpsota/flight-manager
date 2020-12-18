package nl.davinci.example.airline.manager.model.flight;

import java.util.Optional;
import java.util.Set;

import nl.davinci.example.airline.manager.model.seat.NoSeatAvailableException;
import nl.davinci.example.airline.manager.model.seat.Seat;

class Section {

	private final Set<Seat> seats;

	Section(Set<Seat> seats) {
		this.seats = seats;
	}

	public Seat reserveSeat(Grade grade) throws NoSeatAvailableException {
		//TODO implement
		if(grade != null) {
			for(Seat seat : seats) {
				if(seat.getGrade() == grade && seat.isAvailable()) {
					try {
						seat.reserve();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					throw new NoSeatAvailableException();
				}
			}
		}
		return null;
	}

	public void cancelReservation(String seatNumber) {
		try{
			seats.stream().filter(p -> p.getNumber().equals(seatNumber)).findFirst().get().cancelReservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public long countAvailableSeats() {
		return seats.stream().filter(Seat::isAvailable).count();
	}
}
