import java.util.ArrayList;
import java.util.Vector;

/**
 * Equip
 */
public class Equip {

  String nom;
  int nTarjaGroga;

  Entrenador entrenador;

  Vector<Jugador> pista;
  Vector<Jugador> banqueta;
  Vector<Jugador> jugador;

  public Equip(String nom, Entrenador e, Vector<Jugador> vecPista, Vector<Jugador> vecBanqueta) {
    this.nom = nom;
    this.nTarjaGroga = 0;
    this.entrenador = e;
    this.pista = vecPista;
    this.banqueta = vecBanqueta;
    this.jugador = new Vector<Jugador>();
    this.jugador.addAll(vecPista);
    this.jugador.addAll(vecBanqueta);
  }

  public void enviarMissatgeJugadorsPista(String msg) {
    this.entrenador.enviarMissatgeJugadors(msg, pista);
  }
}
