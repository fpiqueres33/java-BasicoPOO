import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestionEstudiantes {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Elige una opción: \n1. Agregar estudiante\n2. Mostrar estudiantes\n3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void agregarEstudiante() {
        System.out.println("Introduce el nombre del estudiante:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la edad del estudiante:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Introduce el grado del estudiante:");
        String grado = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, edad, grado);
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado exitosamente.");
    }

    private static void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el sistema.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }
}

