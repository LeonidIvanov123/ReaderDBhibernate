package com.leo.readerdbhibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DAObotuser {

    private Session session;
    DAObotuser(){
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession(); //based on hibernate.cfg.xml
    }

    List<Botuser> getlistdata(){
        List<Botuser> list = new ArrayList<>();
        String query = "select p from " + Botuser.class.getSimpleName() + " p";
        list = (List<Botuser>)session.createQuery(query).list();
        return list;
    }

    public boolean writetoDB(Botuser botuser){
        try {
            Transaction tx = session.beginTransaction();
            session.save(botuser);
            tx.commit();
        }catch (Exception exception){
            System.out.println(exception);
            return false;
        }
        return true;
    }


}
