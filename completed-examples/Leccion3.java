public class Main {
    public static void main(String[] args) {
        
        int precioJuego1 = 25;
        int precioJuego2 = 30;
        
        // Suma
        int total = precioJuego1 + precioJuego2;
        System.out.println("El total es: " + total);
        
        // Resta (Imaginemos un descuento)
        int descuento = 5;
        int precioFinal = total - descuento;
        System.out.println("Con el descuento, pagas: " + precioFinal);
        
        // Multiplicación (Si compramos 3 copias del juego 1)
        int totalJuego1 = precioJuego1 * 3;
        System.out.println("Si compras 3 copias del juego 1, pagas: " + totalJuego1);
    }
}