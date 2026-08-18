package modelo;

public abstract class Reportes {
    //Metodos abstractos
    public abstract void realizarReporte();
   public abstract void realizarReportePDF();
   public abstract void imprimirReporte();
   //Metodo contreto 
   public void validarReporte(){
       System.out.println("Validar Reporte");   
   }
   
}
