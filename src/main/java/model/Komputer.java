package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Komputer extends Produkt implements Serializable {



    private String marka;
    private int ram;
    private static long generatorID=0L;

    public Komputer(){}

    public Komputer(String nazwa, BigDecimal cena, String marka, int ram) {
        super(nazwa, cena);
        this.marka = marka;
        this.ram = ram;
    }



    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Komputer{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", marka='" + marka + '\'' +
                ", ram=" + ram +
                ", id=" + id +
                '}';
    }

    public void setId(long id) {


    }


    public String getMarka() {
        return marka;
    }

    public int getRam() {
        return ram;
    }


}
