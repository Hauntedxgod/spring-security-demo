package ru.maxima.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public void doSomeAdminStuff(){
        System.out.println("Yes we can do admin stuff");
    }

}

