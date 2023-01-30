package com.it.kg.repo;

import com.it.kg.entity.Person;
import com.it.kg.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PersonRepoImpl implements PersonRepo {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void save(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.save(person);
        }
    }

    public Person getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Person.class, id);
        }
    }

    public List<Person> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select p from Person p").getResultList();
        }
    }

    public void updateById(Long id, Person newPerson) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person p = getById(id);
            p.setFirstName(newPerson.getFirstName());
            p.setLastName(newPerson.getLastName());
            p.setAge(newPerson.getAge());
            p.setGender(newPerson.getGender());
            session.saveOrUpdate(p);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = getById(id);
            session.delete(person);
            session.getTransaction().commit();
        }
    }

    public void clear() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Person p").executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Person findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return (Person) session.createQuery("select p from Person p where p.firstName = ?1")
                    .setParameter(1, name).getSingleResult();
        }
    }
}