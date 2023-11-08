
package main.java.com.titosbar.Persistencia;

import java.util.List;
import main.java.com.titosbar.modelo.Producto;


public class ProductoService {
    ProductoJpa projpa = new ProductoJpa();

    public void crearProducto(Producto pro) {
       projpa.create(pro);
    }

    public List<Producto> listarProductos() {
       return projpa.findProductoEntities();
    }
}
