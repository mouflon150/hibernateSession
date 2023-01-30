package com.it.kg.util;

import com.it.kg.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                //driver
                .setProperty(Environment.DRIVER, "org.postgresql.Driver")
                //url
                .setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres")
                //user
                .setProperty(Environment.USER, "postgres")
                //password
                .setProperty(Environment.PASS, "marlen27056")
                //format sql
                .setProperty(Environment.HBM2DDL_AUTO, "validate")
                //show sql message
                .setProperty(Environment.SHOW_SQL, "true")
                //dialect
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect")
                //entities
                .addAnnotatedClass(Person.class)
                //buildSessionFactory
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}