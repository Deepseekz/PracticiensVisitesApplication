package Models;

import java.util.ArrayList;

public class Visites {

    private ArrayList<Visite> visites;

    public Visites(ArrayList<Visite> desVisites) {
        this.visites = desVisites;
    }

    public ArrayList<Visite> getVisiteurs() {
        return visites;
    }

    public void setVisites(ArrayList<Visite> visites) {
        this.visites = visites;
    }

    @Override
    public String toString() {
        return "Visiteurs{" +
                "lesVisiteurs=" + visites +
                '}';
    }
}
