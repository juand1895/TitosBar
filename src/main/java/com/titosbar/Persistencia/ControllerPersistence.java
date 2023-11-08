
package main.java.com.titosbar.Persistencia;

import main.java.com.titosbar.modelo.Mesa;


public class ControllerPersistence {
    MesaJpaController mesaJPA = new MesaJpaController();

    public void crearMesa(Mesa me) {
        mesaJPA.create(me);
    }

    public void eliminarMesa(int id) {
        mesaJPA.destroy(id);
      
    }

    public void editarMesa(Mesa me) throws Exception {
        mesaJPA.edit(me);
       
    }

   
  
    
}
