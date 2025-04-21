import java.util.Scanner;

public class Vigenere {

    // Generea la key
    static String generarKey(String str, String key) {
        int x = str.length();

        for (int i = 0;; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    // Texto cifrado
    static String textCifrado(String str, String key) {
        String cifrado = "";

        for (int i = 0; i < str.length(); i++) {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            // convert into alphabets(ASCII)
            x += 'A';

            cifrado += (char) (x);
        }
        return cifrado;
    }

    // Texto desencriptado
    static String textOriginal(String cifrado, String key) {
        String original = "";

        for (int i = 0; i < cifrado.length() &&
                i < key.length(); i++) {
            int x = (cifrado.charAt(i) -
                    key.charAt(i) + 26) % 26;

            x += 'A';
            original += (char) (x);
        }
        return original;
    }

    // Minusculas a mayusculas
    static String LowerToUpper(String s) {
        StringBuffer str = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el mensaje que desea cifar, escribir sin espacios : ");
        String mensaje = scanner.nextLine();
        String Keyword = "CLAVE";
        String str = LowerToUpper(mensaje);
        String keyword = LowerToUpper(Keyword);

        String key = generarKey(str, keyword);
        String cifrado = textCifrado(str, key);

        System.out.println("Mensaje : " + textOriginal(cifrado, key));
        System.out.println("Palabra Clave : " + Keyword);
        System.out.println("Texto Cifrado : " + cifrado);

    }
}
