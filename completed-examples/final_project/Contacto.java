public class Contacto {
    // ATRIBUTOS PRIVADOS - Encapsulación
    private String nombre;
    private String telefono;
    private String email;
    
    // CONSTRUCTOR
    public Contacto(String nombre, String telefono, String email) {
        setNombre(nombre);      // Usamos setters para validación
        setTelefono(telefono);
        setEmail(email);
    }
    
    // GETTERS Y SETTERS CON VALIDACIÓN
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("❌ El nombre no puede estar vacío");
        }
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        if (telefono != null && telefono.matches("\\d{9}")) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("❌ El teléfono debe tener 9 dígitos");
        }
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("❌ El email debe contener @");
        }
    }
    
    // MÉTODOS DE COMPORTAMIENTO
    public void mostrarInformacion() {
        System.out.println("👤 " + nombre);
        System.out.println("   📞 Teléfono: " + telefono);
        System.out.println("   📧 Email: " + email);
    }
    
    public void llamar() {
        System.out.println("📞 Llamando a " + nombre + " al número " + telefono + "...");
    }
    
    public void enviarEmail() {
        System.out.println("📧 Enviando email a " + nombre + " (" + email + ")...");
    }
    
    // MÉTODO toString para representación como String
    @Override
    public String toString() {
        return nombre + " | " + telefono + " | " + email;
    }
}