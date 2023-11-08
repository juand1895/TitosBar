package main.java.com.titosbar.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Mesa {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idMesa;
    private String nombre; 
    //CONSTRUCTOR

    public Mesa(int idMesa, String nombre) {
        this.idMesa = idMesa;
        this.nombre = nombre;
    }

    public Mesa() {
    }
    
    public Mesa(String nombre) {
        this.nombre = nombre;
    }
   //GETTERS Y SETTERS
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  //METODO TO STRING
    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", nombre=" + nombre + '}';
    }
}
