package com.example.demoDataAcess.service.base;

import com.example.demoDataAcess.entity.Person;

public interface IPersonBaseService {
    Person findById(Integer id);
}
