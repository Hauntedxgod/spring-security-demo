package ru.maxima.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maxima.models.Person;
import ru.maxima.service.PersonService;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonService service;

    @Autowired
    public PersonDetailsService(PersonService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person personByName = service.findByName(username);
        if (personByName == null ){
            throw new UsernameNotFoundException("Not found");
        }

        return new PersonDetails(service.findByName(username));
    }
}
