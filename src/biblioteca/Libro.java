package biblioteca;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int totalCopias;
    private int copiasDisponibles;

    public Libro(String isbn, String titulo, String autor, int totalCopias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.totalCopias = totalCopias;
        this.copiasDisponibles = totalCopias;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotalCopias() {
        return totalCopias;
    }

    public void setTotalCopias(int totalCopias) {
        this.totalCopias = totalCopias;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public void disminuirCopia(){
        if(this.copiasDisponibles>0){
            this.copiasDisponibles--;
        }else{
            System.out.println("no se puede disminuir a una cantidad de copias negativas");
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", totalCopias=" + totalCopias +
                ", copiasDisponibles=" + copiasDisponibles +
                '}';
    }

    public void aumentarCopia(){
        if(this.copiasDisponibles<this.totalCopias){
            this.copiasDisponibles++;
        }else{
            System.out.println("todas las copias disponibles ya estan en el inventario");
        }

    }
}
