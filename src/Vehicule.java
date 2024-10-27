public abstract class Vehicule {

    public Vehicule(String immatriculation, String marque, String modele, int anneeDeService, double kilometrage) {

    }

    public abstract void LouerVehicule(Client client) throws VehiculeIndisponibleException,ClientNonAutoriseException;

    public void LouerVehicule() throws VehiculeIndisponibleException {
    }

    public boolean estDisponible() {
        return false;
    }

    protected enum statuts{
        disponible,
        louer
    }

    protected String immatriculation;
    protected String marque;
    protected String modele;
    protected int anneeDeService;
    protected double kilometrage;
    protected statuts statut;



    public Vehicule(String immatriculation, String marque, String modele, int anneeDeService, double kilometrage,statuts statut){
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.anneeDeService = anneeDeService;
        this.kilometrage = kilometrage;
        this.statut = statut;
    }

    public abstract void calculerPrixDeLocation();
}