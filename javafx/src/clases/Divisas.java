package clases;

public class Divisas {
    
    String divi;

public Divisas(){


}

    public String getDivi() {
        return divi;
    }

    public void setDivi(String divisa) {
        this.divi = divisa;
    }

    public Divisas(String divisa) {
        this.divi = divisa;
    }

@Override 
public String toString(){

    return getDivi();
}

}
