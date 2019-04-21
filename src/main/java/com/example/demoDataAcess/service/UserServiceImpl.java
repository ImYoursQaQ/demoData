package com.example.demoDataAcess.service;

import com.example.demoDataAcess.Dao.PersonDao;
import com.example.demoDataAcess.Dao.PersonSpecs;
import com.example.demoDataAcess.entity.Person;
import com.example.demoDataAcess.Dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonDao personDao;

    @Cacheable(value = "user")
    public Person getOne(int i) {
        Person p = personRepository.getOne(1);
        return p;
    }

    public List<Person> personList(Person person){
        return personDao.findAll(PersonSpecs.person(person.getId(),person.getName()));
    }
}
