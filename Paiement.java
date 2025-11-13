import java.util.*;

public class Paiement {
    private static List<Paiement> paiementsEffectues = new ArrayList<>();

    private double montant;
    private Date datePaiement;
    private String modePaiement;
    private Etudiant etudiant;
    private Cours cours;

    public Paiement(double montant, String modePaiement, Etudiant etudiant, Cours cours) {
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.etudiant = etudiant;
        this.cours = cours;
        this.datePaiement = new Date();
    }

    public void afficherPaiement() {
        System.out.println("Montant : " + montant + " DH");
        System.out.println("Date : " + datePaiement);
        System.out.println("Mode : " + modePaiement);
        System.out.println("Étudiant : " + etudiant.getNom());
        System.out.println("Cours : " + cours.getTitre());
    }

    public static boolean aPaye(Etudiant e, Cours c) {
        for (Paiement p : paiementsEffectues) {
            if (p.etudiant == e && p.cours == c){
                return true;
            }
        }
        return false;
    }

    public static void effectuerPaiement(double montant, String mode, Etudiant e, Cours c) {
        if (!aPaye(e, c)) {
            Paiement p = new Paiement(montant, mode, e, c);
            paiementsEffectues.add(p);
            System.out.println("Paiement effectué avec succès !");
        } else {
            System.out.println(" Cet étudiant a déjà payé ce cours.");
        }
    }

    public static List<Paiement> getPaiements() {
        return paiementsEffectues;
    }
}
