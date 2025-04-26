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
            case 2 -> buscarEdificio();
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

    public static void buscarEdificio(){
        System.out.println("Edificios disponibles: ");
        System.out.println("1- Pabellon Ra");
        System.out.println("2- Pabellon E");
        System.out.println("Selecciona una opcion:");
        int option = stringToint(sc.next());
        int[] coordEdifBuscado = new int[2];

        switch (option){
            case 1 -> coordEdifBuscado = coordRa;
            case 2 -> coordEdifBuscado = coordE;
            default -> System.out.println("Opcion invalida");
        }
        int[] distanciaEjes = tamanoEjes(coordUsr,coordEdifBuscado);
        double angulo = anguloEntrePuntos(distanciaEjes);
        double distancia = distanciaEntreDosPuntos(distanciaEjes);

        if (angulo == 90.0) System.out.println("El edificio esta al norte de usted");
        else if (angulo == 0.0 && distanciaEjes[0] < 0) System.out.println("El edificio esta al oeste de usted");
        else if (angulo == -90.0) System.out.println("El edificio esta al sur de usted");
        else if (angulo == 0.0) System.out.println("El edificio esta al este de usted");
        else if (angulo < 90.0 && angulo > 0 && distanciaEjes[1] < 0 ) System.out.println("El edificio esta al suroeste de usted con un angulo de "+angulo+"°.");
        else if (angulo < 90.0 && angulo > 0) System.out.println("El edificio esta al noreste de usted con un angulo de "+angulo+"°.");
        else if (angulo > -90.0 && angulo < 0 && distanciaEjes[1] < 0) System.out.println("El edificio esta al sureste de usted con un angulo de "+Math.abs(angulo)+"°.");
        else if (angulo > -90.0 && angulo < 0 ) System.out.println("El edificio esta al noroeste de usted con un angulo de "+Math.abs(angulo)+"°.");

        System.out.println("A una distancia de "+distancia+" unidades");
    }

    public static int[] tamanoEjes(int[] punto1, int[] punto2){
        int[] distanciaEjes = new int[2];
        for (int i = 0; i < 2; i++) {
            distanciaEjes[i] = punto2[i] - punto1[i];
        }
        return distanciaEjes;
    }

    public static double anguloEntrePuntos(int[] distanciaEjes){
        double anguloRadianes = Math.atan((double) distanciaEjes[1] / distanciaEjes[0]);
        double anguloGrados = Math.toDegrees(anguloRadianes);
        return Math.round(anguloGrados * 100.0) / 100.0;
    }

    public static double distanciaEntreDosPuntos(int[] distanciaEjes){
        double distancia = Math.sqrt(distanciaEjes[0] + distanciaEjes[1]);
        return Math.round(distancia * 100.0) / 100.0;
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