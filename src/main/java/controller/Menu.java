package controller;

import model.Dron;
import model.Komputer;
import model.Sklep;
import pliki.OperacjePlikowe;
import pliki.PlikiBinarne;
import pliki.PlikiJson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    public void wyswietlMenu() {

        // utworz pusty sklep (obiekt klasy Sklep)
        //odczyt
        //PlikiBinarne pliki = new PlikiBinarne();
        String zapis;
        System.out.println("Sposób zapisu plików (1 - Json/0-Binarnie)");
        Scanner s = new Scanner(System.in);

        zapis= s.nextLine();

        OperacjePlikowe pliki;
        switch (zapis) {
            case "1": {

                pliki = new PlikiJson();
                break;
            }
            case "0":{
                pliki = new PlikiBinarne();
                break;
            }
            default:
                System.out.println("Możesz spróbować nie być zjebany?");
                pliki = new PlikiJson();
                break;
        }






        Sklep sklep = null;
        try {
            sklep = pliki.wczytaj();
        } catch (Exception e) {
            System.out.println("Odczyt się zjebał, wykurwiamy sklep");
            sklep = new Sklep("Holololo");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - dodaj komputer");
        System.out.println("2 - usuń");
        System.out.println("3 - wyswietl liste produktow");
        System.out.println("4 - dodaj drona");
        System.out.println("5 - wyświetl posortowanie cenowo");
        System.out.println("6 - posortowanie po nazwie");
        System.out.println("q - wyjdz");
        String wybor;

        do {
            System.out.print("Podaj wybor: ");
            wybor = scanner.nextLine();
            switch (wybor) {
                case "1":{
                    // wczytywanie informacji o komputerze

                    System.out.print("Podaj nazwe: ");
                    String nazwa = scanner.nextLine();
                    System.out.print("Podaj cene: ");
                    BigDecimal cena = scanner.nextBigDecimal();
                    scanner.nextLine();
                    System.out.print("Podaj marke: ");
                    String marka = scanner.nextLine();
                    System.out.print("Podaj ilosc GB ramu: ");
                    int ram = scanner.nextInt();
                    scanner.nextLine(); // 3\n
                    // stworzyc obiekt typu Komputer
                    Komputer komputer = new Komputer(nazwa, cena, marka, ram);
                    // wywolac metode dodaj klasy Sklep
                    sklep.dodaj(komputer);
                    break;}
                case "2":
                    // wczytaj id do usuniecia
                    System.out.print("Podaj id do usuniecia: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    // wywolac metode usun klasy Sklep
                    sklep.usun(id);
                    break;
                case "3":
                    // wywolac metode wyswietl klasy Sklep
                    sklep.wyswietl();
                    break;
                case "4": {
                    System.out.println("Podaj nazwę: ");
                    String nazwa = scanner.nextLine();
                    System.out.println("Podaj cenę: ");
                    BigDecimal cena = scanner.nextBigDecimal();
                    scanner.nextLine();
                    System.out.println("Podaj zasięg: ");
                    double zasieg = scanner.nextDouble();
                    System.out.println("Czy dron ma kamere (Y/N): ");
                    boolean czyMaKamere;
                    String a = scanner.nextLine();
                    if (a.equals("Y")){
                        czyMaKamere=true;
                    }else {
                        czyMaKamere=false;
                    }
                    Dron dron = new Dron(nazwa,cena,czyMaKamere,zasieg);
                    sklep.dodaj(dron);
                    break;
                }
                case "5":
                    sklep.wyswietlPosortowaneCenowo();
                    break;
                case "6":
                    sklep.wyswietlPosortowanePoNazwie();
                    break;
                case "q":
                case "Q":
                    System.out.println("koniec");
                    //zapis
                    try {
                        pliki.zapisz(sklep);
                    } catch (Exception e) {
                        System.out.println("Sorki memorki, nie zapiszesz");

                    }
                    break;

                default:
                    System.out.println("Zabij się");
                    break;
                    }
            } while (!wybor.equalsIgnoreCase("q"));

    }

}