package pl.weseleam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Dodatkowe_informacje")
public class GuestDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_szczegoly")
    private Long id;

    @Column(name = "menu")
    private Menu menu;

    @Column(name = "nocleg")
    private boolean accommodation;

    @Column(name = "imie_os_tow")
    private String firstNameT;

    @Column(name = "nazwisko_os_tow")
    private String lastNameT;

    @Column(name = "obecnosc")
    private boolean confirm;

    @Column(name = "poprawiny")
    private boolean secondDay;

    @Column(name = "zaszczepiony1")
    private boolean vaccinated1;

    @Column(name = "zaszczepiony2")
    private boolean vaccinatedT;

    @JsonIgnore
    @OneToOne(mappedBy = "details")
    private Guest guest;



    public GuestDetails(){}


    public GuestDetails(Menu menu, String firstNameT, String lastNameT, boolean accommodation, boolean vaccinated1, boolean vaccinatedT){

        this.menu = menu;
        this.accommodation = accommodation;
        this.confirm = false;
        this.secondDay = false;
        this.firstNameT = firstNameT;
        this.lastNameT = lastNameT;
        this.vaccinated1 = vaccinated1;
        this.vaccinatedT = vaccinatedT;
    }

    public GuestDetails(Menu menu, boolean accommodation, boolean vaccinated1){

        this.menu = menu;
        this.accommodation = accommodation;
        this.confirm = false;
        this.secondDay = false;
        this.vaccinated1 = vaccinated1;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccommodation() {
        return accommodation;
    }

    public void setAccommodation(boolean accommodation) {
        this.accommodation = accommodation;
    }

    public String getFirstNameT() {
        return firstNameT;
    }

    public void setFirstNameT(String firstNameT) {
        this.firstNameT = firstNameT;
    }

    public String getLastNameT() {
        return lastNameT;
    }

    public void setLastNameT(String lastNameT) {
        this.lastNameT = lastNameT;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isSecondDay() {
        return secondDay;
    }

    public void setSecondDay(boolean secondDay) {
        this.secondDay = secondDay;
    }

    public boolean isVaccinated1() {
        return vaccinated1;
    }

    public void setVaccinated1(boolean vaccinated1) {
        this.vaccinated1 = vaccinated1;
    }

    public boolean isVaccinatedT() {
        return vaccinatedT;
    }

    public void setVaccinatedT(boolean vaccinatedT) {
        this.vaccinatedT = vaccinatedT;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "GuestDetails{" +
                "id=" + id +
                ", menu=" + menu +
                ", accommodation=" + accommodation +
                ", firstNameT='" + firstNameT + '\'' +
                ", lastNameT='" + lastNameT + '\'' +
                ", confirm=" + confirm +
                ", secondDay=" + secondDay +
                ", vaccinated1=" + vaccinated1 +
                ", vaccinatedT=" + vaccinatedT +
                '}';
    }
}
