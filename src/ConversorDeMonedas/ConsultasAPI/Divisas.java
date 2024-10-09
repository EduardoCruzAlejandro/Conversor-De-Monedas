package ConversorDeMonedas.ConsultasAPI;

import java.util.Map;
/**
 * Clase de registro Divisas que representa la información de una tasa de cambio de una moneda base.
 * Contiene el código de la moneda base y un mapa de las tasas de conversión a otras monedas.
 *
 * @param base_code Código de la moneda base (por ejemplo, "USD", "MXN").
 * @param conversion_rates Mapa que relaciona los códigos de otras monedas con sus tasas de conversión
 *                         respecto a la moneda base. La clave es el código de la moneda de destino,
 *                         y el valor es la tasa de cambio correspondiente.
 */
public record Divisas(String base_code,
                      Map<String, Double> conversion_rates) {
}
