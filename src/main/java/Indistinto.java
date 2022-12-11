public class Indistinto implements OrdenDeAprobacion{

  @Override
  public void ejecutar(Proceso proceso) {
    Solicitudes.instance().obtenerSolicitudsDelProceso(proceso)
        .forEach(
            solicitud -> {
              solicitud.enviar("Solicitud liberada");
              Solicitudes.instance().quitarSolicitudPendiente(solicitud);
              Solicitudes.instance().agregarSolicitudLiberadas(solicitud);
            }
        );
  }

}
