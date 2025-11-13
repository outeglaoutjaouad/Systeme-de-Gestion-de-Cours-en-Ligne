import java.util.ArrayList;
import java.util.List;

public class Instructeur {
    private int instructorId;
    private  String nom;
    private String specialisation ;

    public Instructeur(int instructorId, String nom, String specialisation){
        this.instructorId = instructorId;
        this.nom = nom ;
        this.specialisation = specialisation ;

    }

    public String getNom() {
        return nom;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void assignerCours(Cours c){
        c.assignerInstructeur(this);
    }

    public void afficherCours(){
        System.out.println("Cours enseignés par "+getNom()+ ":");


    }
}
