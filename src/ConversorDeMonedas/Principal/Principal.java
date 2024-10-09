package ConversorDeMonedas.Principal;

import ConversorDeMonedas.Calculos.Calculos;
import ConversorDeMonedas.ConsultasAPI.ConsultaDivisa;
import ConversorDeMonedas.ConsultasAPI.Divisas;
import ConversorDeMonedas.Tiempo.Historial;
import ConversorDeMonedas.Tiempo.Registro;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Inicia las instancias
        Scanner busqueda = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();
        Registro registro = new Registro();
        Calculos calculos = new Calculos();
        Historial guardar = new Historial();
        while (true){

                double cantidad;
                //Llama al Menu para solicitar la moneda base
                String moneda = Menu.menuBase().toUpperCase();
                if (moneda.equals("salir")) break;
                //Llama de nuevo para solicitar la otro moneda a convertir
                String cambio = Menu.menuCambio().toUpperCase();
                if (cambio.equals("salir")) break;

                //Pide la cantidad a convertir
                System.out.println("Ingrese cantidad deseada");
                cantidad=busqueda.nextDouble();
            try{
                // Realiza la consulta a la API de divisas y obtenemos la tasa de cambio.
                Divisas divisas = consulta.consultaMoneda(moneda);
                System.out.println(divisas);

                // Realiza el cálculo de la conversión y almacenamos el resultado.
                double resultado = calculos.convertir(divisas,cambio,cantidad);

                //Setear el resultado y se imprime
                registro.setResultadoFinal("La conversion de ",moneda,cantidad,cambio,resultado);
                System.out.println("Conversion: "+registro.getResultadoFinal());

                //Hacemos registro de la conversion realizada llamando a metodo dentro Registro
                registro.conCatenar(LocalDateTime.now(),moneda,cantidad,cambio,resultado);
                ArrayList<String> historial = registro.getHistorialCompleto();

                //Preguntamos si desea seguir
                System.out.println("Desea realizar otra conversion?");
                System.out.println("1= Si, 2=No");
                int respuesta = busqueda.nextInt();
                if (respuesta==2) {
                    //Imprime el historial y sale

                    guardar.guardarHistorial(historial);
                    for (String registroItem : historial){
                        System.out.println("Historial de Conversiones: "+ registroItem);
                    }
                    break;
                }

            }catch (IOException | InterruptedException e){
                // Maneja los errores que puedan ocurrir durante la consulta o el cálculo.
                System.out.println("Error "+e.getMessage());
                break;
            }
        }
    }
}
