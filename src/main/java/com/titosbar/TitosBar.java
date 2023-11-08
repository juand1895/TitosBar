package main.java.com.titosbar;

import main.java.com.titosbar.Controller.MesaController;
import main.java.com.titosbar.Controller.ProductoController;
import main.java.com.titosbar.IGU.PantallaMesas;
import main.java.com.titosbar.IGU.VentanaProducto;
import main.java.com.titosbar.Persistencia.ControllerPersistence;
import main.java.com.titosbar.modelo.Mesa;
import main.java.com.titosbar.modelo.Producto;

/*import main.java.com.titosbar.Persistencia.ControllerPersistence;*/

public class TitosBar {

    public static void main(String[] args) {
        /* PantallaMesas panta = new PantallaMesas();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);*/

        VentanaProducto venta = new VentanaProducto();
        venta.setVisible(true);
        venta.setLocationRelativeTo(null);

       /* MesaController control = new MesaController();
        Mesa me = new Mesa(40, "pedro");
        control.crearMesa(me);
        ProductoController controlx = new ProductoController();
        Producto pro = new Producto("pepe", "xd", 5, 5);
        controlx.crearProducto(pro);*/

    }

}
