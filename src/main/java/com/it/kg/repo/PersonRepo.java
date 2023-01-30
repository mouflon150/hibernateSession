package com.it.kg.repo;

import com.it.kg.entity.Person;

import java.util.List;

public interface PersonRepo {

    void save(Person person);

    Person getById(Long id);

    List<Person> findAll();

    void updateById(Long id, Person person);

    void deleteById(Long id);

    void clear();

    Person findByName(String name);
}
