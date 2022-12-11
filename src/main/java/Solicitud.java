
public abstract class Solicitud {
  private Usuario usuarioColaborador;
  private Proceso proceso;

  public void enviar(String mensaje){
    proceso.obtenerIniciador().notificar(mensaje);
    usuarioColaborador.notificar(mensaje);
  }

  public Usuario obtenerUsuarioColaborador() {
    return usuarioColaborador;
  }

  abstract void firmar();
  public void aprobar(){
    Solicitudes.instance().quitarSolicitudPendiente(this);
    this.firmar();
    Solicitudes.instance().agregarSolicitudAprobada(this);
    this.enviar("Aprobada");
  }
  public void rechazar() {
    Solicitudes.instance().quitarSolicitudPendiente(this);
    this.firmar();
    Solicitudes.instance().agregarSolicitudAprobada(this);
    this.enviar("Rechazada");
  }

  public Proceso obtenerProceso() {
    return proceso;
  }
}
