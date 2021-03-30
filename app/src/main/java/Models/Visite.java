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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(String dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getPracticien_id() {
        return practicien_id;
    }

    public void setPracticien_id(int practicien_id) {
        this.practicien_id = practicien_id;
    }

    public int getMotif_id() {
        return motif_id;
    }

    public void setMotif_id(int motif_id) {
        this.motif_id = motif_id;
    }

    public int getVisiteur_id() {
        return visiteur_id;
    }

    public void setVisiteur_id(int visiteur_id) {
        this.visiteur_id = visiteur_id;
    }


}
