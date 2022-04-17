package pl.bykowski.springtransactionexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@SpringBootApplication
@RestController
public class SpringTransactionExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionExampleApplication.class, args);
    }

    private final ReservationService reservationService;

    public SpringTransactionExampleApplication(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws SQLException {
        reservationService.reserveTicket();
    }
}
