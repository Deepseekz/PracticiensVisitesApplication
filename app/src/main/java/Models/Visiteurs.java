package Models;

import java.util.ArrayList;

public class Visiteurs {
    private ArrayList<Visiteur> visiteurs;

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
