import java.util.ArrayList;
import java.util.List;

/**
 * Utilizo un gestor de proceso, para poder diferir en el tiempo
 * la creacion del mismo, y su liberacion;
 */
public class GestorDeProceso {

  private Documento documento;
  private OrdenDeAprobacion ordenDeAprobacion;
  private Usuario usuario;
  private List<Solicitud> solicitudes;

  public GestorDeProceso(){
    solicitudes = new ArrayList<>();
  }

  public GestorDeProceso asociarIniciador(Usuario usuario){
    this.usuario = usuario;
    return this;
  }

  public GestorDeProceso asociadDocumento(Documento documeto){
    this.documento = documeto;
    return this;
  }
  public GestorDeProceso asociarOrdenDeAprobacion(OrdenDeAprobacion ordenDeAprobacion){
    this.ordenDeAprobacion = ordenDeAprobacion;
    return this;
  }

  public GestorDeProceso agregarColaborador(Solicitud solicitud){
    this.solicitudes.add(solicitud);
    return this;
  }

  public Proceso liberar(){
    return new Proceso(usuario,ordenDeAprobacion);
  }

}
