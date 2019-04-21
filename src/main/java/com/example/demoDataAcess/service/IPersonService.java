package com.example.demoDataAcess.service;

import com.example.demoDataAcess.entity.Person;

public interface IPersonService {
    Person queryById(Integer id);
}
