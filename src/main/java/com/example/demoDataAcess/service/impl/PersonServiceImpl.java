package com.example.demoDataAcess.service.impl;

import com.example.demoDataAcess.entity.Person;
import com.example.demoDataAcess.service.IPersonService;
import com.example.demoDataAcess.service.base.IPersonBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private IPersonBaseService personBaseService;
   // @Autowired
    //private IAnotherBaseService anotherBaseService;
    @Override
    public Person queryById(Integer id) {
        return personBaseService.findById(id);
    }
}
