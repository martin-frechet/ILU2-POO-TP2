package frontiere;

import controleur.ControlEmmenager;
import villagegaulois.Village;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur);
		int force = Clavier.entrerEntier("Quelle est votre force ? : ");
		int potMin = Clavier.entrerEntier("Quelle est effet de potion minimum ? : ");
		int potMax = Clavier.entrerEntier("Quelle est effet de potion maximum ? : ");
		controlEmmenager.ajouterDruide(nomVisiteur, force, potMin, potMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur);
		int choixUtilisateur2 = Clavier.entrerEntier("Quelle est votre force ? : ");
		controlEmmenager.ajouterGaulois(nomVisiteur, choixUtilisateur2);
	}
}
