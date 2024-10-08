package ConversorDeMonedas.Calculos;


import ConversorDeMonedas.ConsultasAPI.Divisas;

import java.util.Map;

public class Calculos {

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
