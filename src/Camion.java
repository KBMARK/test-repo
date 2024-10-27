public abstract class Camion extends Vehicule implements Louable {
    private int nombreEssieux;
    private double capaciteDeCharge;

    public Camion(String immatriculation, String marque, String modele, int anneeDeService, double kilometrage, double capaciteDeCharge, int nombreEssieux) {
        super(immatriculation, marque, modele, anneeDeService, kilometrage);
        this.capaciteDeCharge = capaciteDeCharge;
        this.nombreEssieux = nombreEssieux;
    }

    @Override
    public void LouerVehicule(Client client) throws VehiculeIndisponibleException,ClientNonAutoriseException {

        if(!isDisponible()){
            throw new VehiculeIndisponibleException("Le camion est indisponible");
        }
        if (!isDisponible()){
            throw new ClientNonAutoriseException("Le client l'est pas autorisé a louer ce camion");
        }
        this.setDisponilbe(true);
    }

    private void setDisponilbe(boolean b) {

    }

    private boolean isDisponible() {
        return false;
    }

    @Override
    public void RetournerVehicule() {
        this.setStatut(true);
    }

    private void setStatut(boolean b) {

    }
}
