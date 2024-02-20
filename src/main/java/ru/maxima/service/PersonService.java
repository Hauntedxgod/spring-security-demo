package ru.maxima.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;


    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Person findByName(String name){
        return peopleRepository.findByName(name);
    }

    public void save(Person person){
        peopleRepository.save(person);
    }
}
