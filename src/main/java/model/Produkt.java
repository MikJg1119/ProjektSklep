package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;



@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typ")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = Komputer.class, name = "kopmuter"),
            @JsonSubTypes.Type(value = Dron.class, name = "dron")
        }
)




public abstract class Produkt  implements Comparable<Produkt>  {
    protected long id;
    protected String nazwa;
    protected BigDecimal cena;

    private static  long generatorID;

    public Produkt(){}

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public Produkt(String nazwa, BigDecimal cena) {

        this.nazwa = nazwa;
        this.cena = cena;
        generatorID++;
        this.id = generatorID;
    }

    @Override
    public int compareTo(Produkt o) {
        if (this.cena.compareTo(o.cena)<0){
            return -1;
        }
        else if (this.cena.compareTo(o.cena)>0){
            return 1;
        }
        return 0;
    }
}
