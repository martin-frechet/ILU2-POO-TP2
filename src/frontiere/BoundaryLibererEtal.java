package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)){
			System.out.println("Mais vous n'êtes pas inscrits sur notre marché aujourd'hui !");
		}
		else {
			String[] donneesTempEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			String produit = donneesTempEtal[2];
			String quantiteInitial = donneesTempEtal[3];
			String quantiteVendue = donneesTempEtal[4];
			System.out.println("Vous avez vendu "+quantiteVendue+ " sur " +quantiteInitial+ " " +produit + ".");
			System.out.println("Au revoir "+nomVendeur+ ", passez une bonne journée !");
		}
	}

}