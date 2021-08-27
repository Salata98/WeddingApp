package pl.weseleam.controller;


import org.springframework.web.bind.annotation.*;
import pl.weseleam.model.DetailRespond;
import pl.weseleam.model.Guest;
import pl.weseleam.model.GuestDetails;
import pl.weseleam.repository.GuestRepository;
import java.security.Principal;



@RestController
@RequestMapping("/api/guest")
public class GuestController {

    private GuestRepository guestRepository;
    private Guest principalGuest;
    private DetailRespond weddingRespond;
    private DetailRespond secondDayRespond;
    private DetailRespond menuRespond;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping()
    public Guest guest(Principal principal) {

            principalGuest = guestRepository.findByLogin(principal.getName());

        return principalGuest;
    }



    @GetMapping("/wedding")
    public DetailRespond weddingConfirm() {

        if (weddingRespond==null){
            weddingRespond = new DetailRespond();
        }

        if (principalGuest.getDetails().isConfirm()){
                weddingRespond.setResponse("Tak!");
        } else {
            weddingRespond.setResponse("Niestety nie");
        }
        return weddingRespond;
    }

    @GetMapping("/secondday")
    public DetailRespond secondDayConfirm() {

        if (secondDayRespond==null){
            secondDayRespond = new DetailRespond();
        }

        if (principalGuest.getDetails().isSecondDay()){
            secondDayRespond.setResponse("Tak!");
        } else {
            secondDayRespond.setResponse("Niestety nie");
        }
        return secondDayRespond;
    }

    @GetMapping("/menu")
    public DetailRespond menuChoice() {

        if (menuRespond==null){
            menuRespond = new DetailRespond();
        }

        menuRespond.setResponse(principalGuest.getDetails().getMenu().getDescription());
        return menuRespond;
    }

    @PostMapping("/setdetails")
    public void savedetails(@RequestBody GuestDetails details){
        Long id = principalGuest.getDetails().getId();
        details.setId(id);
        String nameT = principalGuest.getDetails().getFirstNameT();
        details.setFirstNameT(nameT);
        String lastNameT = principalGuest.getDetails().getLastNameT();
        details.setLastNameT(lastNameT);
        boolean accomodation = principalGuest.getDetails().isAccommodation();
        details.setAccommodation(accomodation);
        boolean vaccinated1 = principalGuest.getDetails().isVaccinated1();
        details.setVaccinated1(vaccinated1);
        boolean vaccinatedT = principalGuest.getDetails().isVaccinatedT();
        details.setVaccinatedT(vaccinatedT);
        principalGuest.setDetails(details);
        guestRepository.save(principalGuest);
    }


    }
