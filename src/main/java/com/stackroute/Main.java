package com.stackroute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

    public static void main(String[] args) {
        UserDetails user = new UserDetails();  // create user object
        user.setUserName("Dimmy Ronald");

        Address address1 = new Address(); // create address object
        address1.setStreet("First Street");
        address1.setCity("First City");
        address1.setState("First State");
        address1.setPincode("First Pin");

        Address address2 = new Address(); // create another address object
        address2.setStreet("Second Street");
        address2.setCity("Second City");
        address2.setState("Second State");
        address2.setPincode("Second Pin");

        user.getLisOfAddresses().add(address1); // set the addresses objects to list of the addresses
        user.getLisOfAddresses().add(address2);

        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); // create session factory object
        Session session = sessionFactory.openSession(); // create session object
        session.beginTransaction(); // start transaction object
        session.save(user); // save the user to database
        session.getTransaction().commit(); // commit the transaction


        session = sessionFactory.openSession(); // again create another session object
        user = null;
        user = (UserDetails) session.get(UserDetails.class, 1);
        session.close(); // closing session
        System.out.println(user.getLisOfAddresses().size());
    }
}
