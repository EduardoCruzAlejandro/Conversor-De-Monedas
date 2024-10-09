package ConversorDeMonedas.Tiempo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * La clase Historial se encarga de gestionar el almacenamiento del historial de conversiones.
 * Los datos del historial se almacenan en un archivo JSON utilizando la biblioteca Gson.
 */
public class Historial {
    /**
     * Guarda el historial de conversiones en un archivo JSON.
     *
     * @param historia Una lista de cadenas que representa el historial de conversiones a guardar.
     * @throws IOException Si ocurre un error durante la escritura en el archivo.
     */
    public void guardarHistorial(ArrayList<String> historia) throws IOException {
        //Copia datos de historia en una nueva arrayList
        ArrayList<String>datos=new ArrayList<>(historia);

        // Configura Gson para formatear el JSON de forma legible
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Crea un FileWriter para escribir en el archivo "Historial-de-conversiones.json"
        FileWriter historial = new FileWriter("Historial-de-conversiones"+".json");

        // Convierte la lista de datos a formato JSON y la escribe en el archivo
        historial.write(gson.toJson(datos));
        // Cierra el archivo para asegurarse de que los datos se guarden correctamente
        historial.close();

    }
}
