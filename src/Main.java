import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Prestamo;
import biblioteca.gestion.*;
import biblioteca.personas.Estudiante;
import biblioteca.personas.Profesor;
import biblioteca.personas.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Libro[] catalogo = new Libro[10];
    Usuario[] usuario = new Usuario[10];
    Prestamo[]  prestamo = new Prestamo[20];

        Biblioteca biblioteca = new Biblioteca(catalogo.length, usuario.length,prestamo.length);

    Libro l = new Libro("1", "hola", "carlos",1);
    catalogo[0]=l;
    Libro l2 = new Libro("2", "ola", "parlos",3);
    Libro l3 = new Libro("3", "si", "sara",4);
    catalogo[1]=l2;
    catalogo[2]=l3;
    biblioteca.agregarLibro(l);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        System.out.println(biblioteca.getCatalogo()[0].getIsbn());
        Estudiante e = new Estudiante("juan","jGmail",3);
        Estudiante e2 = new Estudiante("jose","hGmail",1);
        Profesor p = new Profesor("sebas","si.gaml","Pimp");
        usuario[0]=e;
        usuario[1]=e2;
        usuario[2]=p;
        biblioteca.registrarUsuario(usuario[0]);
        biblioteca.registrarUsuario(usuario[1]);
        biblioteca.registrarUsuario(usuario[2]);
        try{

            biblioteca.prestar(1,"1",6);
         //   biblioteca.prestar(1,"1",13);
         //  biblioteca.prestar(1,"1",4);
         // biblioteca.prestar(5,"hola",1);
         //   biblioteca.devolver(biblioteca.getPrestamos()[0].getIdPrestamo());
         // biblioteca.devolver(biblioteca.getPrestamos()[1].getIdPrestamo());
         //   System.out.println(biblioteca.listarLibrosDisponibles());
            System.out.println(biblioteca.listarPrestamosActivos());
        }catch(DiasPrestamoInvalidosException a){
            System.out.println("Error: "+a.getMessage());
        }catch(CopiaNoDisponibleException ex){
            System.out.println("Error: "+ex.getMessage());
        }catch(UsuarioNoExisteException exc){
            System.out.println("Error: "+exc.getMessage());
        }catch(PrestamoNoExisteException exce){
            System.out.println("Error: "+exce.getMessage());
        }catch(PrestamoYaDevueltoException  excec){
            System.out.println("Error: "+excec.getMessage());
        }catch(LibroNoExisteException a){
            System.out.println("Error: "+a.getMessage());
        }

    }
}