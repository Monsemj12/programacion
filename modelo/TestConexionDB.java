/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class TestConexionDB {
    public static void main(String[] args) {
        //crear ojerto de la clase conexionbd
        ConexionBD conexionBD=new ConexionBD();
        //Llamar al metodo conectar
        System.out.println(conexionBD.conectar());
        //Llamar al metodo desconectar
        System.out.println(conexionBD.desConectar());
    }
    
}
