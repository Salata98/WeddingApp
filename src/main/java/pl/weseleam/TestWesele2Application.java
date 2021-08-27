package pl.weseleam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.weseleam.model.Guest;
import pl.weseleam.model.GuestDetails;
import pl.weseleam.model.GuestPrincipal;
import pl.weseleam.model.Menu;
import pl.weseleam.repository.GuestRepository;

@SpringBootApplication
public class TestWesele2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(TestWesele2Application.class, args);


        GuestRepository guestRepository = ctx.getBean(GuestRepository.class);


        /*
       GuestRepository guestRepo = ctx.getBean(GuestRepository.class);
       Guest guest = new Guest("Imię", "Nazwisko", "login", "pass");


        GuestDetails guestDetails = new GuestDetails(Menu.NORMAL,  true, true);
        guest.setDetails(guestDetails);
       guestRepo.save(guest);
       */





    }

}
