package clases;

public class Divisas {
    
    String divisa;

    public Divisas(

    ) {
        
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Divisas(String divisa) {
        this.divisa = divisa;
    }

    @Override 
    public String toString(){
        return getDivisa();
    }

}
