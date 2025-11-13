import java.util.*;
public class Certification {
    private static List<Certification> certifications = new ArrayList<>();

    private int certId;
    private Etudiant etudiant;
    private Cours cours;
    private Date dateObtention;

    public Certification(int certId, Etudiant etudiant, Cours cours) {
        this.certId = certId;
        this.etudiant = etudiant;
        this.cours = cours;
        this.dateObtention = new Date();
    }

    public void afficherCertification() {
        System.out.println("\n Certification :");
        System.out.println("ID : " + certId);
        System.out.println("Étudiant : " + etudiant.getNom());
        System.out.println("Cours : " + cours.getTitre());
        System.out.println("Date d’obtention : " + dateObtention);
    }

    public static boolean estCertifiePourCours(Etudiant e, Cours c) {
        for (Certification cert : certifications) {
            if (cert.etudiant == e && cert.cours == c){
                return true;
            }
        }
        return false;
    }

    public static void genererCertification(int id, Etudiant e, Cours c) {
        if (!estCertifiePourCours(e, c)) {
            Certification cert = new Certification(id, e, c);
            certifications.add(cert);
            cert.afficherCertification();
        } else {
            System.out.println(" L’étudiant possède déjà une certification pour ce cours.");
        }
    }
}
