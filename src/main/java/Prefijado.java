public class Prefijado implements OrdenDeAprobacion{
  @Override
  public void ejecutar(Proceso proceso) {
    proceso.obtenerSolicitudes();
  }
}
