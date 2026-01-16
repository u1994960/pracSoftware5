import java.util.ArrayList;
import java.util.Vector;

/**
 * Equip
 */
import java.util.Vector;

public class Equip {
    String nom;
    Entrenador entrenador;
    Vector<Jugador> pista;
    Vector<Jugador> banqueta;

    public Equip(String nom, Entrenador e, Vector<Jugador> vecPista, Vector<Jugador> vecBanqueta) {
        this.nom = nom;
        this.entrenador = e;
        this.pista = vecPista;
        this.banqueta = vecBanqueta;
    }

    public void enviarMissatgeJugadorsPista(String msg) {
        this.entrenador.enviarMissatgeJugadors(msg, pista);
    }

    // Mètode per buscar un jugador a la PISTA pel dorsal
    public Jugador getJugadorPista(int dorsal) {
        for (Jugador j : pista) {
            if (j.getDorsal() == dorsal) return j;
        }
        return null;
    }

    // Mètode per buscar un jugador a la BANQUETA pel dorsal
    public Jugador getJugadorBanqueta(int dorsal) {
        for (Jugador j : banqueta) {
            if (j.getDorsal() == dorsal) return j;
        }
        return null;
    }

    // Mètode per buscar en tot l'equip (per les targetes)
    public Jugador getJugadorQualsevol(int dorsal) {
        Jugador j = getJugadorPista(dorsal);
        if (j != null) return j;
        return getJugadorBanqueta(dorsal);
    }

    // Realitzar el canvi
    public boolean ferCanvi(int dorsalSurt, int dorsalEntra, String nouRol) {
        Jugador jSurt = getJugadorPista(dorsalSurt);
        Jugador jEntra = getJugadorBanqueta(dorsalEntra);

        if (jSurt != null && jEntra != null) {
            pista.remove(jSurt);
            banqueta.add(jSurt);

            banqueta.remove(jEntra);
            pista.add(jEntra);
            
            jEntra.setRol(nouRol); 

            System.out.println("--- CANVI REALITZAT ---");
            System.out.println("SURT: " + jSurt.nom + " (Dorsal " + jSurt.getDorsal() + ")");
            System.out.println("ENTRA: " + jEntra.nom + " (Dorsal " + jEntra.getDorsal() + ") amb rol: " + nouRol);
            return true;
        } else {
            System.out.println("Error: No s'han trobat els jugadors especificats.");
            return false;
        }
    }
    
    public String getNom() { return nom; }
}
