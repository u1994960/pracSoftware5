/**
 * Arbitre
 */
public class Arbitre extends Persona {

    public Arbitre(String dni, String nom, String cognom) {
        super(dni, nom, cognom);
    }

    public void amonestarJugador(Jugador j) {
        System.out.println("L'àrbitre " + this.nom + " amonesta al jugador amb dorsal " + j.getDorsal());
        j.rebreTargeta();
    }
}
