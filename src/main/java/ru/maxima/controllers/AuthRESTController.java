package ru.maxima.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.dto.PersonDTO;
import ru.maxima.models.Person;
import ru.maxima.service.PersonService;
import ru.maxima.service.RegistrationService;
import ru.maxima.util.JWTUtil;
import ru.maxima.validation.PersonValidator;

import java.util.Map;

@RestController
@RequestMapping("/authenticate")
public class AuthRESTController {

    private final RegistrationService registrationService;

    private final PersonValidator validator;

    private final PersonService personService;

    private final JWTUtil util;

    @Autowired
    public AuthRESTController(RegistrationService registrationService, PersonValidator validator,
                              PersonService personService, JWTUtil util) {
        this.registrationService = registrationService;
        this.validator = validator;
        this.personService = personService;
        this.util = util;
    }

    @PostMapping("/registration")
    public Map<String , String> performRegistration(@RequestBody @Valid PersonDTO personDTO ,
                                                    BindingResult bindingResult){

        Person person = personService.convertToPerson(personDTO);

        validator.validate(person , bindingResult);

        if (bindingResult.hasErrors()){
            return Map.of("message" , "Ошибка");
        }
        registrationService.save(person);

        String token = util.generateToken(person.getName());

        return Map.of("jwt-token", token);

    }
}
