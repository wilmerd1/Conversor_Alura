package clases;

import java.util.ArrayList;



public class DivisasList {
    
   private ArrayList<Divisas> divisa;
public DivisasList(){

   ArrayList <Divisas> divisa = new ArrayList<>();

   divisa.add(new Divisas("USD"));
   divisa.add(new Divisas("EUR"));
   divisa.add(new Divisas("COL"));
   

}

public ArrayList<Divisas> getDivisas(){
return divisa;

}

}