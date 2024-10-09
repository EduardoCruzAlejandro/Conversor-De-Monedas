package ConversorDeMonedas.ConsultasAPI;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 * Clase ConsultaDivisa que se encarga de realizar consultas a una API de tasas de cambio.
 * Proporciona un método para obtener las tasas de cambio de una moneda especificada.
 */
public class ConsultaDivisa {
    /**
     * Realiza una consulta a la API de ExchangeRate para obtener las tasas de cambio
     * de una moneda base especificada.
     *
     * @param moneda Código de la moneda base para la cual se desean las tasas de cambio (ej. "USD", "MXN").
     * @return Un objeto Divisas que contiene la información de las tasas de cambio.
     * @throws IOException Si ocurre un error de entrada/salida al realizar la solicitud.
     * @throws InterruptedException Si la operación de la solicitud es interrumpida.
     */
    public Divisas consultaMoneda(String moneda) throws IOException, InterruptedException {

        //Modificacion de la URL dependiendo de la selecciond del usuario
        String urlAPi = "https://v6.exchangerate-api.com/v6/9738e19bba8964ab23893ea4/latest/"+moneda;

        //hacemos request
        // Configuración del cliente HTTP y creación de la solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlAPi))
                .build();

        // Envío de la solicitud HTTP y obtención de la respuesta en formato String
            HttpResponse<String> response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());

        // Convertir la respuesta JSON a un objeto Divisas usando Gson
            return new Gson().fromJson(response.body(), Divisas.class);


    }
}
