package biblioteca;

import biblioteca.gestion.EstadoPrestamo;
import biblioteca.personas.Usuario;

public class Prestamo {
    private int idPrestamo;
    private static int prestamoGlobal=0;
    private Usuario usuario;
    private Libro libro;
    private int diasPrestamo;
    private EstadoPrestamo estado;

    public Prestamo(Usuario usuario, Libro libro, int diasPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.diasPrestamo = diasPrestamo;
        this.idPrestamo = ++prestamoGlobal;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public void marcarDevuelto(){
        this.estado=EstadoPrestamo.DEVUELTO;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", usuario=" + usuario +
                ", libro=" + libro +
                ", diasPrestamo=" + diasPrestamo +
                ", estado=" + estado +
                '}';
    }
}
