public interface Gestionable {
    void agregarContacto(Contacto contacto);
    void eliminarContacto(String nombre);
    Contacto buscarContacto(String nombre);
    void listarContactos();
    void listarPorTipo(String tipo);
}