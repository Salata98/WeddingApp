package pl.weseleam.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goscie")
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gosc")
    private Long id;

    @Column(name = "imie1")
    private String firstName1;

    @Column(name = "nazwisko1")
    private String lastName1;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "haslo")
    private String password;

    @Column(name = "dostep")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_details")
    private GuestDetails details;



    public Guest(){}

    public Guest(String firstName1, String lastName1, String login, String password){
        this.firstName1 = firstName1;
        this.lastName1 = lastName1;
        this.login = login;
        this.password = password;
        this.role = "ROLE_USER";
    }

    public Guest(String firstName1, String lastName1, String login, String password, String role){
        this.firstName1 = firstName1;
        this.lastName1 = lastName1;
        this.login = login;
        this.password = password;
        this.role = role;
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


    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GuestDetails getDetails() {
        return details;
    }

    public void setDetails(GuestDetails details) {
        this.details = details;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName1='" + firstName1 + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", details=" + details +
                '}';
    }
}