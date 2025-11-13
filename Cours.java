import java.util.* ;
public class Cours {
    private int courseId;
    private String titre;
    private String description;
    private Instructeur instructeur;
    private List<Etudiant> etudiants;

    public Cours(int courseId,String titre,String description){
        this.courseId = courseId ;
        this.titre = titre;
        this.description = description;
        this.instructeur = instructeur ;
        this.etudiants = new ArrayList<>();
    }

    public String getTitre() {
        return titre;
    }

    public int getCourseId() {
        return courseId;
    }

    public void ajouterEtudiant(Etudiant e) {
        if (!etudiants.contains(e)) {
            etudiants.add(e);
            System.out.println(e.getNom() + " inscrit au cours " + titre);
        } else {
            System.out.println(e.getNom() + " est déjà inscrit à ce cours.");
        }
    }

    public void assignerInstructeur(Instructeur i) {
        this.instructeur = i;
        System.out.println("Instructeur " + i.getNom() + " assigné au cours " + titre);
    }

    public void afficherDetails(){
        System.out.println("course Id :"+courseId);
        System.out.println("titre :"+titre);
        System.out.println("description :"+description);
        System.out.println("instructeur :"+ (instructeur != null ? instructeur.getNom() : "Aucun"));
        System.out.println("Étudiants inscrits :");
        if (etudiants == null){
            System.out.println("  Aucun étudiant inscrit.");
        }else {
            for (Etudiant e : etudiants) {
                System.out.println("- " + e.getNom());
            }
        }
    }


}
