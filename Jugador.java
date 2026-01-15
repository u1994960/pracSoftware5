/**
 * Jugador
 */
public class Jugador extends Persona {

  public Jugador(String dni, String nom, String cognom) {
    super(dni, nom, cognom);
  }

  public void rebre_missatge(String msg) {
    System.out.println(this.nom + " " + this.cognom);
    System.out.println("Missatge Rebut: " + msg + "\n");
  }
}
