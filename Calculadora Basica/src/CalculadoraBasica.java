import java.util.Scanner;
public class CalculadoraBasica {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1, num2, resultado;
        int opcion;

        do {
            System.out.println("Bienvenido a la calculadora");
            System.out.println("Elige una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción no válida. Debe elegir una opción entre 1 y 4.");
            }

        } while (opcion < 1 || opcion > 4);

        System.out.print("Ingrese el primer número: ");
        num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        num2 = scanner.nextDouble();

        switch (opcion) {
            case 1:
                resultado = num1 + num2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;

            case 2:
                resultado = num1 - num2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;

            case 3:
                resultado = num1 * num2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;

            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("El resultado de la división es: " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
        }

        scanner.close();
        System.out.println("Gracias por usar nuestro Programa. Cerrando programa con exito");
    }
}