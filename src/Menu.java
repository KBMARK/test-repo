import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ParcAutomobile parc = new ParcAutomobile();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // vider le buffer
            traiterChoix(choix);
        } while (choix != 6);
    }

    public static void afficherMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Ajouter un véhicule");
        System.out.println("2. Ajouter un client");
        System.out.println("3. Donner la liste des véhicules disponibles");
        System.out.println("4. Louer un véhicule");
        System.out.println("5. Retourner un véhicule");
        System.out.println("6. Quitter");
        System.out.print("Choisissez une option : ");
    }

    public static void traiterChoix(int choix) {
        switch (choix) {
            case 1:
                ajouterVehicule();
                break;
            case 2:
                ajouterClient();
                break;
            case 3:
                listerVehiculesDisponibles();
                break;
            case 4:
                louerVehicule();
                break;
            case 5:
                retournerVehicule();
                break;
            case 6:
                System.out.println("Au revoir, a plus tard !");
                break;
            default:
                System.out.println("Oups,Option invalide.");
        }
    }

    public static void ajouterVehicule() {
        System.out.println("\n--- Ajouter un véhicule ---");
        System.out.print("Type de véhicule (1. Voiture, 2. Camion) : ");
        int type = scanner.nextInt();
        scanner.nextLine(); // vider le buffer

        System.out.print("Immatriculation : ");
        String immatriculation = scanner.nextLine();
        System.out.print("Marque : ");
        String marque = scanner.nextLine();
        System.out.print("Modèle : ");
        String modele = scanner.nextLine();
        System.out.print("Année de mise en service : ");
        int anneeService = scanner.nextInt();
        System.out.print("Kilométrage : ");
        int kilometrage = scanner.nextInt();

        if (type == 1) {
            System.out.print("Nombre de places : ");
            int nombrePlaces = scanner.nextInt();
            scanner.nextLine(); // vider le buffer
            System.out.print("Type de carburant (essence, diesel, électrique) : ");
            String typeCarburant = scanner.nextLine();
            Vehicule.statuts statut=null;
            int anneeDeService = 0;
            Voiture voiture = new Voiture(immatriculation, marque, modele, anneeDeService, kilometrage,statut, nombrePlaces, typeCarburant) {
                @Override
                public void LouerVehicule(Client client) throws VehiculeIndisponibleException, ClientNonAutoriseException {

                }

                @Override
                public void calculerPrixDeLocation() {

                }
            };
            parc.ajouterVehicule(voiture);
            System.out.println("Super,Voiture ajoutée avec succès !");
        } else if (type == 2) {
            System.out.print("Capacité de chargement (tonnes) : ");
            int capacite = scanner.nextInt();
            System.out.print("Nombre d'essieux : ");
            int essieux = scanner.nextInt();
            Camion camion = new Camion(immatriculation, marque, modele, anneeService, kilometrage, capacite, essieux) {
                @Override
                public void LouerVehicule() {

                }

                @Override
                public void calculerPrixDeLocation() {

                }
            };
            parc.ajouterVehicule(camion);
            System.out.println("Super,Camion ajouté avec succès !");
        } else {
            System.out.println("Type de véhicule invalide.");
        }
    }

    public static void ajouterClient() {
        System.out.println("\n--- Ajouter un client ---");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Numéro de permis : ");
        String numeroPermis = scanner.nextLine();
        System.out.print("Numéro de téléphone : ");
        String numeroTelephone = scanner.nextLine();

        Client client = new Client(nom, prenom, numeroPermis, numeroTelephone);
        clients.add(client);
        System.out.println("Super,Client ajouté avec succès !");
    }

    public static void listerVehiculesDisponibles() {
        System.out.println("\n--- Véhicules disponibles ---");
        ArrayList<Vehicule> disponibles = parc.getVehiculesDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("Oups,Aucun véhicule disponible.");
        } else {
            for (Vehicule v : disponibles) {
                System.out.println(v);
            }
        }
    }

    public static void louerVehicule() {
        System.out.println("\n--- Louer un véhicule ---");
        System.out.print("Numéro de permis du client : ");
        String numeroPermis = scanner.nextLine();
        Client client = chercherClient(numeroPermis);
        if (client == null) {
            System.out.println("Oups,Client introuvable.");
            return;
        }

        System.out.print("Immatriculation du véhicule à louer : ");
        String immatriculation = scanner.nextLine();
        Vehicule vehicule = chercherVehicule(immatriculation);
        if (vehicule == null) {
            System.out.println("Oups,Véhicule introuvable.");
            return;
        }

        try {
            client.louerVehicule(vehicule);
            System.out.println("Véhicule loué avec succès !");
        } catch (VehiculeIndisponibleException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void retournerVehicule() {
        System.out.println("\n--- Retourner un véhicule ---");
        System.out.print("Numéro de permis du client : ");
        String numeroPermis = scanner.nextLine();
        Client client = chercherClient(numeroPermis);
        if (client == null) {
            System.out.println(" Oups ,Client introuvable.");
            return;
        }

        System.out.print("Immatriculation du véhicule à retourner : ");
        String immatriculation = scanner.nextLine();
        Vehicule vehicule = chercherVehicule(immatriculation);
        if (vehicule == null || !client.getLocations().contains(vehicule)) {
            System.out.println("Le client n'a pas loué ce véhicule.");
            return;
        }

        client.retournerVehicule(vehicule);
        System.out.println("Véhicule retourné avec succès,a bientot !");
    }

    private static Client chercherClient(String numeroPermis) {
        for (Client client : clients) {
            if (client.getNumeroPermis().equals(numeroPermis)) {
                return client;
            }
        }
        return null;
    }

    private static Vehicule chercherVehicule(String immatriculation) {
        for (Vehicule vehicule : parc.getVehiculesDisponibles()) {
            if (vehicule.immatriculation.equals(immatriculation)) {
                return vehicule;
            }
        }
        return null;
    }
}
