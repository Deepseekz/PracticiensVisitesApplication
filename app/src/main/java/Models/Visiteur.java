package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Visiteur implements Serializable {
    private int id;
    private String matricule;
    private String username;
    private String password;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private String dateEmbauche;
    private ArrayList<Visite> visites;

    public ArrayList<Visite> getVisites() {
        return visites;
    }

    public void setVisites(ArrayList<Visite> visites) {
        this.visites = visites;
    }


    public Visiteur(int unId, String unMatricule, String unUsername, String unPassword, String unNom, String unPrenom, String unTel, String unMail, String uneDateEmbauche) {
        this.id = unId;
        this.matricule = unMatricule;
        this.username = unUsername;
        this.password = unPassword;
        this.nom = unNom;
        this.prenom = unPrenom;
        this.tel = unTel;
        this.mail = unMail;
        this.dateEmbauche = uneDateEmbauche;
        this.visites = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    @Override
    public String toString() {
        return "Visiteur{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", dateEmbauche='" + dateEmbauche + '\'' +
                '}';
    }
}
