import java.util.List;

public class Proceso {

  private OrdenDeAprobacion ordenDeAprobacion;
  private Usuario iniciador;

  public Proceso (Usuario usuario, OrdenDeAprobacion ordenDeAprobacion){
    this.ordenDeAprobacion = ordenDeAprobacion;
    this.iniciador = usuario;
  }

  public void agregarSolicitudes(Solicitud solicitud) {
    Solicitudes.instance().agregar(solicitud);
  }

  public void liberar(){
    List<Solicitud> colaboradores = Solicitudes
        .instance().obtenerSolicitudsDelProceso(this);
    ordenDeAprobacion.ejecutar(this);
  }

  public Usuario obtenerIniciador() {
    return this.iniciador;
  }
}
