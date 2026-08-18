
package modelo;

import java.util.ArrayList;


public class RolUsuario extends Reportes implements CRUD {
    //Artributos
     private int idRolUsuario;
    private String nombreRolUsuario;
      private String descripcionRolUsuario;
    //Metodos
    //Constructor

    public RolUsuario() {
    }

    public RolUsuario(int idRolUsuario, String nombreRolUsuario, String descripcionRolUsuario) {
        this.idRolUsuario = idRolUsuario;
        this.nombreRolUsuario = nombreRolUsuario;
        this.descripcionRolUsuario = descripcionRolUsuario;
    }
     //Metodos set y get 

    public int getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(int idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public String getNombreRolUsuario() {
        return nombreRolUsuario;
    }

    public void setNombreRolUsuario(String nombreRolUsuario) {
        this.nombreRolUsuario = nombreRolUsuario;
    }

    public String getDescripcionRolUsuario() {
        return descripcionRolUsuario;
    }

    public void setDescripcionRolUsuario(String descripcionRolUsuario) {
        this.descripcionRolUsuario = descripcionRolUsuario;
    }
    //Metodo toString

    @Override
    public String toString() {
        return "RolUsuario{" + "idRolUsuario=" + idRolUsuario + ", nombreRolUsuario=" + nombreRolUsuario + ", descripcionRolUsuario=" + descripcionRolUsuario + '}';
    }

    @Override
    public boolean insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarReporte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void realizarReportePDF() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void imprimirReporte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}
