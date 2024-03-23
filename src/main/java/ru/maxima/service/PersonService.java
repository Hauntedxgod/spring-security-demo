package ru.maxima.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.maxima.dto.PersonDTO;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, ModelMapper modelMapper) {
        this.peopleRepository = peopleRepository;
        this.modelMapper = modelMapper;
    }


    public Map<String , String> loadUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDTO personDTO = (PersonDTO) authentication.getPrincipal();



        return Map.of("token" , personDTO.getName() );
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
