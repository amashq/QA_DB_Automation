package ru.tinkoff.hibernate.test.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.tinkoff.hibernate.test.db.model.Animal;
import ru.tinkoff.hibernate.test.db.model.Places;
import ru.tinkoff.hibernate.test.db.model.Workman;
import ru.tinkoff.hibernate.test.db.model.Zoo;

public class HibernateSessionCreator {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(new Configuration().configure().getProperties());
        return new Configuration()
                .configure()
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Workman.class)
                .addAnnotatedClass(Places.class)
                .addAnnotatedClass(Zoo.class)
                .buildSessionFactory(builder.build());
    }
}
