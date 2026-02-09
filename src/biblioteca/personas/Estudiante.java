package biblioteca.personas;

public class Estudiante extends Usuario {
    private int semestre;

    public Estudiante(String nombre, String correo, int semestre) {
        super(nombre, correo);
        this.semestre = semestre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
