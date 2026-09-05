import java.util.Scanner;
public class InversionCadena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa de inversión de cadenas");
        System.out.print("Ingrese una cadena de texto: ");
        String cadena = scanner.nextLine();
        // Invertir la cadena y mostrarla
        System.out.print("La cadena invertida es: ");
        for (int i = cadena.length() - 1; i >= 0; i--) {
            System.out.print(cadena.charAt(i));
        }
        System.out.println(); // Imprimir una línea en blanco al final
        scanner.close();
    }
}


