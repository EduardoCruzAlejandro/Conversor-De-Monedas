package ConversorDeMonedas.Tiempo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Historial {
    public void guardarHistorial(ArrayList<String> historia) throws IOException {
        ArrayList<String>datos=new ArrayList<>(historia);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter historial = new FileWriter("Historial-de-conversiones"+".json");

        historial.write(gson.toJson(datos));

        historial.close();

    }
}
