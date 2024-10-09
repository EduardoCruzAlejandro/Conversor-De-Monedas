package ConversorDeMonedas.Principal;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase Menu que permite al usuario seleccionar las monedas base y de destino
 * para realizar una conversión. Proporciona opciones predeterminadas y permite
 * ingresar el código de una divisa personalizada.
 */
public class Menu {
    static Scanner busqueda = new Scanner(System.in);
    /**
     * Muestra el menú para seleccionar la moneda base y captura la elección del usuario.
     *
     * @return Un código de divisa (ej. "MXN", "USD", "EUR") o "salir" para finalizar.
     */
    public static String menuBase(){
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Peso Mexicano (MXN)");
        opciones.add("Dolar (USD)");
        opciones.add("Euro (EUR)");
        opciones.add("Otros");
        opciones.add("Salir");

        System.out.println("Ingrese moneda base de la conversion");
        menu(opciones);//Mostrar menu
        String base= busqueda.nextLine();
        //Opciones seleccionadas por el usuario con toUpperCase en caso de seleccion "Otro"
        switch (base.toUpperCase()){
            case "1": return "MXN";
            case "2": return "USD";
            case "3": return "EUR";
            case "4": System.out.println("Ingrese codigo de divisa deseado");
                return busqueda.nextLine();
            case "5": return "salir";
            default:
                System.out.println("No valido, intente otra vez");
                return menuBase();
        }
    }
    /**
     * Muestra el menú para seleccionar la moneda de destino y captura la elección del usuario.
     *
     * @return Un código de divisa (ej. "MXN", "USD", "EUR") o "salir" para finalizar.
     */
    public static String menuCambio(){
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Peso Mexicano (MXN)");
        opciones.add("Dolar (USD)");
        opciones.add("Euro (EUR)");
        opciones.add("Otros");
        opciones.add("Salir");

        System.out.println("Ingrese moneda de cambio");
        menu(opciones);
        String cambio= busqueda.nextLine();
        switch (cambio.toUpperCase()){
            case "1": return "MXN";
            case "2": return "USD";
            case "3": return "EUR";
            case "4": System.out.println("Ingrese codigo de divisa deseado");
                return busqueda.nextLine();
            case "5": return "salir";
            default:
                System.out.println("No valido, intente de nuevo");
                return menuCambio();
        }
    }
    /**
     * Método auxiliar que muestra una lista de opciones para que el usuario seleccione.
     *
     * @param opciones Lista de opciones de divisas a mostrar.
     */
    private static void menu(ArrayList<String> opciones) {
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }
}
