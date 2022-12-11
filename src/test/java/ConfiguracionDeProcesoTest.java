import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfiguracionDeProcesoTest {

  GestorDeProceso gestorDeProceso;
  Usuario iniciador;

  @BeforeEach
  public void setup(){
    iniciador = new Usuario();
    gestorDeProceso = new GestorDeProceso();
    gestorDeProceso.asociarIniciador(iniciador);
  }

  @Test
  public void asignarColaboradorTest(){
      Solicitud lector = new Lector();
      Solicitud firmante = new Firmante();
      gestorDeProceso.agregarColaborador(lector);
      gestorDeProceso.agregarColaborador(firmante);
  }

  @Test
  public void asignarUnDocumentoTest(){
    gestorDeProceso.asociadDocumento(new MockDocument());
  }

  @Test
  public void asignarUnOrdenDeAprobacionPrefijadoTest(){
    gestorDeProceso.asociarOrdenDeAprobacion(new Prefijado());
  }
  @Test
  public void asignarUnOrdenDeAprobacionIndistintoTest(){
    gestorDeProceso.asociarOrdenDeAprobacion(new Indistinto());
  }

  @Test
  public void liberarProcesoDeFirma(){
    Solicitud lector = new Lector();
    Solicitud firmante = new Firmante();

    gestorDeProceso.agregarColaborador(lector);
    gestorDeProceso.agregarColaborador(firmante);
    gestorDeProceso.asociadDocumento(new MockDocument());
    gestorDeProceso.asociarOrdenDeAprobacion(new Indistinto());
    gestorDeProceso.liberar();
  }
  private static class MockDocument implements Documento{
  }

}
