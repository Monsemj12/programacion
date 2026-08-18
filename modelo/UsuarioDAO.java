
package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO extends Usuario implements CRUD {

    //Atributos
    private CallableStatement sentenciaSQL;
    private ResultSet resultadoSQL;
    private ConexionBD conexionBD;

    private ArrayList<Usuario> listaUsuarios;
    public String mensaje = "";

    //Constructor 
    public UsuarioDAO() {
        this.sentenciaSQL = null;
        this.resultadoSQL = null;
        //Crear el objeto de conexion 
        this.conexionBD = new ConexionBD();
        //Crear la lista de usuarios
        this.listaUsuarios = new ArrayList<Usuario>();
    }

    public UsuarioDAO(CallableStatement sentenciaSQL, ResultSet resultadoSQL, ConexionBD conexionBD, ArrayList<Usuario> listaUsuarios) {
        this.sentenciaSQL = sentenciaSQL;
        this.resultadoSQL = resultadoSQL;
        this.conexionBD = conexionBD;
        this.listaUsuarios = listaUsuarios;
    }
    //Metodo Set y Get

    public CallableStatement getSentenciaSQL() {
        return sentenciaSQL;
    }

    public void setSentenciaSQL(CallableStatement sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    public ResultSet getResultadoSQL() {
        return resultadoSQL;
    }

    public void setResultadoSQL(ResultSet resultadoSQL) {
        this.resultadoSQL = resultadoSQL;
    }

    public ConexionBD getConexionBD() {
        return conexionBD;
    }

    public void setConexionBD(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //Metodos para el CRUD de Usuario
    @Override
    public boolean insertar() {
        if (this.conexionBD.conectar()) {
            try {
                //Preparar el procedimiento Almacenado para insertar 
                this.sentenciaSQL = this.conexionBD.getConexion().prepareCall("call bd_sistema_logi.sp_insertar_usuario(?, ?, ?, ?)");
                this.sentenciaSQL.setString(1, super.getNombreUsuario());
                this.sentenciaSQL.setString(2, super.getApPaternoUsuario());
                this.sentenciaSQL.setString(3, super.getApMaternoUsuario());
                this.sentenciaSQL.setString(4, super.getEmailUsuario());

                //Ejecutar el procedimiento almacenado y agregar el resultadoSQL
                this.resultadoSQL = this.sentenciaSQL.executeQuery();

                //Recorrer los datos 
                while (this.resultadoSQL.next()) {
                    this.mensaje = this.resultadoSQL.getString(1);
                }
                //Retornar verdadero si se inserto el usuario 
                return true;

            } catch (Exception e) {
                System.out.println("Error:"+ e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se conecto al servidor de MYSQL");
        }

        return false;
    }

    @Override
    public ArrayList consultar() {
        
        if (this.conexionBD.conectar()) {
            try {
                //Preparar el procedimento almacenado
                String sql="call bd_sistema_logi.sp_consulta()";
               this.sentenciaSQL=this.conexionBD.getConexion().prepareCall(sql);
               
               //Ejecutar el procedimento almacenado 
               this.resultadoSQL=this.sentenciaSQL.executeQuery();
               
               //Recorrer el resultadosql y agregar los datos ala lista de usuarios 
                while (this.resultadoSQL.next()) {
                    //Crear objeto de la clase usuario 
                    Usuario usuario=new Usuario();
                    
                    //Agregar los datos al objeto
                    usuario.setIdUsuario(this.resultadoSQL.getInt("idUsuario"));//Lo que va adentro de las comillas es el mombre del campo de la tabla usuario 
                    usuario.setNombreUsuario(this.resultadoSQL.getString("nombreUsuario"));
                    usuario.setApPaternoUsuario(this.resultadoSQL.getString("apPaternoUsuario"));    
                    usuario.setApMaternoUsuario(this.resultadoSQL.getString("apMaternoUsuario")); 
                    usuario.setEmailUsuario(this.resultadoSQL.getString("emailUsuario"));
                      
                    //Agregar el objeto usuario ala lista usuario
                    this.listaUsuarios.add(usuario);
                }
                
                this.sentenciaSQL.close();
                this.conexionBD.desConectar();
                        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de SQL: "+ e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se  puede conectar ala BD");
        }
        return this.listaUsuarios;

    }

    @Override
    public ArrayList consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editar() {
        if (this.conexionBD.conectar()) {
            try {
                //Preparar el procedimiento Almacenado para insertar
                this.sentenciaSQL = this.conexionBD.getConexion().prepareCall("call bd_sistema_logi.sp_modificar(?, ?, ?, ?, ?)");
                this.sentenciaSQL.setInt(1, super.getIdUsuario());
                this.sentenciaSQL.setString(2, super.getNombreUsuario());
                this.sentenciaSQL.setString(3, super.getApPaternoUsuario());
                this.sentenciaSQL.setString(4, super.getApMaternoUsuario());
                this.sentenciaSQL.setString(5, super.getEmailUsuario());
                
                 //Ejecutar el procedimiento almacenado y agregar el resultadoSQL
                this.resultadoSQL = this.sentenciaSQL.executeQuery();

                //Recorrer los datos 
                while (this.resultadoSQL.next()) {
                    this.mensaje = this.resultadoSQL.getString(1);
                }
                //Retornar verdadero si se inserto el usuario 
                return true;

            } catch (Exception e) {
                 System.out.println("Error:"+ e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se conecto al servidor de MYSQL");
        }
        return false;
    }

    @Override
    public boolean eliminar() {
          if (this.conexionBD.conectar()) {
            try {
                //Preparar el procedimiento Almacenado para insertar
                this.sentenciaSQL = this.conexionBD.getConexion().prepareCall("call bd_sistema_logi.sp_eliminar(?)");
                this.sentenciaSQL.setInt(1, super.getIdUsuario());
                
                 //Ejecutar el procedimiento almacenado y agregar el resultadoSQL
                this.resultadoSQL = this.sentenciaSQL.executeQuery();

                //Recorrer los datos 
                while (this.resultadoSQL.next()) {
                    this.mensaje = this.resultadoSQL.getString(1);
                }
                //Retornar verdadero si inserto el usuario 
                return true;

            } catch (Exception e) {
                 System.out.println("Error:"+ e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se conecto al servidor de MYSQL");
        }
        return false;
    }
}
