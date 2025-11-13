public class Etudiant {
    private int studentId;
    private String nom;
    private String email;

    public Etudiant(int studentId,String nom, String email){
        this.studentId = studentId ;
        this.nom = nom ;
        this.email = email ;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void  inscrire(Cours c){
         c.ajouterEtudiant(this);

    }

    public void afficherCours(){
        System.out.println(getNom() + " inscrit au cours :" );

    }
}
