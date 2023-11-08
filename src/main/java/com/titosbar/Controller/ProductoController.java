
package main.java.com.titosbar.Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.java.com.titosbar.Persistencia.ProductoService;
import main.java.com.titosbar.modelo.Producto;


public class ProductoController {
    ProductoService productoService = new ProductoService();
   
    public void crearProducto (Producto pro){
        productoService.crearProducto(pro);
    }

    public void guardar(String nombrepro, String descrip, Double costox, Double preciox) {
        Producto produ = new Producto();
        produ.setNombre(nombrepro);
        produ.setDescripcion(descrip);
        produ.setCosto(costox);
        produ.setPrecio(preciox);
        productoService.crearProducto(produ);
    }
    
   public void listarProducto(JTable tabla){
        
        String[] titulos = {"ID","NOMBRE","DESCRIPCION","COSTO","PRECIO"};
        DefaultTableModel model=new DefaultTableModel(null,titulos);
        tabla.setModel(model);
        List<Producto> datos =  productoService.listarProductos();
        String[] productos = new String[5];
        for(Producto prod: datos){
            productos[0] = prod.getId()+"";
            productos[1] = prod.getNombre();
            productos[2] = prod.getDescripcion();
            productos[3] = prod.getCosto()+"";
            productos[4] = prod.getPrecio()+"";
            model.addRow(productos);
        }
        tabla.setVisible(true);
        
      System.out.println("Producto="+productoService.listarProductos().get(0));
    }
    
    
}
