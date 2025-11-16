public class CuentaBancaria {
    // ✅ PRIVATE - Solo accesible desde dentro de la clase
    private double saldo;
    private String titular;
    
    public CuentaBancaria(String nombreTitular, double saldoInicial) {
        titular = nombreTitular;
        if (saldoInicial >= 0) {
            saldo = saldoInicial;
        } else {
            saldo = 0;
            System.out.println("❌ Saldo inicial no puede ser negativo");
        }
    }
    
    // ✅ GETTER - Para leer el saldo de manera controlada
    public double getSaldo() {
        return saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    
    // ✅ SETTER - Para modificar el saldo con validaciones
    public void setSaldo(double nuevoSaldo) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo;
        } else {
            System.out.println("❌ El saldo no puede ser negativo");
        }
    }
    
    // ✅ MÉTODOS ESPECÍFICOS que controlan la lógica
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("✅ Depositados: S/" + cantidad);
        } else {
            System.out.println("❌ Cantidad de depósito inválida");
        }
    }
    
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("✅ Retirados: S/" + cantidad);
        } else {
            System.out.println("❌ Fondos insuficientes o cantidad inválida");
        }
    }
}






















// 🐾 SUPERCLASE (Clase Padre)
public class Animal {
    protected String nombre;
    protected int edad;
    
    public Animal(String nombreAnimal, int edadAnimal) {
        nombre = nombreAnimal;
        edad = edadAnimal;
    }
    
    public void comer() {
        System.out.println(nombre + " está comiendo... 🍽️");
    }
    
    public void dormir() {
        System.out.println(nombre + " está durmiendo... 😴");
    }
    
    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido...");
    }
}

// 🐕 SUBCLASE 1 - Hereda de Animal
public class Perro extends Animal {
    private String raza;
    
    public Perro(String nombre, int edad, String razaPerro) {
        super(nombre, edad); // Llama al constructor del padre
        raza = razaPerro;
    }
    
    // 🔁 SOBREESCRITURA - Modificamos el comportamiento del padre
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau guau! 🐶");
    }
    
    // ✨ MÉTODO NUEVO - Solo los perros tienen este método
    public void moverCola() {
        System.out.println(nombre + " está moviendo la cola feliz 🐕");
    }
}

// 🐱 SUBCLASE 2 - También hereda de Animal
public class Gato extends Animal {
    private int vidas;
    
    public Gato(String nombre, int edad) {
        super(nombre, edad);
        vidas = 7;
    }
    
    // 🔁 SOBREESCRITURA diferente para Gato
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau miau! 🐱");
    }
    
    public void usarVida() {
        if (vidas > 0) {
            vidas--;
            System.out.println(nombre + " usa una vida. Le quedan: " + vidas);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("🐾 DEMOSTRACIÓN DE HERENCIA 🐾");
        
        // Creamos animales específicos
        Perro firulais = new Perro("Firulais", 3, "Labrador");
        Gato michi = new Gato("Michi", 2);
        
        System.out.println("\n🎪 COMPORTAMIENTOS HEREDADOS:");
        // Métodos heredados de Animal
        firulais.comer();
        michi.dormir();
        
        System.out.println("\n🎵 SONIDOS ESPECÍFICOS:");
        // Métodos sobreescritos - cada uno se comporta diferente
        firulais.hacerSonido();
        michi.hacerSonido();
        
        System.out.println("\n✨ COMPORTAMIENTOS ÚNICOS:");
        // Métodos que solo existen en las subclases
        firulais.moverCola();
        michi.usarVida();
    }
}

























public class Main {
    public static void main(String[] args) {
        System.out.println("🎭 MAGIA DEL POLIMORFISMO 🎭");
        
        // ✨ POLIMORFISMO: Podemos tratar diferentes objetos como Animal
        Animal[] zoologico = new Animal[4];
        
        zoologico[0] = new Perro("Rex", 4, "Pastor Alemán");
        zoologico[1] = new Gato("Luna", 1);
        zoologico[2] = new Perro("Bobby", 2, "Chihuahua");
        zoologico[3] = new Gato("Simba", 3);
        
        System.out.println("\n🏟️ DESFILE DE ANIMALES:");
        System.out.println("========================");
        
        // ¡MAGIA! El mismo código, diferentes resultados
        for (Animal animal : zoologico) {
            animal.hacerSonido(); // Cada animal hace su sonido único
        }
        
        System.out.println("\n🍽️ HORA DE COMER:");
        System.out.println("=================");
        for (Animal animal : zoologico) {
            animal.comer(); // Todos comen de la misma manera (heredado)
        }
    }
}

