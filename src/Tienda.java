import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Elige una opción: \n1. Agregar producto\n2. Comprar producto\n3. Mostrar productos\n4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    comprarProducto();
                    break;
                case 3:
                    mostrarProductos();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void agregarProducto() {
        System.out.println("Introduce el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el precio del producto:");
        double precio = scanner.nextDouble();
        System.out.println("Introduce la cantidad del producto:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Producto producto = new Producto(nombre, precio, cantidad);
        productos.add(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    private static void comprarProducto() {
        System.out.println("Introduce el nombre del producto a comprar:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la cantidad a comprar:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                if (producto.getCantidad() >= cantidad) {
                    producto.reducirCantidad(cantidad);
                    System.out.println("Producto comprado exitosamente.");
                } else {
                    System.out.println("No hay suficiente cantidad en stock.");
                }
                return;
            }
        }
        System.out.println("El producto no existe.");
    }

    private static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
}

