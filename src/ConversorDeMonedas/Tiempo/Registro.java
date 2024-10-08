package ConversorDeMonedas.Tiempo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Registro {
    private String resultadoFinal; //Para concatener el resultado de momento
    ArrayList<String> conCatenado = new ArrayList<>(); //Lista para guardar el historial

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal (String resultadoFinal, String moneda, double cantidad, String cambio, double resultado) {
        this.resultadoFinal = resultadoFinal+cantidad+" "+moneda+" a "+cambio+" es "+resultado+" "+cambio;
    }


    public void conCatenar(LocalDateTime historial,
                           String moneda,
                           double cantidad,
                           String cambio,
                           double resultado){

        //Redondeamos a dos decimales
        BigDecimal recorteCantidad= new BigDecimal(cantidad).setScale(2, RoundingMode.HALF_UP);
        BigDecimal recorteResultado= new BigDecimal(resultado).setScale(2, RoundingMode.HALF_UP);

        // Crea el registro en formato de texto y lo agrega al historial
        String registro="Date:"+
                        historial+
                        " Conversion de:"+
                        recorteCantidad+
                        " "+
                        moneda+
                        " a "+
                        recorteResultado+
                        " "+
                        cambio;
        conCatenado.add(registro);
    }
    //Para obtener el historial completo
    public ArrayList<String> getHistorialCompleto() {
        return conCatenado;
    }
}
