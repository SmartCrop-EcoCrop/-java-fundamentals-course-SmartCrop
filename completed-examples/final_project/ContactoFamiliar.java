public class ContactoFamiliar extends Contacto {
    private String parentesco;
    
    public ContactoFamiliar(String nombre, String telefono, String email, String parentesco) {
        super(nombre, telefono, email); // Llama al constructor del padre
        setParentesco(parentesco);
    }
    
    // Getter y Setter específico
    public String getParentesco() {
        return parentesco;
    }
    
    public void setParentesco(String parentesco) {
        if (parentesco != null && !parentesco.trim().isEmpty()) {
            this.parentesco = parentesco;
        } else {
            throw new IllegalArgumentException("❌ El parentesco no puede estar vacío");
        }
    }
    
    // SOBREESCRITURA - Polimorfismo
    @Override
    public void mostrarInformacion() {
        System.out.println("👨‍👩‍👧‍👦 " + getNombre() + " (" + parentesco + ")");
        System.out.println("   📞 Teléfono: " + getTelefono());
        System.out.println("   📧 Email: " + getEmail());
    }
    
    // MÉTODO ESPECÍFICO de familia
    public void recordarCumpleaños() {
        System.out.println("🎂 Recordatorio: El cumpleaños de " + getNombre() + " es pronto!");
    }
}