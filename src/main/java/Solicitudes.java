import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solicitudes {
  private static Solicitudes instance;

  private List<Solicitud> solicitudesPendientes;
  private List<Solicitud> solicitudesLiberadas;
  private List<Solicitud> solicitudesAprobadas;
  private List<Solicitud> solicitudesRechazadas;



  private Solicitudes(){
    solicitudesPendientes = new ArrayList<>();
    solicitudesLiberadas = new ArrayList<>();
    solicitudesAprobadas = new ArrayList<>();
    solicitudesRechazadas = new ArrayList<>();
  }
  public static Solicitudes instance() {
    return instance;
  }

  public List<Solicitud> obtenerSolicitudsDelProceso(Proceso proceso) {
    return solicitudesPendientes.stream().filter(
        solicitud -> solicitud.obtenerProceso().equals(proceso)
    ).collect(Collectors.toList());
  }

  public List<Solicitud> obtenerSolicitudPendienteDe(Usuario usuario){
    return solicitudesPendientes.stream().filter(
        solicitud -> solicitud.obtenerUsuarioColaborador().equals(usuario)
    ).collect(Collectors.toList());
  }

  public List<Solicitud> obtenerSolicitudesLeidasComoColaborador(Usuario usuario){
    return solicitudesLiberadas.stream().filter(
        solicitud -> solicitud.obtenerUsuarioColaborador().equals(usuario)
    ).collect(Collectors.toList());
  }

  public void agregar(Solicitud solicitud) {
    this.solicitudesPendientes.add(solicitud);
  }

  public void agregarSolicitudAprobada(Solicitud solicitud){
    this.solicitudesAprobadas.add(solicitud);
  }
  public void agregarSolicitudRechazada(Solicitud solicitud){
    this.solicitudesRechazadas.add(solicitud);
  }
  public void quitarSolicitudPendiente(Solicitud solicitud){
    this.solicitudesPendientes.remove(solicitud);
  }

  public void agregarSolicitudLiberadas(Solicitud solicitud) {
    this.solicitudesLiberadas.add(solicitud);
  }
}
