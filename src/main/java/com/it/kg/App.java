package com.it.kg;

import com.it.kg.entity.Person;
import com.it.kg.repo.PersonRepoImpl;

public class App {

    public static void main(String[] args) {

        Person person1 = new Person("Bakyt", "Apsamatov", (byte) 16, 'm');
        Person person2 = new Person("Kurmanbek", "Pazylov", (byte) 16, 'm');
        Person person3 = new Person("Dastan", "Abdullaev", (byte) 15, 'm');
        Person person4 = new Person("Sardor", "Kalmurzaev", (byte) 17, 'm');

        PersonRepoImpl person = new PersonRepoImpl();

        person.clear();
    }
}