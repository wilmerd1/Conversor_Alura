package temperatura;

public class Temperatura {

    String temperatura;

    public Temperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override 
    public String toString(){
        return getTemperatura();
    }

    
}
