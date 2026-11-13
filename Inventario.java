import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos = new ArrayList<>();

    // Arreglo simple de categorías (requisito del núcleo)
    private String[] categorias = {"Aseo", "Alimentos", "Tecnología"};

    public void agregar(Producto p) {
        productos.add(p);
    }

    public boolean existeCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public void mostrarTodos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("----- PRODUCTOS -----");
        double valorTotal = 0;
        for (Producto p : productos) {
            p.mostrarInformacion();
            valorTotal += p.getPrecio() * p.getCantidad();
        }
        System.out.println("Valor total del inventario: " + valorTotal);
    }

    public Producto buscarPorCodigo(int codigo) throws ProductoNoEncontradoException {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("El producto no fue encontrado.");
    }

    public void mostrarCategorias() {
        System.out.println("Categorías disponibles:");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println("  - " + categorias[i]);
        }
    }
}
