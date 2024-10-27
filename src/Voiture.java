public abstract class Voiture extends Vehicule implements Louable{
    private int nombrePlaces;

    public Voiture(String immatriculation, String marque, String modele, int anneeDeService, int kilometrage,statuts statut, int nombrePlaces, String typeCarburant) {
        super(immatriculation, marque, modele, anneeDeService, kilometrage,statut);
    }

    private enum carburants{
        essence,
        diesel,
        electrique
    }

    private carburants carburant;
    public Voiture(String immatriculation, String marque, String modele, int anneeDeService, double kilometrage,statuts statut,int nombrePlaces,carburants carburant){
        super(immatriculation,marque,modele,anneeDeService,kilometrage,statut);
        this.carburant=carburant;
        this.nombrePlaces=nombrePlaces;
    }
    @Override
    public void LouerVehicule() {
        if(!isDisponible()){
        }
        this.setDisponible(false);
    }

    private boolean isDisponible() {
        return false;
    }

    private boolean isStatut() {
        return false;
    }

    @Override
    public void RetournerVehicule() {

    }

    private void setDisponible(boolean b) {
    }

    private void setStatut(boolean b) {

    }
}
