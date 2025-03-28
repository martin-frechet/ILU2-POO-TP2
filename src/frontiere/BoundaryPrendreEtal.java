package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un étal.");
			if (controlPrendreEtal.resteEtals()){
				installerVendeur(nomVendeur);
			}
			else {
				System.out.println("Désolé "+nomVendeur+" je n'ai plus d'étals libre pour vous");
			}
		}
		else {
			System.out.println("Désolé " +nomVendeur+ " mais il fait être un habitant de notre village pour commercer ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit) + 1;
		System.out.println("Le vendeur "+nomVendeur+ " s'est installé à l'étal n°"+numeroEtal);
	}
}
