package services;

import model.Vykdytojai;
import org.hibernate.Session;

import java.util.List;

public class VykdytojaiServices {

    public List<Vykdytojai> readVykdytojaiList(Session session){
        return session.createQuery("from Vykdytojai").list();
    }
}
