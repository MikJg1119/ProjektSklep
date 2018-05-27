package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dron extends Produkt implements Serializable {

    private boolean czyMaKamere;

    private double zasieg;

    public Dron(){}


    public String getNazwa() {
        return nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public boolean czyMaKamere() {
        return czyMaKamere;
    }

    public long getId() {
        return id;
    }

    public double getZasieg() {
        return zasieg;
    }

    public Dron(String nazwa, BigDecimal cena, boolean czyMaKamere, double zasieg) {
        super(nazwa, cena);
        this.nazwa = nazwa;
        this.cena = cena;
        this.czyMaKamere = czyMaKamere;
        this.zasieg = zasieg;
    }
}
