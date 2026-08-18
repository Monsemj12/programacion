package modelo;


import java.util.ArrayList;


public class TestUsuarioDAO {

    public static void main(String[] args) {
        //Crear objeto de la clase usuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        /* 
        //solicitar datos del usuario 
        usuarioDAO.setNombreUsuario("Juan Eduardo");
        usuarioDAO.setApPaternoUsuario("Castañeda");
        usuarioDAO.setApMaternoUsuario("Barrales");
        usuarioDAO.setEmailUsuario("25301494@uttt.edu.mx");

        //Llamar al metodo insertar
        System.out.println("" + usuarioDAO.insertar());
        System.out.println("Mensaje" + usuarioDAO.mensaje);
        
        //Crear objeto de la clase usuarioDAO
        UsuarioDAO usuarioDAO2 = new UsuarioDAO();
        //Solicitar datos del usuario
        usuarioDAO2.setIdUsuario(12);
        usuarioDAO2.setNombreUsuario("Juan Eduardo");
        usuarioDAO2.setApPaternoUsuario("castañeda");
        usuarioDAO2.setApMaternoUsuario("barrales");
        usuarioDAO2.setEmailUsuario("25301494@uttt.edu.mx");

        //Llamar al metodo Modificar
        System.out.println("" + usuarioDAO2.editar());
        System.out.println("Mensaje" + usuarioDAO2.mensaje);

        //Crear objeto de la clase usuarioDAO
        UsuarioDAO usuarioDAO3 = new UsuarioDAO();
        //Solicitar datos del usuario
        usuarioDAO3.setIdUsuario(12);
        //Llamar al metodo Modificar
        System.out.println("" + usuarioDAO3.eliminar());
        System.out.println("Mensaje" + usuarioDAO3.mensaje);
        */

        //Llamar al metodo consultar y mostrar el Arrylist
        System.out.println("Lista usuario:  \n "+ usuarioDAO.consultar());
        //Imprimir la lista de usuarios con un ciclo for 
        //Crear una lista de usuario
        
        ArrayList<Usuario> lista=new ArrayList<Usuario>();
        lista=usuarioDAO.consultar();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\n" + lista.get(i));            
        }

    }//Fin del main

}//Fin de la clase
