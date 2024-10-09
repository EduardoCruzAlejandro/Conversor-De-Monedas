package ConversorDeMonedas.Tiempo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * Clase Registro que almacena y gestiona el historial de conversiones de divisas.
 * Esta clase permite registrar cada transacción en un formato de texto y mantener
 * un historial completo de las conversiones realizadas.
 */
public class Registro {
    private String resultadoFinal; //Para concatener el resultado de momento
    ArrayList<String> conCatenado = new ArrayList<>(); //Lista para guardar el historial
    /**
     * Obtiene el resultado de conversión en formato de texto.
     *
     * @return resultado de la última conversión.
     */
    public String getResultadoFinal() {
        return resultadoFinal;
    }
    /**
     * Establece el resultado de conversión en formato de texto.
     *
     * @param resultadoFinal Texto base para el resultado de la conversión.
     * @param moneda Moneda de origen.
     * @param cantidad Cantidad de la moneda de origen a convertir.
     * @param cambio Moneda de destino.
     * @param resultado Resultado de la conversión a la moneda de destino.
     */
    public void setResultadoFinal (String resultadoFinal, String moneda, double cantidad, String cambio, double resultado) {
        this.resultadoFinal = resultadoFinal+cantidad+" "+moneda+" a "+cambio+" es "+resultado+" "+cambio;
    }

    /**
     * Registra una conversión con detalles de fecha, monedas y resultado redondeado.
     *
     * @param historial Fecha y hora de la conversión.
     * @param moneda Moneda de origen.
     * @param cantidad Cantidad de la moneda de origen.
     * @param cambio Moneda de destino.
     * @param resultado Resultado de la conversión.
     */
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
    /**
     * Devuelve el historial completo de todas las conversiones realizadas.
     *
     * @return Una lista de strings con los registros de todas las conversiones.
     */
    public ArrayList<String> getHistorialCompleto() {
        return conCatenado;
    }
}
