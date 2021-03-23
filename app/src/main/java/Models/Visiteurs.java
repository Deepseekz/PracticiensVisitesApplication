package Models;

import java.util.ArrayList;

public class Visiteurs {
    private ArrayList<Visiteur> lesVisiteurs;

    public Visiteurs(ArrayList<Visiteur> desVisiteurs) {
        this.lesVisiteurs = desVisiteurs;
    }

    public ArrayList<Visiteur> getLesVisiteurs() {
        return lesVisiteurs;
    }

    public void setLesVisiteurs(ArrayList<Visiteur> lesVisiteurs) {
        this.lesVisiteurs = lesVisiteurs;
    }

    @Override
    public String toString() {
        return "Visiteurs{" +
                "lesVisiteurs=" + lesVisiteurs +
                '}';
    }
}
