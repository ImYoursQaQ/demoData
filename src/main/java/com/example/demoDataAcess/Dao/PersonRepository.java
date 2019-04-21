package com.example.demoDataAcess.Dao;

import com.example.demoDataAcess.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
