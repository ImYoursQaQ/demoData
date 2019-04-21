package com.example.demoDataAcess.service.base.impl;

import com.example.demoDataAcess.Dao.PersonRepository;
        import com.example.demoDataAcess.entity.Person;
        import com.example.demoDataAcess.service.base.IPersonBaseService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.stereotype.Service;

@Service
public class PersonBaseServiceImpl implements IPersonBaseService {
    public static final Logger LOGGER = LoggerFactory.getLogger(PersonBaseServiceImpl.class);
    @Autowired
    private PersonRepository personRepo;
    @Override
    public Person findById(Integer id) {
        return personRepo.findById(id).orElse(null);
    }
    public Person findByIdFromCache(Integer id) {
        return null;
    }
}
