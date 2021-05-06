package ru.tinkoff.hibernate.test.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.tinkoff.hibernate.test.db.model.Animal;
import ru.tinkoff.hibernate.test.db.model.Places;
import ru.tinkoff.hibernate.test.db.model.Zoo;

import java.util.List;

public class DBClient {

    public static Long getCountObjectByClass(final String tableName) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        long result = 0;
        if (tableName.equals("animal")) {
            result = session.createNativeQuery("select * from " + tableName, Animal.class)
                    .stream().count();
        } else if (tableName.equals("places")) {
            result = session.createNativeQuery("select * from " + tableName, Places.class)
                    .stream().count();
        }
        session.close();
        return result;
    }

    public static <T> boolean create(final T object) {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public static List<Zoo> getListZoo() {
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
        List<Zoo> zooList = session.createNativeQuery("select * from zoo", Zoo.class).getResultList();
        session.close();
        return zooList;
    }
}
