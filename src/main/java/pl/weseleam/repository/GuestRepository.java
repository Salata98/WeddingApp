package pl.weseleam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.weseleam.model.Guest;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Guest findByLogin(String login);

}
