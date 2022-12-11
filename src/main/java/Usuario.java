public class Usuario {
  MedioDeNotificacion medioDeNotificacion;


  public void notificar(String mensaje){
    medioDeNotificacion.enviar(mensaje);
  }
}
