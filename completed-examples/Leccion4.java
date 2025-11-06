public class Main {
    public static void main(String[] args) {
        
        // --- Parte 1: Arrays (Listas) ---
        // Un Array de números enteros (int)
        int[] notas = { 18, 15, 20 };
        
        // Accedemos a la posición 0 (la primera)
        System.out.println("Tu primera nota es: " + notas[0]);
        // Accedemos a la posición 2 (la tercera)
        System.out.println("Tu tercera nota es: " + notas[2]);

        System.out.println("--------------------------------");
        
        // --- Parte 2: Herramientas de String (Objeto) ---
        String saludo = "Hola, bienvenido!";
        System.out.println("El saludo original es: " + saludo);
        
        // Herramienta 1: .length() - ¿Cuántas letras tiene?
        int cantidadLetras = saludo.length();
        System.out.println("Cantidad de letras: " + cantidadLetras);
        
        // Herramienta 2: .toUpperCase() - ¡Ponerlo en mayúsculas!
        String enMayuscula = saludo.toUpperCase();
        System.out.println("En mayúsculas: " + enMayuscula);
    }
}