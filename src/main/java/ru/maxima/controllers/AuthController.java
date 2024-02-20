package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maxima.models.Person;
import ru.maxima.service.PersonService;
import ru.maxima.validation.PersonValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonValidator validator;

    private final PersonService service;

    @Autowired
    public AuthController(PersonValidator validator, PersonService service) {
        this.validator = validator;
        this.service = service;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String giveRegistrationPage(@ModelAttribute("personFromPage") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("personFromPage") Person person , BindingResult result){

        validator.validate(person , result);

        if (result.hasErrors()){
            return "/auth/registration";
        }
        service.save(person);

        return "redirect:/auth/login";
    }


}
