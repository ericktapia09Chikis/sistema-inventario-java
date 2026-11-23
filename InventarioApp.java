import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    int id;
    String nombre;
    int cantidad;
    double precio;

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Producto: %-15s | Stock: %d | Precio: $%.2f", id, nombre, cantidad, precio);
    }
}

public class InventarioApp {
    public static void main(String[] args) {
        ArrayList<Producto> inventario = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Datos iniciales de prueba
        inventario.add(new Producto(1, "Laptop Dell", 10, 14500.00));
        inventario.add(new Producto(2, "Mouse Inalambrico", 35, 299.50));

        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    inventario.add(new Producto(id, nombre, cant, precio));
                    System.out.println("Producto agregado correctamente.");
                    break;
                case 2:
                    System.out.println("\n--- LISTA DE PRODUCTOS ---");
                    for (Producto p : inventario) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el ID a buscar: ");
                    int buscarId = sc.nextInt();
                    boolean encontrado = false;
                    for (Producto p : inventario) {
                        if (p.id == buscarId) {
                            System.out.println("Encontrado: " + p);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) System.out.println("Producto no encontrado.");
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }
}
