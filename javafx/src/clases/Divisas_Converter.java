package clases;

import javafx.util.StringConverter;

public class Divisas_Converter extends StringConverter<Divisas>{

    @Override
    public Divisas fromString(String divisasString) {
        
        return null;

    }

    @Override
    public String toString(Divisas divisas) {
        
        return divisas == null ? null : divisas.getDivi();
        
    }

    
}
