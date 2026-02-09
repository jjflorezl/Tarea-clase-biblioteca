package biblioteca.gestion;

public class LibroNoExisteException extends RuntimeException {
    public LibroNoExisteException(String message) {
        super(message);
    }
}
