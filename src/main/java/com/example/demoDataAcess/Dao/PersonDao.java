package com.example.demoDataAcess.Dao;

import com.example.demoDataAcess.entity.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonDao extends CrudRepository<Person, Integer>, JpaSpecificationExecutor {

    //List<Person> findAll(Specification<Person> spec);

    @Override
    List<Person> findAll(Specification spec);
}
