import java.util.*;

public class Anagrama {
    public static void main(String[] args) {
        // Se define el scanner para leer la palabra
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingresa la palabra para el anagrama: ");
        String palabra = scan.nextLine();
        scan.close();

        // Lista para almacenar todas las permutaciones, es decir anagramas
        List<String> anagramas = new ArrayList<>();

        // Méotod que generamos las permutaciones
        generarPermutaciones("", palabra, anagramas);

        // Ordenamos alfabéticamente
        Collections.sort(anagramas);

        // numero total de permutaciones
        System.out.println("El numero total de permutaciones: " + anagramas.size());

        // Control para majero de errores en el bucle
        int control = Math.min(10, anagramas.size());
        if (control == 10) {
            System.out.println("Primeras 10 permutaciones ordenadas alfabéticamente:");
        } else {
            System.out.println("Las permutaciones totales son:");
        }

        // Recorre el arreglo de anagramas
        for (int i = 1; i <= control; i++) {
            System.out.println((i ) + ". " + anagramas.get(i-1));
        }
    }

    // Método recursivo para generar permutaciones
    public static void generarPermutaciones(String inicial, String sobrante, List<String> resultado) {
        int n = sobrante.length();
        if (n == 0) {
            resultado.add(inicial);
        } else {
            for (int i = 0; i < n; i++) {
                generarPermutaciones(inicial + sobrante.charAt(i),
                        sobrante.substring(0, i) + sobrante.substring(i + 1),
                        resultado);
            }
        }
    }
}