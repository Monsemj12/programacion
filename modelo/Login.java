
package modelo;
import java.util.ArrayList;
import java.util.Date;


public class Login  {
    //Atributos

    private int idLogin;
    private String nombrelogin;
    private String contrasenia;
    private Date fechaCreacionLogin;

    private Usuario usuario;
    private RolUsuario rolUsuario;
    //metodos
    //constructor

    public Login() {
        //Crear objetos
        this.usuario = new Usuario();
        this.rolUsuario = new RolUsuario();
    }
    //metodo set y get

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getNombrelogin() {
        return nombrelogin;
    }

    public void setNombrelogin(String nombrelogin) {
        this.nombrelogin = nombrelogin;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getFechaCreacionLogin() {
        return fechaCreacionLogin;
    }

    public void setFechaCreacionLogin(Date fechaCreacionLogin) {
        this.fechaCreacionLogin = fechaCreacionLogin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    //metodo toString

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", nombrelogin=" + nombrelogin + ", contrasenia=" + contrasenia + ", fechaCreacionLogin=" + fechaCreacionLogin + ", usuario=" + usuario + ", rolUsuario=" + rolUsuario + '}';
    }

}