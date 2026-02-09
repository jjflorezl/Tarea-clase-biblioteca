package biblioteca;

import biblioteca.gestion.*;
import biblioteca.personas.Estudiante;
import biblioteca.personas.Usuario;

public class Biblioteca {
    private Libro[] catalogo;
    private int numLibros;
    private Usuario[] usuarios;
    private int numUsuarios;
    private Prestamo[] prestamos;
    private int numPrestamos;

    public Biblioteca(int capCatalogo, int capUsuarios, int capPrestamos) {
        this.catalogo = new Libro[capCatalogo];
        this.usuarios = new Usuario[capUsuarios];
        this.prestamos = new Prestamo[capPrestamos];
        this.numLibros = capCatalogo;
        this.numUsuarios = capUsuarios;
        this.numPrestamos = capPrestamos;
    }

    public Libro[] getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Libro[] catalogo) {
        this.catalogo = catalogo;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getNumUsuarios() {
        return numUsuarios;
    }

    public void setNumUsuarios(int numUsuarios) {
        this.numUsuarios = numUsuarios;
    }

    public Prestamo[] getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamo[] prestamos) {
        this.prestamos = prestamos;
    }

    public int getNumPrestamos() {
        return numPrestamos;
    }

    public void setNumPrestamos(int numPrestamos) {
        this.numPrestamos = numPrestamos;
    }

    public void agregarLibro(Libro libro) {
        boolean estado = true;
        for(int i = 0; i < this.numLibros; i++) {
            if(this.catalogo[i] == libro) {
                estado = false;
                break;
            }
        }
        if(estado) {
            for(int i = 0; i < this.numLibros; i++) {
                if(this.catalogo[i]==null){
                    this.catalogo[i]=libro;
                    return;
                }
            }
        }
    }

    public void registrarUsuario(Usuario usuario) {
        boolean estado = true;
        for(int i = 0; i < this.numUsuarios; i++) {
            if(this.usuarios[i] == usuario) {
                estado = false;
                break;
            }
        }
        if(estado) {
            for(int i = 0; i < this.numUsuarios; i++) {
                if(this.usuarios[i]==null){
                    this.usuarios[i]=usuario;
                    return;
                }
            }
        }
    }

    public String prestar(int userId, String isbn, int dias )throws UsuarioNoExisteException, LibroNoExisteException, DiasPrestamoInvalidosException, CopiaNoDisponibleException, CapacidadLlenaException {
    boolean estado = false;
    int iUser = 0;
    int iLibro = 0;
        for(int i = 0; i < this.numUsuarios; i++) {
            if(this.usuarios[i].getId()==userId){
                estado = true;
                iUser = i;
                break;
            }
        }
        if(!estado) {
            throw new UsuarioNoExisteException("Usuario no encontrado");
        }
            estado = false;
            for(int i = 0; i < this.numLibros; i++) {
                if(this.catalogo[i].getIsbn().equalsIgnoreCase(isbn)){
                    estado = true;
                    iLibro = i;
                    break;
                }
            }
            if(!estado) {
                throw new LibroNoExisteException("Libro no encontrado");
            }
                if(this.usuarios[iUser] instanceof Estudiante){
                    if(dias<=0 || dias>7){
                        throw new DiasPrestamoInvalidosException("esta cantidad de dias es invalida para un estudiante");
                    }

                }else {
                    if (dias <= 0 || dias > 14) {
                        throw new DiasPrestamoInvalidosException("esta cantidad de dias es invalida para un profesor ");
                    }
                }

                if(this.catalogo[iLibro].getCopiasDisponibles()==0){
                throw  new CopiaNoDisponibleException("no hay mas copias disponibles");
                }
                estado = false;
                for(int i = 0; i < this.numPrestamos; i++) {
                    if (this.prestamos[i] == null) {
                        estado = true;
                    }
                }
                if(!estado) {
                    throw new CapacidadLlenaException("no esta permitido hacer mas prestamos");
                }
                Prestamo p = new Prestamo(this.usuarios[iUser],this.catalogo[iLibro],dias);
                p.setEstado(EstadoPrestamo.ACTIVO);
                this.catalogo[iLibro].disminuirCopia();
                for(int i = 0; i < this.numPrestamos; i++) {
                    if(this.prestamos[i]==null){
                        this.prestamos[i]=p;
                        break;
                    }
                }
                String retorno = ("PR- "+(numPrestamos+1));
                return retorno;
    }

    public void devolver(int idPrestamo){
        int iPrestamo = 0;
        boolean estado = false;
        for(int i = 0; i < this.numPrestamos; i++) {
            if(this.prestamos[i].getIdPrestamo()==idPrestamo){
                estado = true;
                break;
            }
        }
        if(!estado) {
            throw new PrestamoNoExisteException("Prestamo no encontrado");
        }
        if(this.prestamos[iPrestamo].getEstado()==EstadoPrestamo.DEVUELTO){
            throw new PrestamoYaDevueltoException("prestamo ya devuelto");
        }
    this.prestamos[iPrestamo].setEstado(EstadoPrestamo.DEVUELTO);
    this.prestamos[iPrestamo].getLibro().aumentarCopia();
    }

    public String listarLibrosDisponibles(){
        String lista = "";
        for(int i = 0; i < this.numLibros; i++){
            if (this.catalogo[i]==null) {
                break;
            }
            if(this.catalogo[i].getCopiasDisponibles()>0){
                lista += this.catalogo[i].getTitulo() + "\n";
            }
        }
        return lista;
    }
    public String listarPrestamosActivos(){
        String lista = "";
        for(int i = 0; i < this.numPrestamos; i++){
            if(this.prestamos[i]==null){
                break;
            }
            if(this.prestamos[i].getEstado()==EstadoPrestamo.ACTIVO){
                lista += (this.prestamos[i].getLibro().getTitulo() + "\n");
            }
        }
        return lista;
    }

    private boolean buscarLibroPorIsbn(String isbn){
        boolean existe = false;
        for(int i = 0; i < this.numLibros; i++){
            if(isbn.equals(this.catalogo[i].getIsbn())){
                existe = true;
            }
        }
        return existe;
    }
    private boolean buscarUsuarioPorId(int UserId){
        boolean existe = false;
        for(int i = 0; i < this.numUsuarios; i++){
            if(UserId==this.usuarios[i].getId()){
                existe = true;
            }
        }
        return existe;
    }
    private boolean buscarPrestamoPorId(String IdPrestamo){
        boolean existe = false;
        for(int i = 0; i < this.numPrestamos; i++){
            if(IdPrestamo.equals(this.prestamos[i].getIdPrestamo())){
                existe = true;
            }
        }
        return existe;
    }
    }

