import java.util.ArrayList;
import java.util.Scanner;


public class BibiotecaVirtual {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {

            System.out.println("Elige una opción: \n1.Agregar libro.\n2. Prestar Libro.\n3. Devolver Libro.\n4.Mostrar Libros.\n5. Salir.\n ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar Buffer

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    mostrarLibros();
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        }

    }

    private static void agregarLibro() {
        System.out.println("Introduce el título del libro:");
        String titulo = sc.nextLine();
        System.out.println("Introduce el autor del libro:");
        String autor = sc.nextLine();

        Libro libro = new Libro(titulo, autor);
        libros.add(libro);
        System.out.println("Libro agregado exitosamente.");
    }

    private static void prestarLibro() {
        System.out.println("Introduce el título del libro a prestar:");
        String titulo = sc.nextLine();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isPrestado()) {
                libro.prestar();
                System.out.println("Libro prestado exitosamente.");
                return;
            }
        }
        System.out.println("El libro no está disponible o no existe.");
    }

    private static void devolverLibro() {
        System.out.println("Introduce el título del libro a devolver:");
        String titulo = sc.nextLine();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isPrestado()) {
                libro.devolver();
                System.out.println("Libro devuelto exitosamente.");
                return;
            }
        }
        System.out.println("El libro no está prestado o no existe.");
    }

    private static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}

