package modelo;

public class TestLoginDAO {
    public static void main(String[] args) {
        //crear objeto de loginDAO
        
        LoginDAO loginDAO=new LoginDAO();
        //Aregar los datos 
        loginDAO.getUsuario().setNombreUsuario("jorge");
         loginDAO.getUsuario().setApPaternoUsuario("polo");
          loginDAO.getUsuario().setApMaternoUsuario("perez ");
           loginDAO.getUsuario().setEmailUsuario("pedri29as2@uttt.edu.mx");
           loginDAO.setNombrelogin("panchito2");
           loginDAO.setContrasenia("1234");
           loginDAO.getRolUsuario().setIdRolUsuario(2);
           
           //Llamar al metodo Registrar login
           System.out.println(""+ loginDAO.registrarLogin(loginDAO));
           
        //llamar al metodo validarLogin
       // System.out.println(""+loginDAO.validarLogin("Angel Ulises", "123"));
       
       
    }
}
