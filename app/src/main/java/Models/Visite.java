package Models;

public class Visite {
    private int id;
    private String dateVisite;
    private String commentaire;
    private int practicien_id;
    private int motif_id;
    private int visiteur_id;


    public Visite(int id, String dateVisite, String commentaire, int practicien_id, int motif_id, int visiteur_id) {
        this.id = id;
        this.dateVisite = dateVisite;
        this.commentaire = commentaire;
        this.practicien_id = practicien_id;
        this.motif_id = motif_id;
        this.visiteur_id = visiteur_id;
    }
}
