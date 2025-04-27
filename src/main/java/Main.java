import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final double[] coordRa = {5,10};
    private static final double[] coordE = {2,6};
    private static double[] coordUsr = new double[2];


    public static void main(String[] args) {
        inicioPrograma();
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

    private static void inicioPrograma(){
        System.out.println("Bienvenido, ingrese sus coordenadas actuales");
        actualizarCoordUsr();
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

        coordUsr = new double[] {coordX, coordY};
    }

    public static void buscarEdificio() {
        mostrarOpcionesEdificios();
        int opcion = obtenerOpcionUsuario();

        if (!opcionValida(opcion)) {
            System.out.println("Opción inválida");
            return;
        }

        double[] coordenadasEdificio = obtenerCoordenadasEdificio(opcion);
        double[] diferenciaCoordenadas = calcularDiferenciaCoordenadas(coordUsr, coordenadasEdificio);

        mostrarDireccionRelativa(diferenciaCoordenadas);
        mostrarDistancia(diferenciaCoordenadas);
    }

    private static void mostrarOpcionesEdificios() {
        System.out.println("Edificios disponibles: ");
        System.out.println("1- Pabellón Ra");
        System.out.println("2- Pabellón E");
        System.out.println("Selecciona una opción:");
    }

    private static int obtenerOpcionUsuario() {
        return stringToint(sc.next());
    }

    private static boolean opcionValida(int opcion) {
        return opcion == 1 || opcion == 2;
    }

    private static double[] obtenerCoordenadasEdificio(int opcion) {
        return opcion == 1 ? coordRa : coordE;
    }

    private static double[] calcularDiferenciaCoordenadas(double[] origen, double[] destino) {
        return tamanoEjes(origen, destino);
    }

    private static void mostrarDireccionRelativa(double[] diferenciaCoordenadas) {
        double angulo = anguloEntrePuntos(diferenciaCoordenadas);
        String direccion = determinarDireccion(angulo, diferenciaCoordenadas);
        System.out.println(direccion);
    }

    private static String determinarDireccion(double angulo, double[] diferenciaCoordenadas) {
        if (angulo == 90.0) return "El edificio está al norte de usted";
        if (angulo == 0.0 && diferenciaCoordenadas[0] < 0) return "El edificio está al oeste de usted";
        if (angulo == -90.0) return "El edificio está al sur de usted";
        if (angulo == 0.0) return "El edificio está al este de usted";

        String puntoCardinal = obtenerPuntoCardinal(angulo, diferenciaCoordenadas);
        double anguloMostrar = angulo > 0 ? angulo : Math.abs(angulo);

        return String.format("El edificio está al %s de usted con un ángulo de %.1f°",
                puntoCardinal, anguloMostrar);
    }

    private static String obtenerPuntoCardinal(double angulo, double[] diferenciaCoordenadas) {
        if (angulo < 90.0 && angulo > 0) {
            return diferenciaCoordenadas[1] < 0 ? "suroeste" : "noreste";
        }
        return diferenciaCoordenadas[1] < 0 ? "sureste" : "noroeste";
    }

    private static void mostrarDistancia(double[] diferenciaCoordenadas) {
        double distancia = distanciaEntreDosPuntos(diferenciaCoordenadas);
        System.out.printf("A una distancia de %.2f unidades%n", distancia);
    }

    public static double[] tamanoEjes(double[] punto1, double[] punto2){
        double[] distanciaEjes = new double[2];
        for (int i = 0; i < 2; i++) {
            distanciaEjes[i] = punto2[i] - punto1[i];
        }
        return distanciaEjes;
    }

    public static double anguloEntrePuntos(double[] distanciaEjes){
        double anguloRadianes = Math.atan((double) distanciaEjes[1] / distanciaEjes[0]);
        double anguloGrados = Math.toDegrees(anguloRadianes);
        return Math.round(anguloGrados * 100.0) / 100.0;
    }

    public static double distanciaEntreDosPuntos(double[] distanciaEjes){
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