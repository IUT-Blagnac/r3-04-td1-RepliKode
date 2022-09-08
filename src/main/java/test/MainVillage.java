package test;
import lesschtroumpfs.Village;
import lesschtroumpfs.Schtroumpf;

public class MainVillage {

	public static void main (String[] argv) {
		Village SchtroumpfCity;
		Schtroumpf chefDuVillage;
		String[] nomsSchtroumpfs = {
		        "Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur � lunettes",
		        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf �tonn�", "Schtroumpf acrobate", "Schtroumpf paresseux"
		};
		
		SchtroumpfCity = new Village("SchtroumpfCity", 210, nomsSchtroumpfs);
		
		SchtroumpfCity.solstice_d_ete();
		
		System.out.println("----------------");
		chefDuVillage = SchtroumpfCity.chefDuVillage();
		chefDuVillage.sePresenter();
		System.out.println("----------------");
		
		SchtroumpfCity.envoyerAuTravail();
		
		SchtroumpfCity.schtroumpsfHeureux();
		
		SchtroumpfCity.envoyerCueillirSalsepareille();
		SchtroumpfCity.solstice_d_ete();
		SchtroumpfCity.dinerTousEnsemble();
		SchtroumpfCity.solstice_d_ete();
		
		
	}

}
