package pl.bykowski.springtransactionexample;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class ReservationService {

    private final TicketRepo ticketRepo;
    private final PassengerRepo passengerRepo;
    private BigDecimal TICKET_PRICE = BigDecimal.valueOf(150);
    private ReservationService2 reservationService2;

    public ReservationService(TicketRepo ticketRepo, PassengerRepo passengerRepo, ReservationService2 reservationService2) {
        this.ticketRepo = ticketRepo;
        this.passengerRepo = passengerRepo;
        this.reservationService2 = reservationService2;
        reserveTicket();
    }

    // Transactional
    // rollback -> RuntimeException + inherited
    // rollbackFor -> Exception + inherited

    @Transactional(rollbackFor = SQLException.class)
    public void reserveTicket() {
        Passenger passenger = new Passenger();
        passenger.setName("Adam");
        passenger.setAccountBalance(BigDecimal.valueOf(200));
        passengerRepo.save(passenger);
        System.out.println(10/0);
    }

    private void get() {
        Passenger passenger = new Passenger();
        passenger.setName("Adam");
        passenger.setAccountBalance(BigDecimal.valueOf(200));
        passengerRepo.save(passenger);
        System.out.println(10/0);
    }
}
