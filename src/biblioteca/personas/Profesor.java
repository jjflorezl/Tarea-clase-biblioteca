package biblioteca.personas;

public class Profesor extends Usuario {
    private String departamento;

    public Profesor(String nombre, String correo, String departamento) {
        super(nombre, correo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
