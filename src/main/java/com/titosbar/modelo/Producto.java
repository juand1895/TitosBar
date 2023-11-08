
package main.java.com.titosbar.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String descripcion;
    private double costo;
    private double precio;
    
   // private boolean elaborado;
   /* private final ArrayList<Object> listaProducto = null;*/

    // Constructor
    
    public Producto() {
    }

    public Producto(String nombre, String descripcion, double costo, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
      //  this.elaborado = elaborado;
      /*  this.listaProducto = new ArrayList<>();*/
    }

   

    // Métodos GET y SET para los atributos

    public Integer getId() {
        return id;
    }

    public void setId(Integer nombre) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

   /* public boolean isElaborado() {
        return elaborado;
    }

    public void setElaborado(boolean elaborado) {
        this.elaborado = elaborado;
    }*/

   

    
}
