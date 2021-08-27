package pl.weseleam.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.weseleam.model.Guest;
import pl.weseleam.model.GuestDetails;
import pl.weseleam.model.Menu;
import pl.weseleam.repository.GuestRepository;

import java.util.*;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private GuestRepository guestRepository;

    public AdminController(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    @GetMapping("/confirm")
    public ResponseEntity<List<Guest>> confirmGuestList(){
        List<Guest> guests = guestRepository.findAll();
        List<Guest> confirmGuests = new ArrayList<>();
        for (Guest guest: guests){
            if (guest.getDetails().isConfirm()){
                confirmGuests.add(guest);
            }
        }

        return ResponseEntity.ok(confirmGuests);
    }

    @GetMapping(path = "/confirm/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getConfirmGuestById(@PathVariable Long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/declined")
    public ResponseEntity<List<Guest>> declinedGuestList(){
        List<Guest> guests = guestRepository.findAll();
        List<Guest> declinedGuests = new ArrayList<>();
        for (Guest guest: guests){
            if (!guest.getDetails().isConfirm()){
                declinedGuests.add(guest);
            }
        }

        return ResponseEntity.ok(declinedGuests);
    }

    @GetMapping(path = "/declined/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getDeclinedGuestById(@PathVariable Long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/vaccinated")
    public ResponseEntity<List<Guest>> vaccinatedGuestList(){
        List<Guest> guests = guestRepository.findAll();
        List<Guest> vaccinatedGuests = new ArrayList<>();
        for (Guest guest: guests){
            if (guest.getDetails().isVaccinated1() | guest.getDetails().isVaccinatedT()){
                vaccinatedGuests.add(guest);
            }
        }

        return ResponseEntity.ok(vaccinatedGuests);
    }

    @GetMapping(path = "/vaccinated/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getVaccinatedGuestById(@PathVariable Long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/vegetarian")
    public ResponseEntity<List<Guest>> vegetarianGuestList(){
        List<Guest> guests = guestRepository.findAll();
        List<Guest> vegetarianGuests = new ArrayList<>();
        for (Guest guest: guests){
            if (guest.getDetails().getMenu().equals(Menu.VEGETARIAN)){
                vegetarianGuests.add(guest);
            }
        }

        return ResponseEntity.ok(vegetarianGuests);
    }

    @GetMapping(path = "/vegetarian/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getVegetarianGuestById(@PathVariable Long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/accommodation")
    public ResponseEntity<List<Guest>> accommodationGuestList(){
        List<Guest> guests = guestRepository.findAll();
        List<Guest> accGuests = new ArrayList<>();
        for (Guest guest: guests){
            if (guest.getDetails().isAccommodation()){
                accGuests.add(guest);
            }
        }

        return ResponseEntity.ok(accGuests);
    }

    @GetMapping(path = "/accommodation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getAccommodationGuestById(@PathVariable Long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<Guest>> guestList(){
        List<Guest> guests = guestRepository.findAll();
        return ResponseEntity.ok(guests);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        return guestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/details/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuestDetails> getGuestDetailsById(@PathVariable String login) {
        GuestDetails guestDetails = guestRepository.findByLogin(login).getDetails();
        return ResponseEntity.ok(guestDetails);
    }

    @PostMapping()
    public void savedetails(@RequestBody GuestDetails details){
        Guest guest = guestRepository.findById(details.getId()).get();
        guest.setDetails(details);
        guestRepository.save(guest);
    }




}
