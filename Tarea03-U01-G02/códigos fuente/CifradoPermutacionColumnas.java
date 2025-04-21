
import java.util.Scanner;

/**
 * Algoritmo de cifrado por permutación de columnas (transposición invertida).
 * Se toma como clave el número de columnas (n) de una matriz cuadrada.
 * El mensaje (sin espacios) se coloca columna por columna en la matriz,
 * y los espacios sobrantes se completan con '*'.
 * El mensaje cifrado se obtiene leyendo la matriz fila por fila.
 */
public class CifradoPermutacionColumnas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Lectura de la clave (número de columnas)
        System.out.print("Ingrese el número de columnas (clave): ");
        int n = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea pendiente

        // 2) Lectura del mensaje original (puede contener espacios)
        System.out.print("Ingrese el mensaje a cifrar: ");
        String mensaje = sc.nextLine();

        // 3) Eliminación de espacios para el proceso de cifrado
        String mensajeSinEspacios = mensaje.replace(" ", "");

        // 4) Validación: el texto (sin espacios) no debe exceder n * n
        if (mensajeSinEspacios.length() > n * n) {
            System.out.println("Error: el número de caracteres del mensaje (sin espacios) excede n x n.");
            sc.close();
            return;
        }

        // 5) Creación de la matriz cuadrada de cifrado
        char[][] matriz = new char[n][n];
        int idx = 0;
        // Colocar caracteres columna por columna
        for (int col = 0; col < n; col++) {
            for (int fila = 0; fila < n; fila++) {
                if (idx < mensajeSinEspacios.length()) {
                    matriz[fila][col] = mensajeSinEspacios.charAt(idx++);
                } else {
                    matriz[fila][col] = '*';
                }
            }
        }

        // 6) Impresión de la matriz de cifrado
        System.out.println("\nMatriz de cifrado:");
        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println();
        }

        // 7) Construcción del mensaje cifrado leyendo fila por fila
        StringBuilder cifrado = new StringBuilder();
        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                cifrado.append(matriz[fila][col]);
            }
        }

        // 8) Mostrar resultados finales
        System.out.println("\nMensaje original: " + mensaje);
        System.out.println("Mensaje cifrado: " + cifrado.toString());

        sc.close();
    }
}
