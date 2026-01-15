import java.util.Vector;

/**
 * Entrenador
 */
public class Entrenador extends Persona {

  public Entrenador(String dni, String nom, String cognom) {
    super(dni, nom, cognom);
  }

  public void enviarMissatgeJugadors(String msg, Vector<Jugador> jugadors) {
    for (Jugador jugador : jugadors) {
      jugador.rebre_missatge(msg);
    }
  }

}
