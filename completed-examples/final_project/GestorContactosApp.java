import java.util.Scanner;

public class GestorContactosApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorContactos gestor = new GestorContactos();
        
        System.out.println("🎉 BIENVENIDO AL GESTOR DE CONTACTOS POO 🎉");
        System.out.println("===========================================");
        
        // DATOS DE EJEMPLO
        cargarDatosEjemplo(gestor);
        
        int opcion;
        do {
            mostrarMenu();
            System.out.print("👉 Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    agregarContactoInteractivo(scanner, gestor);
                    break;
                case 2:
                    listarContactos(gestor);
                    break;
                case 3:
                    buscarContactoInteractivo(scanner, gestor);
                    break;
                case 4:
                    eliminarContactoInteractivo(scanner, gestor);
                    break;
                case 5:
                    listarPorTipoInteractivo(scanner, gestor);
                    break;
                case 6:
                    gestor.estadisticas();
                    break;
                case 7:
                    realizarAccionesEspeciales(gestor);
                    break;
                case 0:
                    System.out.println("👋 ¡Gracias por usar el Gestor de Contactos POO!");
                    break;
                default:
                    System.out.println("❌ Opción no válida");
            }
            
            if (opcion != 0) {
                System.out.println("\n⏎ Presiona Enter para continuar...");
                scanner.nextLine();
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n📱 MENÚ PRINCIPAL - GESTOR DE CONTACTOS");
        System.out.println("=======================================");
        System.out.println("1. ➕ Agregar contacto");
        System.out.println("2. 📋 Listar todos los contactos");
        System.out.println("3. 🔍 Buscar contacto");
        System.out.println("4. 🗑️ Eliminar contacto");
        System.out.println("5. 🎯 Listar por tipo");
        System.out.println("6. 📊 Ver estadísticas");
        System.out.println("7. ⚡ Acciones especiales");
        System.out.println("0. 🚪 Salir");
    }
    
    private static void cargarDatosEjemplo(GestorContactos gestor) {
        // Contactos generales
        gestor.agregarContacto(new Contacto("Ana García", "987654321", "ana@email.com"));
        gestor.agregarContacto(new Contacto("Luis Martínez", "912345678", "luis@email.com"));
        
        // Contactos familiares
        gestor.agregarContacto(new ContactoFamiliar("María Pérez", "923456789", "maria@email.com", "Madre"));
        gestor.agregarContacto(new ContactoFamiliar("Carlos López", "934567890", "carlos@email.com", "Hermano"));
        
        // Contactos de trabajo
        gestor.agregarContacto(new ContactoTrabajo("Dra. Elena Ruiz", "945678901", "elena@clinica.com", "Clínica Central", "Médico"));
        gestor.agregarContacto(new ContactoTrabajo("Ing. Roberto Silva", "956789012", "roberto@tech.com", "Tech Solutions", "Ingeniero"));
        
        System.out.println("✅ " + gestor.getTotalContactos() + " contactos de ejemplo cargados");
    }
    
    private static void agregarContactoInteractivo(Scanner scanner, GestorContactos gestor) {
        System.out.println("\n➕ AGREGAR NUEVO CONTACTO");
        System.out.println("========================");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Teléfono (9 dígitos): ");
        String telefono = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.println("\n🎯 Tipo de contacto:");
        System.out.println("1. General");
        System.out.println("2. Familiar");
        System.out.println("3. Trabajo");
        System.out.print("Selecciona: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        try {
            switch (tipo) {
                case 1:
                    gestor.agregarContacto(new Contacto(nombre, telefono, email));
                    break;
                case 2:
                    System.out.print("Parentesco: ");
                    String parentesco = scanner.nextLine();
                    gestor.agregarContacto(new ContactoFamiliar(nombre, telefono, email, parentesco));
                    break;
                case 3:
                    System.out.print("Empresa: ");
                    String empresa = scanner.nextLine();
                    System.out.print("Puesto: ");
                    String puesto = scanner.nextLine();
                    gestor.agregarContacto(new ContactoTrabajo(nombre, telefono, email, empresa, puesto));
                    break;
                default:
                    System.out.println("❌ Tipo no válido, se creará como contacto general");
                    gestor.agregarContacto(new Contacto(nombre, telefono, email));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private static void listarContactos(GestorContactos gestor) {
        gestor.listarContactos();
    }
    
    private static void buscarContactoInteractivo(Scanner scanner, GestorContactos gestor) {
        System.out.print("\n🔍 Ingresa el nombre a buscar: ");
        String nombre = scanner.nextLine();
        
        Contacto contacto = gestor.buscarContacto(nombre);
        if (contacto != null) {
            System.out.println("✅ Contacto encontrado:");
            contacto.mostrarInformacion();
        } else {
            System.out.println("❌ Contacto no encontrado: " + nombre);
        }
    }
    
    private static void eliminarContactoInteractivo(Scanner scanner, GestorContactos gestor) {
        System.out.print("\n🗑️ Ingresa el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();
        
        gestor.eliminarContacto(nombre);
    }
    
    private static void listarPorTipoInteractivo(Scanner scanner, GestorContactos gestor) {
        System.out.println("\n🎯 LISTAR POR TIPO");
        System.out.println("1. 👨‍👩‍👧‍👦 Familiares");
        System.out.println("2. 💼 Trabajo");
        System.out.println("3. 👤 Generales");
        System.out.print("Selecciona: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        switch (tipo) {
            case 1: gestor.listarPorTipo("familiar"); break;
            case 2: gestor.listarPorTipo("trabajo"); break;
            case 3: gestor.listarPorTipo("general"); break;
            default: System.out.println("❌ Tipo no válido");
        }
    }
    
    private static void realizarAccionesEspeciales(GestorContactos gestor) {
        System.out.println("\n⚡ ACCIONES ESPECIALES");
        System.out.println("=====================");
        
        // Buscar algunos contactos específicos y realizar acciones
        Contacto familiar = gestor.buscarContacto("María Pérez");
        Contacto trabajo = gestor.buscarContacto("Dra. Elena Ruiz");
        Contacto general = gestor.buscarContacto("Ana García");
        
        if (familiar instanceof ContactoFamiliar) {
            ((ContactoFamiliar) familiar).recordarCumpleaños();
        }
        
        if (trabajo instanceof ContactoTrabajo) {
            ((ContactoTrabajo) trabajo).programarReunion();
        }
        
        if (general != null) {
            general.llamar();
            general.enviarEmail();
        }
    }
}