public class ContactoTrabajo extends Contacto {
    private String empresa;
    private String puesto;
    
    public ContactoTrabajo(String nombre, String telefono, String email, String empresa, String puesto) {
        super(nombre, telefono, email);
        setEmpresa(empresa);
        setPuesto(puesto);
    }
    
    // Getters y Setters
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(String empresa) {
        if (empresa != null && !empresa.trim().isEmpty()) {
            this.empresa = empresa;
        } else {
            throw new IllegalArgumentException("❌ La empresa no puede estar vacía");
        }
    }
    
    public String getPuesto() {
        return puesto;
    }
    
    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            throw new IllegalArgumentException("❌ El puesto no puede estar vacío");
        }
    }
    
    // SOBREESCRITURA - Polimorfismo
    @Override
    public void mostrarInformacion() {
        System.out.println("💼 " + getNombre() + " - " + puesto);
        System.out.println("   🏢 Empresa: " + empresa);
        System.out.println("   📞 Teléfono: " + getTelefono());
        System.out.println("   📧 Email: " + getEmail());
    }
    
    // MÉTODO ESPECÍFICO de trabajo
    public void programarReunion() {
        System.out.println("📅 Programando reunión con " + getNombre() + " de " + empresa);
    }
}