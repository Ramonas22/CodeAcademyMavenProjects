package services;

import model.Apartment;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class ApartmentServices {

    public void createApartment (Session session){
        Scanner scanner = new Scanner(System.in);
        Apartment apartment = new Apartment();
        /*System.out.println("Enter apartment id");
        apartment.setId(Long.parseLong(scanner.nextLine()));*/
        System.out.println("Enter code");
        apartment.setCode(scanner.nextLine());
        System.out.println("Enter rooms");
        apartment.setRooms(Integer.parseInt(scanner.nextLine()));

        session.beginTransaction();
        session.save(apartment);
        session.getTransaction().commit();
    }

    public List<Apartment> getApartmentList(Session session){
        return session.createQuery("from Apartment").list();
    }
}
