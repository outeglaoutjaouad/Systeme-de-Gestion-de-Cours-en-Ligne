import java.util.*;
public class Certification {
    private int certId;
    private Date dateObtention;
    private Etudiant etudiant;
    private Cours cours;

    public Certification(int certId, Etudiant etudiant, Cours cours) {
        this.certId = certId;
        this.etudiant = etudiant;
        this.cours = cours;
        this.dateObtention = new Date();
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Cours getCours() {
        return cours;
    }

    public void afficherCertification() {
        System.out.println("=== Certification ===");
        System.out.println("Certificat N°" + certId);
        System.out.println("Étudiant : " + etudiant.getNom());
        System.out.println("Cours : " + cours.getTitre());
        System.out.println("Date d’obtention : " + dateObtention);
    }
}
