import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;

        do {
            System.out.println("=================================");
            System.out.println("      SISTEMA DE INVENTARIO");
            System.out.println("=================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Error 1: entrada inválida en el menú
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarProducto(scanner, inventario);
                    break;
                case 2:
                    inventario.mostrarTodos();
                    break;
                case 3:
                    buscarProducto(scanner, inventario);
                    break;
                case 4:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Elija entre 1 y 4.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarProducto(Scanner scanner, Inventario inventario) {
        // Segundo try-catch (extra): valida números y valores negativos
        try {
            inventario.mostrarCategorias();

            System.out.print("Código: ");
            int codigo = Integer.parseInt(scanner.nextLine().trim());
            if (inventario.existeCodigo(codigo)) {
                System.out.println("Error: ya existe un producto con ese código.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());

            if (precio < 0 || cantidad < 0) {
                System.out.println("Error: el precio y la cantidad no pueden ser negativos.");
                return;
            }

            inventario.agregar(new Producto(codigo, nombre, precio, cantidad));
            System.out.println("Producto registrado correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un valor numérico válido.");
        }
    }

    private static void buscarProducto(Scanner scanner, Inventario inventario) {
        System.out.print("Ingrese el código: ");
        try {
            int codigo = Integer.parseInt(scanner.nextLine().trim());
            Producto p = inventario.buscarPorCodigo(codigo);
            p.mostrarInformacion();
        } catch (NumberFormatException e) {
            System.out.println("Error: el código debe ser un número.");
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
