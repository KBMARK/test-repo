Cette applciation est un systeme de gestion de location de vehicules.Il est structurer de la manière suivante:
class vehicule qui contient les attributs comme immatriculation la marque etc et elle inclut une méthode calculerPrixLocation() qui sera implémentée par les sous classes
comme sous classes de vehicule nous avons la class voiture et la class camion
Nous vons la classe client qui contient les informations des clients et la lsite de leurs locations en cours
cette application contient une intarface louable qui definit les methodes louer() et retourner().cette interface est implémentée dans les classes voiture et camion ce qui permet que lorsqu'un véhicule est loué son statut change en "loué" et lorsqu'il est retourné, son statut repasse à "disponible"
l'application contient deux execeptions personnalisées qui gére lorqu'un vehicule est deja loué et si un client tente de louer un camion sans permis adequat
Enfin le code contient un menu interactif permattant a l'utilisateur d'ajouter un nouveau vehicule au parc ou d'ajouter un nouveau client.
