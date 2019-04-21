package com.example.demoDataAcess.service;

import com.example.demoDataAcess.Person;
import com.example.demoDataAcess.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    PersonRepository personRepository;

    @Cacheable(value = "user")
    public Person getOne(int i) {
        Person p = personRepository.getOne(1);
        return p;
    }
}
