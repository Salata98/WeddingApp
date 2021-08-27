package pl.weseleam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.weseleam.model.Guest;
import pl.weseleam.model.GuestPrincipal;
import pl.weseleam.repository.GuestRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Guest guest = guestRepository.findByLogin(login);
        if (guest==null)
            throw new UsernameNotFoundException("Nie znaleziono goscia");
        return new GuestPrincipal(guest);
    }
}
