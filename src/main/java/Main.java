import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int[] coordRa = {5,10};
    private static final int[] coordE = {2,6};
    private static int[] coordUsr = new int[2];


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

    private static void mostrarMenu() {
        System.out.println("Menu Principal");
        System.out.println("1- Actualizar Ubicacion");
        System.out.println("2- Buscar Sala");
        System.out.println("3- Listado");
        System.out.println("4- Salir");
        System.out.println("Selecciona una opcion:");
    }

    private static void ejecutarOpcion(int opcion) {
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

    private static void actualizarCoordUsr(){
        System.out.println("Ingrese sus coordenadas en X: ");
        int coordX = stringToint(sc.next());
        System.out.println("X: " + coordX);

        System.out.println("Ingrese sus coordenadas en Y: ");
        int coordY= stringToint(sc.next());
        System.out.println("Y: " + coordY);

    }

    private static int stringToint(String number){
        int num = 0;

        if(isInt(number)){
            num = Integer.parseInt(number);
        }else {
            System.out.println("Argumento Invalido");
        }

        return num;
    }

    private static boolean isInt(String number){
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}