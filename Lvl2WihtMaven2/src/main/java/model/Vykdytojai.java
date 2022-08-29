package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vykdytojai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nr;
    private String pavarde;
    private String kvalifikacija;
    private String issilavinimas;

    public Vykdytojai() {
    }

    public Vykdytojai(long nr, String pavarde, String kvalifikacija, String issilavinimas) {
        this.nr = nr;
        this.pavarde = pavarde;
        this.kvalifikacija = kvalifikacija;
        this.issilavinimas = issilavinimas;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(String kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }

    public String getIssilavinimas() {
        return issilavinimas;
    }

    public void setIssilavinimas(String issilavinimas) {
        this.issilavinimas = issilavinimas;
    }
}
