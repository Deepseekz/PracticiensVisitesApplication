package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Visiteurs implements Serializable {
    private ArrayList<Visiteur> visiteurs;

    public Visiteur getVisiteur() {
        return visiteur;
    }

    private Visiteur visiteur;

    public Visiteurs(ArrayList<Visiteur> desVisiteurs) {
        this.visiteurs = desVisiteurs;
    }

    public ArrayList<Visiteur> getVisiteurs() {
        return visiteurs;
    }

    public void setVisiteurs(ArrayList<Visiteur> visiteurs) {
        this.visiteurs = visiteurs;
    }

    @Override
    public String toString() {
        return "Visiteurs{" +
                "lesVisiteurs=" + visiteurs +
                '}';
    }
}
