package ru.maxima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void save(Person person) {
        String password = passwordEncoder.encode(person.getPassword());
        person.setRole("ROLE_USER");
        person.setPassword(password);
        peopleRepository.save(person);
    }
}
