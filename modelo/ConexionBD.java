package modelo;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {
    //Atributos
    private String host;
    private String nameBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;
    private String driveBD;
    
    private Connection conexion;
   
    //Constructor
    public ConexionBD() {
    this.host="localhost:3306";
    this.nameBD="bd_sistema_logi";
    this.urlBD="jdbc:mysql://" + host + "/" + this.nameBD;
    this.userBD="root";
    this.passwordBD="irving2023";//contraseña demysql
    this.driveBD="com.mysql.cj.jdbc.Driver";
    this.conexion=null;
    }

    public ConexionBD(String host, String nameBD, String urlBD, String userBD, String passwordBD, String driveBD, Connection conexion) {
        this.host = host;
        this.nameBD = nameBD;
        this.urlBD = urlBD;
        this.userBD = userBD;
        this.passwordBD = passwordBD;
        this.driveBD = driveBD;
        this.conexion = conexion;
    }
    
    //Metodo Get y Set
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNameBD() {
        return nameBD;
    }

    public void setNameBD(String nameBD) {
        this.nameBD = nameBD;
    }

    public String getUrlBD() {
        return urlBD;
    }

    public void setUrlBD(String urlBD) {
        this.urlBD = urlBD;
    }

    public String getUserBD() {
        return userBD;
    }

    public void setUserBD(String userBD) {
        this.userBD = userBD;
    }

    public String getPasswordBD() {
        return passwordBD;
    }

    public void setPasswordBD(String passwordBD) {
        this.passwordBD = passwordBD;
    }

    public String getDriveBD() {
        return driveBD;
    }

    public void setDriveBD(String driveBD) {
        this.driveBD = driveBD;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    // Metodo para conectar a la BD  
     public boolean conectar(){
        
        try {
            //Establecer el driver de mysql
            Class.forName(this.driveBD);
            //Establecer la conexion 
            this.conexion=DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
            //Validar si la conexion es diferente a null
            if (this.conexion!=null) {
                System.out.println("Conexion exitosa....");
                return true;
                
            }
        } catch (Exception e) {
            System.out.println("Error: No se puede conectar al servidor de Mysql" + e.getMessage());
        }
        return false;
    }
    
     // Metodo para desconectar a la BD  
    public boolean desConectar(){
        
        try {
          
            if (this.conexion!=null) {
                this.conexion.close();
                System.out.println("Se desconecto del servidor de Base de Datos...");
                return true;
                
            }
        } catch (Exception e) {
            System.out.println("Error: No se puede desconectar..." + e.getMessage());
        }
        return false;
    }  
}
