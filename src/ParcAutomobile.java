import java.util.ArrayList;
import java.util.List;

class ParcAutomobile {
    private List<Vehicule> vehicules;

    public ParcAutomobile() {
        this.vehicules = new ArrayList<>();
    }

    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    public List<Vehicule> listerVehiculesDisponibles() {
        List<Vehicule> disponibles = new ArrayList<>();
        for (Vehicule v : vehicules) {
            if (!v.estDisponible()) {
                disponibles.add(v);
            }
        }
        return disponibles;
    }

    public ArrayList<Vehicule> getVehiculesDisponibles() {
        return null;
    }
}

