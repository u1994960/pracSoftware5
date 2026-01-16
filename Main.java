import java.util.Vector;

/**
 * Main
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // --- 1. INICIALITZACIÓ DE DADES DES DE FITXER ---
        Equip equipA, equipB;
        Entrenador entrenadorA, entrenadorB;
        Arbitre arbitre = new Arbitre("99999", "Ref", "Principal");

        Vector<Jugador> pistaA = new Vector<>();
        Vector<Jugador> banquetaA = new Vector<>();
        Vector<Jugador> pistaB = new Vector<>();
        Vector<Jugador> banquetaB = new Vector<>();

        try {
            // Llegim el fitxer jugadors.txt
            BufferedReader br = new BufferedReader(new FileReader("jugadors.txt"));
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] dades = linea.split(",");
                // Format esperat: Equip,Dorsal,Nom,Cognom
                
                if (dades.length >= 4) {
                    String equip = dades[0].trim();
                    int dorsal = Integer.parseInt(dades[1].trim());
                    String nom = dades[2].trim();
                    String cognom = dades[3].trim();
                    
                    Jugador j = new Jugador(dorsal + "DNI", nom, cognom, dorsal);
                    
                    if (equip.equalsIgnoreCase("A")) {
                        if (pistaA.size() < 7) pistaA.add(j);
                        else banquetaA.add(j);
                    } else if (equip.equalsIgnoreCase("B")) {
                        if (pistaB.size() < 7) pistaB.add(j);
                        else banquetaB.add(j);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR: No s'ha pogut llegir 'jugadors.txt'. Comprova que el fitxer existeix.");
            System.out.println("Detalls: " + e.getMessage());
        }

        entrenadorA = new Entrenador("5647893", "Pep", "Guardiola");
        entrenadorB = new Entrenador("12345", "Xavi", "Hernandez");

        equipA = new Equip("EquipA", entrenadorA, pistaA, banquetaA);
        equipB = new Equip("EquipB", entrenadorB, pistaB, banquetaB);

        // --- 2. BUCLE DEL MENÚ ---
        int opcio = -1;
        while (opcio != 0) {
            System.out.println("\n--- MENÚ HANDBOL ---");
            System.out.println("1. Enviar missatge a pista");
            System.out.println("2. Amonestar jugador");
            System.out.println("3. Fer canvi (Substitució)");
            System.out.println("0. Sortir");
            System.out.print("Escull opció: ");
            
            try {
                String input = sc.nextLine();
                // Evitem errors si l'usuari prem Enter sense escriure res
                if(input.isEmpty()) continue; 
                opcio = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcio = -1;
            }

            switch (opcio) {
                case 1:
                    System.out.print("Quin equip (A/B)? ");
                    String eqMsg = sc.nextLine();
                    System.out.print("Missatge: ");
                    String msg = sc.nextLine();
                    
                    if (eqMsg.equalsIgnoreCase("A")) equipA.enviarMissatgeJugadorsPista(msg);
                    else if (eqMsg.equalsIgnoreCase("B")) equipB.enviarMissatgeJugadorsPista(msg);
                    else System.out.println("Equip no trobat.");
                    break;

                case 2:
                    System.out.print("Dorsal del jugador a amonestar: ");
                    try {
                        int dorsalGroc = Integer.parseInt(sc.nextLine());
                        Jugador jGroc = equipA.getJugadorQualsevol(dorsalGroc);
                        if (jGroc == null) jGroc = equipB.getJugadorQualsevol(dorsalGroc);

                        if (jGroc != null) {
                            arbitre.amonestarJugador(jGroc);
                        } else {
                            System.out.println("Jugador no trobat amb aquest dorsal.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Has d'introduir un número de dorsal.");
                    }
                    break;

                case 3:
                    System.out.print("Quin equip fa el canvi (A/B)? ");
                    String eqCanvi = sc.nextLine();
                    Equip equipActiu = (eqCanvi.equalsIgnoreCase("A")) ? equipA : (eqCanvi.equalsIgnoreCase("B") ? equipB : null);

                    if (equipActiu != null) {
                        try {
                            System.out.print("Dorsal jugador que SURT (pista): ");
                            int dSurt = Integer.parseInt(sc.nextLine());
                            System.out.print("Dorsal jugador que ENTRA (banqueta): ");
                            int dEntra = Integer.parseInt(sc.nextLine());
                            equipActiu.ferCanvi(dSurt, dEntra);
                            
                        } catch (NumberFormatException e) {
                             System.out.println("Error: Els dorsals han de ser números.");
                        }
                    } else {
                        System.out.println("Equip incorrecte.");
                    }
                    break;

                case 0:
                    System.out.println("Adéu!");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }
        }
        sc.close();
    }
}
