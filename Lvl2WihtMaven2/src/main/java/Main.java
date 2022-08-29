import model.Apartment;
import model.Vykdytojai;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import services.ApartmentServices;
import services.VykdytojaiServices;

import java.util.List;

public class Main {

    public static void main(String[] args){

       /* VykdytojaiServices vykdytojaiServices = new VykdytojaiServices();
        */
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        /*
        List<Vykdytojai> vykdytojais =  vykdytojaiServices.readVykdytojaiList(session);

        System.out.println(vykdytojais);*/

        ApartmentServices apartmentServices = new ApartmentServices();

        System.out.println(apartmentServices.getApartmentList(session));

        apartmentServices.createApartment(session);
        apartmentServices.createApartment(session);

        List<Apartment> apartments = apartmentServices.getApartmentList(session);

        for (Apartment apartment: apartments
             ) {
            System.out.println(apartment.getId() +" " + apartment.getCode() + " " + apartment.getRooms());
        }

    }
}