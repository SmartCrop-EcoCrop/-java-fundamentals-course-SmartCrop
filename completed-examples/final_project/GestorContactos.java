import java.util.ArrayList;
import java.util.List;

public class GestorContactos implements Gestionable {
    private List<Contacto> contactos;
    
    public GestorContactos() {
        this.contactos = new ArrayList<>();
        System.out.println("✅ Gestor de Contactos inicializado");
    }
    
    // AGREGAR CONTACTO
    @Override
    public void agregarContacto(Contacto contacto) {
        if (contacto != null) {
            contactos.add(contacto);
            System.out.println("✅ Contacto agregado: " + contacto.getNombre());
        } else {
            System.out.println("❌ No se puede agregar un contacto nulo");
        }
    }
    
    // ELIMINAR CONTACTO
    @Override
    public void eliminarContacto(String nombre) {
        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            contactos.remove(contacto);
            System.out.println("🗑️ Contacto eliminado: " + nombre);
        } else {
            System.out.println("❌ Contacto no encontrado: " + nombre);
        }
    }
    
    // BUSCAR CONTACTO
    @Override
    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; // No encontrado
    }
    
    // LISTAR TODOS LOS CONTACTOS
    @Override
    public void listarContactos() {
        System.out.println("\n📋 LISTA COMPLETA DE CONTACTOS:");
        System.out.println("===============================");
        
        if (contactos.isEmpty()) {
            System.out.println("📭 No hay contactos guardados");
            return;
        }
        
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i));
        }
    }
    
    // LISTAR POR TIPO (POLIMORFISMO)
    @Override
    public void listarPorTipo(String tipo) {
        System.out.println("\n🎯 CONTACTOS DE TIPO: " + tipo.toUpperCase());
        System.out.println("==============================");
        
        boolean encontrados = false;
        
        for (Contacto contacto : contactos) {
            switch (tipo.toLowerCase()) {
                case "familiar":
                    if (contacto instanceof ContactoFamiliar) {
                        contacto.mostrarInformacion();
                        encontrados = true;
                    }
                    break;
                    
                case "trabajo":
                    if (contacto instanceof ContactoTrabajo) {
                        contacto.mostrarInformacion();
                        encontrados = true;
                    }
                    break;
                    
                case "general":
                    if (!(contacto instanceof ContactoFamiliar) && 
                        !(contacto instanceof ContactoTrabajo)) {
                        contacto.mostrarInformacion();
                        encontrados = true;
                    }
                    break;
            }
        }
        
        if (!encontrados) {
            System.out.println("📭 No se encontraron contactos de tipo: " + tipo);
        }
    }
    
    // MÉTODOS ADICIONALES
    public int getTotalContactos() {
        return contactos.size();
    }
    
    public void estadisticas() {
        System.out.println("\n📊 ESTADÍSTICAS DEL GESTOR:");
        System.out.println("==========================");
        System.out.println("📞 Total contactos: " + getTotalContactos());
        
        long familiares = contactos.stream().filter(c -> c instanceof ContactoFamiliar).count();
        long trabajo = contactos.stream().filter(c -> c instanceof ContactoTrabajo).count();
        long general = contactos.size() - familiares - trabajo;
        
        System.out.println("👨‍👩‍👧‍👦 Contactos familiares: " + familiares);
        System.out.println("💼 Contactos de trabajo: " + trabajo);
        System.out.println("👤 Contactos generales: " + general);
    }
}