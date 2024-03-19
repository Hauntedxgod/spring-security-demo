package ru.maxima.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxima.dto.PersonDTO;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, ModelMapper modelMapper) {
        this.peopleRepository = peopleRepository;
        this.modelMapper = modelMapper;
    }

    public Person findByName(String name){
        return peopleRepository.findByName(name);
    }

    public PersonDTO convertToPersonDTO(Person person){
        return modelMapper.map(person , PersonDTO.class);
    }

    public Person convertToPerson(PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO , Person.class);
        return person;
    }

}
