import java.util.Scanner;
public class ConteovocCons {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bienvenido al programa de conteo de vocales y consonantes");
        System.out.print("Ingrese una palabra o frase: ");
        String frase=scanner.nextLine().toLowerCase();
        int vocales=0;
        int consonantes=0;
 
        for(int i=0;i<frase.length();i++){
            char c=frase.charAt(i); // Obtener el carácter en la posición i
             // para verificar si es una letra del alfabeto
            if (c >= 'a' && c <= 'z') {
                // Verificar si es vocal o no 
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vocales++;
                } else {
                    consonantes++;
                }
            }
        }
        System.out.println("Número de vocales: " + vocales);
        System.out.println("Número de consonantes: " + consonantes);
    }
}
