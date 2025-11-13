import java.util.* ;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Etudiant> etudiants = new ArrayList<>() ;
        List<Instructeur> instructeurs = new ArrayList<>();
        List<Cours> cours = new ArrayList<>() ;

        List<Cours> assignerCours = new ArrayList<>() ;
        List<Cours> EtudiantCours = new ArrayList<>() ;

        int nextCertId = 1;



        boolean comp = true ;
        while (comp){
            System.out.println("=== Menu Gestion des Cours ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Ajouter un instructeur");
            System.out.println("3. Ajouter un cours");
            System.out.println("4. Inscrire un étudiant à un cours");
            System.out.println("5. Assigner un instructeur à un cours");
            System.out.println("6. Afficher les détails d’un cours");
            System.out.println("7. Afficher les Cours enseignés par instructeur ");
            System.out.println("8. Afficher les Cours d'un etudiant ");
            System.out.println("9. Effectuer un paiement");
            System.out.println("10. Générer une certification");
            System.out.println("11. Quitter ");
            System.out.println("choix :");
            int choix = sc.nextInt();
            switch (choix){
                case 1 :
                    System.out.print("ID étudiant : ");
                    int idE = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nom : ");
                    String nomE = sc.nextLine();
                    System.out.print("Email : ");
                    String email = sc.nextLine();
                    etudiants.add(new Etudiant(idE,nomE,email)) ;
                    System.out.println("Étudiant ajouté avec succès !");
                    break;

                case 2 :
                    System.out.print("ID instructeur : ");
                    int idI = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nom : ");
                    String nomI = sc.nextLine();
                    System.out.print("Spécialisation : ");
                    String spec = sc.nextLine();
                    instructeurs.add(new Instructeur(idI,nomI,spec)) ;
                    System.out.println("Instructeur ajouté avec succès !");
                    break;

                case 3 :
                    System.out.print("ID cours : ");
                    int idC = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();
                    System.out.print("Description : ");
                    String desc = sc.nextLine();
                    cours.add(new Cours(idC, titre, desc));
                    System.out.println("Cours ajouté !");
                    break;

                case 4 :
                    System.out.print("Entrez l’ID de l’étudiant : ");
                    int idEtudiant = sc.nextInt();
                    System.out.print("Entrez l’ID du cours : ");
                    int idCours = sc.nextInt();

                    Etudiant e1 = null ;
                    Cours cour1 = null ;

                    for (Etudiant e : etudiants){
                        if (e.getStudentId() == idEtudiant){
                            e1 = e ;
                            break;
                        }
                    }

                    for (Cours c : cours){
                        if (c.getCourseId() == idCours ){
                            cour1 = c ;
                            break;
                        }
                    }
                    if (e1 != null && cour1 !=null){
                        cour1.ajouterEtudiant(e1);

                        EtudiantCours.add(cour1);
                    }else{
                        System.out.println("Étudiant ou cours introuvable !");
                    }

                    break;

                case 5 :
                    System.out.print("Entrez l’ID de l’Instructeur : ");
                    int idInstructeur = sc.nextInt();
                    System.out.print("Entrez l’ID du cours : ");
                    int idCour = sc.nextInt();
                    Instructeur instructeur1 = null ;
                    Cours cour = null ;
                    for (Instructeur i : instructeurs){
                        if (i.getInstructorId() == idInstructeur){
                            instructeur1 = i ;
                            break;
                        }
                    }

                    for (Cours c : cours){
                        if (c.getCourseId() == idCour){
                            cour = c ;
                            break;
                        }
                    }

                    if (instructeur1 != null && cour != null){
                        cour.assignerInstructeur(instructeur1);

                        assignerCours.add(cour);
                    }else {
                        System.out.println("Instructeur ou cours introuvable !");
                    }
                    break;

                case 6 :
                    System.out.print("Entrez l’ID du cours :");
                    int IDCour = sc.nextInt();
                    Cours c1 =  null ;
                    for (Cours c : cours){
                        if (c.getCourseId() == IDCour ){
                            c1 = c ;
                            break;
                        }
                    }
                    if (c1 !=null){
                        c1.afficherDetails();
                    }else {
                        System.out.println("Cours introuvable !");
                    }

                    break;
                case 7 :
                    System.out.print("Entrez l’ID de l’Instructeur : ");
                    int idIns = sc.nextInt();
                    Instructeur ins = null ;
                    for (Instructeur i : instructeurs){
                        if (i.getInstructorId() == idIns){
                            ins = i ;
                            break;
                        }
                    }

                    if(ins != null){
                        ins.afficherCours();
                        for (Cours c : assignerCours){
                            System.out.println("- "+c.getTitre());
                        }
                    }else {
                        System.out.println("Instructeur introuvable !");
                    }
                    break;

                case 8 :
                    System.out.print("Entrez l’ID de l’Etudiant : ");
                    int idEtu = sc.nextInt();
                    Etudiant Etu = null ;
                    for (Etudiant e : etudiants){
                        if (e.getStudentId() == idEtu){
                            Etu = e ;
                            break;
                        }
                    }

                    if(Etu != null){
                        Etu.afficherCours();
                        for (Cours c : EtudiantCours){
                            System.out.println("- "+c.getTitre());
                        }
                    }else {
                        System.out.println("Etudiant introuvable !");
                    }
                    break;


                case 9 :
                    System.out.println("Entrez l’ID de l’Etudiant : ");
                    int idEtudiantPaiement = sc.nextInt();

                    System.out.println("Entrez l’ID du cours :");
                    int idCourPaiement = sc.nextInt();

                    Etudiant etudiant = null ;
                    Cours courPaiement = null ;
                    for (Etudiant e : etudiants){
                        if (e.getStudentId() == idEtudiantPaiement){
                            etudiant = e ;
                            break;
                        }
                    }

                    for (Cours c : cours){
                        if (c.getCourseId() == idCourPaiement){
                            courPaiement = c ;
                            break;
                        }
                    }

                    if (etudiant != null && courPaiement !=null){
                        System.out.print("Montant : ");
                        double method = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Mode de paiement : ");
                        String mode = sc.nextLine();
                        Paiement.effectuerPaiement(method,mode,etudiant,courPaiement);
                    }else {
                        System.out.println("Étudiant ou cours introuvable !");
                    }

                    break;

                case 10 :
                    System.out.print("ID étudiant : ");
                    int idEt = sc.nextInt();
                    System.out.print("ID cours : ");
                    int IdCour = sc.nextInt();

                    Etudiant E = null ;
                    Cours C = null ;
                    for (Etudiant e : etudiants){
                        if (e.getStudentId() == idEt){
                            E = e ;
                            break;
                        }
                    }

                    for (Cours c : cours){
                        if (c.getCourseId() == IdCour){
                            C = c ;
                            break;
                        }
                    }
                    if (E != null && C !=null){
                       Certification.genererCertification(nextCertId++ ,E,C);
                    }else {
                        System.out.println("Étudiant ou cours introuvable !");
                    }

                    break;
                case 11 :
                    sc.close();
                    comp = false ;
                    System.out.println("au revoir");
                    break;
                default:
                    System.out.println("Choix invalide !");

            }
        }

    }
}