
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
        System.out.println("Ingrese su ubicacion actual");

        mostrarMenu();
        String option = sc.next();
        if(isInt(sc.next())){
            ejecutarOpcion(stringToint(option));
        }else {
            System.out.println("Numero no valido");
            menu();
        }
    }

    public static void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1- Actualizar Ubicacion");
        System.out.println("2- Buscar Sala");
        System.out.println("3- Salir");
        System.out.println("Selecciona una opcion:");
    }

    public static void ejecutarOpcion(int opcion) {
        switch(opcion){
            case 1:
                break;
            case 2:
                break;
            case 3:
                System.exit(69);
                break;
            default:
                System.out.println("Opcion invalida");
                menu();
        }
    }

    public static int stringToint(String number){
        int num = 0;
        if(isInt(number)){
            num = Integer.parseInt(number);
        }else {
            System.out.println("Numero Invalido");
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