
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int option;

        do {
            mostrarMenu();
            option = stringToint(sc.next());
            ejecutarOpcion(option);
        }while(option != 4);
    }

    public static void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1- Actualizar Ubicacion");
        System.out.println("2- Buscar Sala");
        System.out.println("3- Listado");
        System.out.println("4- Salir");
        System.out.println("Selecciona una opcion:");
    }

    public static void ejecutarOpcion(int opcion) {
        switch(opcion){
            case 1:
                System.out.println("sadsda");
                break;
            case 2:
                System.out.println("dasgg2");
                break;
            case 3:
                System.out.println("2234dsa");
                break;
            case 4:
                System.out.println("Adios");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static int stringToint(String number){
        int num = 0;

        if(isInt(number)){
            num = Integer.parseInt(number);
        }else {
            System.out.println("Argumento Invalido");
        }

        return num;
    }

    public static boolean isInt(String number){
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}