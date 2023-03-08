package clases;

import java.util.ArrayList;

public class Monedas {
    
    
    public Monedas() {
    }

    public ArrayList<Divisas> crearCollectionDivisas(){
        ArrayList<Divisas> divisa = new ArrayList<>();
        divisa.add(new Divisas("USD"));
        divisa.add(new Divisas("EUR"));
        divisa.add(new Divisas("COL"));

        return divisa;


    }
    

}
