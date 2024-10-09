package ConversorDeMonedas.Calculos;


import ConversorDeMonedas.ConsultasAPI.Divisas;

import java.util.Map;
/**
 * Clase Calculos que realiza las operaciones de conversión de divisas.
 * Contiene métodos para calcular el valor de una cantidad de una moneda base
 * a otra moneda de destino utilizando las tasas de cambio.
 */
public class Calculos {
    /**
     * Realiza la conversión de una cantidad de una moneda base a una moneda de destino.
     *
     * @param divisas Objeto Divisas que contiene la moneda base y las tasas de conversión.
     * @param monedaDestino Código de la moneda de destino a la que se desea convertir.
     * @param cantidad Cantidad de la moneda base a convertir.
     * @return El resultado de la conversión en la moneda de destino. Retorna 0 si la tasa de cambio no existe.
     */
    public double convertir(Divisas divisas, String monedaDestino, double cantidad) {
        // Obtiene la tasa de conversión del mapa de tasas de cambio
        Map<String, Double> conversionRates = divisas.conversion_rates();

        // Verificar si el mapa contiene la tasa de cambio para la moneda de destino
        if (conversionRates.containsKey(monedaDestino)) {
            double tasa = conversionRates.get(monedaDestino);// Obtiene la tasa de cambio
            return cantidad * tasa;// Realiza la conversión multiplicando la cantidad por la tasa
        } else {
            System.out.println("No se encontró la tasa de cambio para la moneda: " + monedaDestino);
            return 0;// Retorna 0 si no se encuentra la tasa de cambio
        }
    }

}
