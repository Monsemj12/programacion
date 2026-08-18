
package modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class LoginDAO extends Login {

    //Atributos
    private CallableStatement sentenciaSQL;
    private ResultSet resultadoSQL;
    private ConexionBD conexionBD;

    //Constructor
    public LoginDAO() {
        this.sentenciaSQL = null;
        this.resultadoSQL = null;
        //crear objeto de la clase conexionbd
        this.conexionBD = new ConexionBD();
    }

    public LoginDAO(CallableStatement sentenciaSQL, ResultSet resultadoSQL) {
        this.sentenciaSQL = sentenciaSQL;
        this.resultadoSQL = resultadoSQL;
        //crear objeto de la clase conexionbd
        this.conexionBD = new ConexionBD();
    }

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

    //Metodo para validar el login
    public boolean validarLogin(String user, String pass) {
        //Asignar los valores a la atributos nombreUsusario y contraseniaLogin
        super.getUsuario().setNombreUsuario(user);
        super.setContrasenia(pass);

        //validar si existe la conexion ala BD
        if (this.conexionBD.conectar()) {

            try {
                //Preparar el procedimiento Almacenado de SQL
                this.sentenciaSQL = this.conexionBD.getConexion().prepareCall("call bd_sistema_logi.sp_validar_login(?, ?)");
                this.sentenciaSQL.setString(1, super.getUsuario().getNombreUsuario());
                this.sentenciaSQL.setString(2, this.getContrasenia());
                //Ejecutar el prosedimiento almacenacenado
                // this.sentenciaSQL.execute();
                //Asignar los datos al objeto resultadoSQL
                this.resultadoSQL = this.sentenciaSQL.executeQuery();
                //Validar si el rrsultado es diferente de null
                while (this.resultadoSQL.next()) {
                    //Asignar los resultados a variable
                    String usuario = this.resultadoSQL.getString(1);
                    String contrasenia = this.resultadoSQL.getString(2);
                    // Validar si resultadoSQL es diferente de null
                    if (usuario.equals(super.getUsuario().getNombreUsuario())
                            && contrasenia.equals(super.getContrasenia())) {
                        return true;
                    } else if (this.resultadoSQL.getString(1) != null) {
                        System.out.println(this.resultadoSQL.getString(1));

                    } else {
                        return false;
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de SQL: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se establecio la conexion a la BD");
        }
        return false;
    }

    //Metodo para registrar login 
    public boolean registrarLogin(Login login) {
        if (this.conexionBD.conectar()) {
            try {
                //Preparar el procedimiento almacenado 
                String sql="call bd_sistema_logi.sp_registrar(?, ?, ?, ?, ?, ?, ?)";
                this.sentenciaSQL = this.conexionBD.getConexion().prepareCall(sql);
                this.sentenciaSQL.setString(1, login.getUsuario().getNombreUsuario());
                 this.sentenciaSQL.setString(2, login.getUsuario().getApPaternoUsuario());
                 this.sentenciaSQL.setString(3, login.getUsuario().getApMaternoUsuario());
                 this.sentenciaSQL.setString(4, login.getUsuario().getEmailUsuario());
                 
                 this.sentenciaSQL.setString(5, login.getNombrelogin());
                 this.sentenciaSQL.setString(6, login.getContrasenia());
                 
                 this.sentenciaSQL.setInt(7, login.getRolUsuario().getIdRolUsuario());
                 
                 //Ejecutar el procedimiento Almacenado
                 this.resultadoSQL=this.sentenciaSQL.executeQuery();
                        
                 while (this.resultadoSQL.next()) {                    
                  JOptionPane.showMessageDialog(null, "Mensaje:" + this.resultadoSQL.getString(1));   
                }
                 return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "No existe conexion a la BD");
        } else {
        }

        return false;
    }

}//fin de la clase LoginDAO
