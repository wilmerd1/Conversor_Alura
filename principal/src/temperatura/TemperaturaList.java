package temperatura;

import java.util.ArrayList;

public class TemperaturaList {

    public TemperaturaList() {
    }

    public ArrayList<Temperatura> coleccionTemperaturas() {
        ArrayList<Temperatura> temperaturas = new ArrayList<>();
        temperaturas.add(new Temperatura("Celsius"));
        temperaturas.add(new Temperatura("Fahrenheit"));
        temperaturas.add(new Temperatura("Kelvin"));
        temperaturas.add(new Temperatura("Rankine"));

        return temperaturas;

    }

}
