import java.util.Vector;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    Equip equipA, equipB;
    Entrenador entrenadorA, entrenadorB;
    Vector<Jugador> pistaA = new Vector<Jugador>();
    Vector<Jugador> pistaB = new Vector<Jugador>();
    Vector<Jugador> banquetaA = new Vector<Jugador>();
    Vector<Jugador> banquetaB = new Vector<Jugador>();
    for (int i = 0; i < 30; i++) {
      Jugador act = new Jugador(Integer.toString(100 * i), "Jugador" + Integer.toString(i),
          "Cognom" + Integer.toString(i));
      if (i < 12) {
        pistaA.add(act);
      } else if (i < 15) {
        banquetaA.add(act);
      } else if (i < 27) {
        pistaB.add(act);
      } else {
        banquetaB.add(act);
      }
    }
    entrenadorA = new Entrenador("5647893", "EntrenadorA", "CognomA");
    entrenadorB = new Entrenador("12345", "EntrenadorB", "CognomB");

    equipA = new Equip("EquipA", entrenadorA, pistaA, banquetaA);
    equipB = new Equip("EquipB", entrenadorB, pistaB, banquetaB);

    equipA.enviarMissatgeJugadorsPista("Poseu-vos al atac");
  }
}
