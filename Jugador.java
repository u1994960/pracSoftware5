/**
 * Jugador
 */
public class Jugador extends Persona {
    private int dorsal;
    private int targetes; // 0 sense, 1 groga, 2 vermella/expulsat
    private String rol;   // Porter, Extrem, etc. Si implementesim tot el codi seria de la classe rol (patro Strategy)

    public Jugador(String dni, String nom, String cognom, int dorsal) {
        super(dni, nom, cognom);
        this.dorsal = dorsal;
        this.targetes = 0;
        this.rol = "Jugador"; // Rol per defecte
    }

    public void rebre_missatge(String msg) {
        System.out.println(" [" + this.dorsal + "] " + this.nom + " " + this.cognom);
        System.out.println(" Missatge Rebut: " + msg + "\n");
    }

    public void rebreTargeta() {
        this.targetes++;
        
        System.out.println(">>> El jugador " + this.nom + " (Dorsal " + this.dorsal + ") ha estat amonestat.");
        
        if (this.targetes == 1) {
            System.out.println(">>> Efecte: TARGETA GROGA (Total: 1)");
        } else if (this.targetes >= 2) {
            System.out.println(">>> Efecte: TARGETA VERMELLA / EXPULSIÓ (Total: " + this.targetes + ")");
        }
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getDorsal() { return dorsal; }
    public String getRol() { return rol; }
    public int getTargetes() { return targetes; }
}
