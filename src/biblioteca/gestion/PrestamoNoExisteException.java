package biblioteca.gestion;

public class PrestamoNoExisteException extends RuntimeException {
    public PrestamoNoExisteException(String message) {
        super(message);
    }
}
