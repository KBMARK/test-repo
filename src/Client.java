import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String numeroPermis;
    private String telephone;
    private List<Vehicule> locationsEnCours;

    public Client(String nom, String prenom, String numeroPermis, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPermis = numeroPermis;
        this.telephone = telephone;
        this.locationsEnCours = new ArrayList<>();
    }
    public boolean bonPermis() {
        return true;
    }

    private static void LouerVehicule(Client client) {
    }
    public void louerVehicule(Vehicule vehicule) throws VehiculeIndisponibleException {
        vehicule.LouerVehicule();
        locationsEnCours.add(vehicule);
        System.out.println("la voiture a été louer");
    }



    public void retournerVehicule(Vehicule vehicule) {
        locationsEnCours.remove(vehicule);
        System.out.println("la voiture a été ramener");
    }
    public ArrayList<Vehicule> getLocations() {
        return (ArrayList<Vehicule>) locationsEnCours;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
