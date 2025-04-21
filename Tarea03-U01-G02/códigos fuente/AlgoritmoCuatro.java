import java.util.Scanner;

public class AlgoritmoCuatro {

    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String leerMensaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el mensaje a cifrar: ");
        String sinEspacios = scanner.nextLine().toUpperCase().replaceAll("\\s+", "");

        return sinEspacios;
    }

    private static int leerDesplazamiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el desplazamiento: ");
        return scanner.nextInt();
    }

    private static boolean esDesplazamientoValido(int desplazamiento) {
        return desplazamiento >= 0 && desplazamiento < ALFABETO.length();
    }

    private static String generarAlfabetoCifrado(int desplazamiento) {
        return ALFABETO.substring(desplazamiento) + ALFABETO.substring(0, desplazamiento);
    }

    private static String cifrarMensaje(String mensaje, String alfabetoCifrado) {
        StringBuilder resultado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            int indice = ALFABETO.indexOf(c);
            resultado.append(indice != -1 ? alfabetoCifrado.charAt(indice) : c);
        }
        return resultado.toString();
    }

    private static void mostrarResultados(String mensaje, int desplazamiento, String alfabetoCifrado,
            String mensajeCifrado) {
        System.out.println("\n=== RESULTADOS DEL CIFRADO ===");
        System.out.println("Alfabeto original : " + ALFABETO);
        System.out.println("Alfabeto cifrado  : " + alfabetoCifrado);
        System.out.println("Mensaje original  : " + mensaje);
        System.out.println("Mensaje cifrado   : " + mensajeCifrado);
        System.out.println("Desplazamiento    : " + desplazamiento);
    }

    public static void main(String[] args) {
        String mensaje = leerMensaje();
        int desplazamiento = leerDesplazamiento();

        if (!esDesplazamientoValido(desplazamiento)) {
            System.out.println("Desplazamiento no válido. Debe estar entre 0 y " + (ALFABETO.length() - 1));
            return;
        }

        String alfabetoCifrado = generarAlfabetoCifrado(desplazamiento);
        String mensajeCifrado = cifrarMensaje(mensaje, alfabetoCifrado);

        mostrarResultados(mensaje, desplazamiento, alfabetoCifrado, mensajeCifrado);
    }

}
