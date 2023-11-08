package main.java.com.titosbar.Controller;

import main.java.com.titosbar.Persistencia.ControllerPersistence;
import main.java.com.titosbar.modelo.Mesa;


public class MesaController {
    
   ControllerPersistence persi = new ControllerPersistence();
   
      public void crearMesa (Mesa me){
        
        persi.crearMesa(me);
    
    }
      
    /**
     *
     * @param id
     */
    public void eliminarMesa(int id){
      
         persi.eliminarMesa(id);
     }
    public void editarMesa(Mesa me) throws Exception{
    persi.editarMesa(me);
    
    }
    
    
    
}
