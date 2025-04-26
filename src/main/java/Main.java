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
        System.out.println("1- Actualizar sus Coordenadas");
        System.out.println("2- Buscar Edificio por coordenadas");
        System.out.println("3- Ubicar Sala");
        System.out.println("4- Salir");
        System.out.println("Sus coordenadas son: X="+coordUsr[0]+", Y="+coordUsr[1]);
        System.out.println("Selecciona una opcion:");
    }

    private static void ejecutarOpcion(int opcion) {
        switch(opcion){
            case 1 -> actualizarCoordUsr();
            case 2 -> System.out.println("dasgg2");
            case 3 -> System.out.println("2234dsa");
            case 4 -> System.out.println("Adios");
            default -> System.out.println("Opcion invalida");
        }
    }

    private static void actualizarCoordUsr(){
        System.out.println("Ingrese sus coordenadas en X: ");
        int coordX = stringToint(sc.next());
        System.out.println("X: " + coordX);

        System.out.println("Ingrese sus coordenadas en Y: ");
        int coordY= stringToint(sc.next());
        System.out.println("Y: " + coordY);

        coordUsr = new int[] {coordX, coordY};
    }

    public static int[] tamanoEjes(int[] punto1, int[] punto2){
        int[] distanciaEjes = new int[2];
        for (int i = 0; i < 2; i++) {
            distanciaEjes[i] = punto2[i] - punto1[i];
        }
        return distanciaEjes;
    }

    public static double anguloEntrePuntos(int[] punto1, int[] punto2){
        int[] distanciaEjes = tamanoEjes(punto1,punto2);

        double anguloRadianes = Math.atan((double) distanciaEjes[1] / distanciaEjes[0]);
        double anguloGrados = Math.toDegrees(anguloRadianes);
        return Math.round(anguloGrados * 100.0) / 100.0;
    }

    public static double distanciaEntreDosPuntos(int[] punto1, int[] punto2){
        int[] distanciaEjes = tamanoEjes(punto1,punto2);
        return Math.sqrt(distanciaEjes[0] + distanciaEjes[1]);
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