// 🐦 NUEVA SUBCLASE para demostrar polimorfismo
class Pajaro extends Animal {
    public Pajaro(String nombre, int edad) {
        super(nombre, edad);
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " canta: ¡Pío pío! 🐦");
    }
    
    @Override
    public void comer() {
        System.out.println(nombre + " está picoteando semillas 🌱");
    }
}























// 🎮 INTERFAZ - Define QUÉ debe hacer, no CÓMO
public interface Controlable {
    void encender();
    void apagar();
    void subirVolumen();
    void bajarVolumen();
    void cambiarCanal(int canal);
}

// 📺 CLASE que IMPLEMENTA la interfaz
public class Television implements Controlable {
    private boolean encendida;
    private int volumen;
    private int canalActual;
    
    public Television() {
        encendida = false;
        volumen = 10;
        canalActual = 1;
    }
    
    // Implementamos TODOS los métodos de la interfaz
    @Override
    public void encender() {
        encendida = true;
        System.out.println("📺 TV encendida - Bienvenido!");
    }
    
    @Override
    public void apagar() {
        encendida = false;
        System.out.println("📺 TV apagada");
    }
    
    @Override
    public void subirVolumen() {
        if (encendida && volumen < 100) {
            volumen += 5;
            System.out.println("🔊 Volumen: " + volumen);
        }
    }
    
    @Override
    public void bajarVolumen() {
        if (encendida && volumen > 0) {
            volumen -= 5;
            System.out.println("🔉 Volumen: " + volumen);
        }
    }
    
    @Override
    public void cambiarCanal(int canal) {
        if (encendida && canal > 0 && canal <= 999) {
            canalActual = canal;
            System.out.println("📡 Cambiando al canal: " + canalActual);
        }
    }
}

// 📻 OTRA CLASE que implementa la misma interfaz
public class Radio implements Controlable {
    private boolean encendida;
    private int volumen;
    private double frecuencia;
    
    public Radio() {
        encendida = false;
        volumen = 8;
        frecuencia = 95.5;
    }
    
    @Override
    public void encender() {
        encendida = true;
        System.out.println("📻 Radio encendida - Sintonizando " + frecuencia + " FM");
    }
    
    @Override
    public void apagar() {
        encendida = false;
        System.out.println("📻 Radio apagada");
    }
    
    @Override
    public void subirVolumen() {
        if (encendida && volumen < 50) {
            volumen += 2;
            System.out.println("🔊 Volumen radio: " + volumen);
        }
    }
    
    @Override
    public void bajarVolumen() {
        if (encendida && volumen > 0) {
            volumen -= 2;
            System.out.println("🔉 Volumen radio: " + volumen);
        }
    }
    
    @Override
    public void cambiarCanal(int canal) {
        // Para la radio, interpretamos "canal" como frecuencia
        if (encendida) {
            frecuencia = 80.0 + (canal * 0.5);
            System.out.println("🎵 Sintonizando: " + frecuencia + " FM");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("🎛️ DEMOSTRACIÓN DE ABSTRACCIÓN 🎛️");
        
        // Podemos tratar TV y Radio como Controlables
        Controlable[] dispositivos = new Controlable[2];
        dispositivos[0] = new Television();
        dispositivos[1] = new Radio();
        
        System.out.println("\n🏠 CASA INTELIGENTE - Control universal:");
        System.out.println("=======================================");
        
        for (Controlable dispositivo : dispositivos) {
            System.out.println("\n--- Operando dispositivo ---");
            dispositivo.encender();
            dispositivo.subirVolumen();
            dispositivo.subirVolumen();
            dispositivo.cambiarCanal(5);
            dispositivo.bajarVolumen();
            // dispositivo.apagar(); // Podemos apagar si queremos
        }
        
        System.out.println("\n💡 LA ABSTRACCIÓN EN ACCIÓN:");
        System.out.println("Sabemos QUÉ hace cada dispositivo (encender, subir volumen)");
        System.out.println("Pero NO necesitamos saber CÓMO lo hace internamente");
    }
}
