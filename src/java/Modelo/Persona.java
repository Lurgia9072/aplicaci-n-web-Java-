
package Modelo;

public class Persona {
   int id;
    String cliente ;
    String estado;
    String fecha;
    

    public Persona() {
    }

    public Persona(int id, String cliente, String estado, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
        this.fecha = fecha;
    
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

   
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getfecha() {
        return fecha;
    }

   
   
}
