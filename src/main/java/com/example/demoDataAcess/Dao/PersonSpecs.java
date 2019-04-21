package com.example.demoDataAcess.Dao;

import com.example.demoDataAcess.entity.Person;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonSpecs {

  public static Specification<Person> person(int id,String name) {
    return new Specification<Person>() {
      public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query,
                                   CriteriaBuilder builder) {
        Predicate predicate = builder.conjunction();
        if (Integer.valueOf(id)!=null&&id!=0) {
          predicate.getExpressions().add(
                  builder.equal(root.get("id"),id)
                 // builder.like(root.get("id"), "%" + StringUtils.trim(name) + "%")
          );
        }
        if (!StringUtils.isEmpty(name)) {
          predicate.getExpressions().add(
                  builder.like(root.get("name"),String.format("%%%s%%",name))
                  //builder.like(root.<String>get("name"), "%" + StringUtils.trim(name) + "%")
          );
        }

        return predicate;
      }
    };
  }

  public static void main(String[] args) {
    System.out.println(String.format("%%%s%%","hu"));
  }


}