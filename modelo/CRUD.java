package modelo;

import java.util.ArrayList;

public interface CRUD {
    //Definir los metodos para el CRUD
    //Create
    public boolean insertar();
    
    //Read
    public ArrayList consultar();
   public ArrayList consultarId(int id);
   
   //Update
   public boolean editar();
   
   //Delete
   public boolean eliminar();
   
}
