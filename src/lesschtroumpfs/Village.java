package lesschtroumpfs;
import lesschtroumpfs.Schtroumpf;
import java.util.ArrayList;
import java.util.Random;

public class Village {

	private String nom;
	private ArrayList<Schtroumpf> Schtroumpfs = new ArrayList();
	private int nbSchtroumpfs;
	private int nbSalsepareille;
	
	public Village (String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.nbSalsepareille = pfStockSalsepareille;
		for (int i = 0; i < pfNomsDesSchtroumpfs.length; i++) {
			this.Schtroumpfs.add(new Schtroumpf(pfNomsDesSchtroumpfs[i], new Random().nextInt(150), this));
		}
		this.nbSchtroumpfs = Schtroumpfs.size();
	}
	
	/** Permets d'obtenir le nom du village
	 * @return nom le nom du village
	 */
	public String getNom() {
		return this.nom;
	}

	/** Permets d'obtenir le nombre de Schtroumpf dans le village
	 * @return nbSchtroumpfs le nombre de Schtroumpf dans le village
	 */
	public int getNbSchtroumpf() {
		return this.nbSchtroumpfs;
	}

	/** Permets d'obtenir le nombre de salsepareille du village
	 * @return nbSalsepareille le nombre de salsepareille
	 */
	public int getStockSalsepareille() {
		return this.nbSalsepareille;
	}
	
	/** Permets de modifier le nombre de salsepareille du village
	 */
	public void setNbSalsepareille(int pfNbSalsepareille) {
		this.nbSalsepareille = pfNbSalsepareille;
	}
	
	/**
	 * Permets de f�ter le solstice d'�t�
	 */
	public void solstice_d_ete() {
		int nbSchtroumpfsContent;
		int size;
		
		nbSchtroumpfsContent = 0;
		size = this.Schtroumpfs.size();
		
		for (int i = 0; i < size; i++) {
			this.Schtroumpfs.get(i).sePresenter();
			this.Schtroumpfs.get(i).chanter();
			if (this.Schtroumpfs.get(i).getContent()) nbSchtroumpfsContent++;
		}
		System.out.println("Villege : " + this.getNom());
		System.out.println("Nombre de Schtroumpfs pr�sents : " + this.getNbSchtroumpf());
		System.out.println("Nombre de Schtroumpfs contents : " + nbSchtroumpfsContent);
	}
	
	/** Permets d'obtenir le chef du village ( Schtroumpf le plus �g� )
	 * @return Schtroumpf Schtroumpf le plus �g�
	 */
	public Schtroumpf chefDuVillage() {
		int size;
		Schtroumpf chef;
		
		size = this.Schtroumpfs.size();
		chef = this.Schtroumpfs.get(0);
		for (int i = 1; i < size; i++) {
			if (this.Schtroumpfs.get(i).getAge() > chef.getAge()) {
				chef = this.Schtroumpfs.get(i);
			}
		}
		return chef;
	}
	
	/**
	 * Envoie au travail un Schtroumpf sur 2 habitant au Village
	 */
	public void envoyerAuTravail () {
		int size;
		ArrayList<Schtroumpf> schtroumpfContent;
		
		schtroumpfContent = new ArrayList();
		size = this.Schtroumpfs.size();
		// récupérer le nombre de Schtroumpf content
		for (int i = 0; i < size; i++) if (this.Schtroumpfs.get(i).getContent()) schtroumpfContent.add(this.Schtroumpfs.get(i));
		
		size = (int) schtroumpfContent.size() / 2;
		for (int i = 0; i < size; i++) {
			schtroumpfContent.get(i).allerTravailler();
		}
	}
	
	/**
	 * Fait chanter les seuls Schtroumpfs heureux du Village
	 */
	public void schtroumpsfHeureux () {
		int size;
		
		size = this.Schtroumpfs.size();
		for (int i = 0; i < size; i++) {
			if (this.Schtroumpfs.get(i).getContent() == true) {
				this.Schtroumpfs.get(i).sePresenter(); 
				this.Schtroumpfs.get(i).chanter();
			}
		}
	}
	
	
	/**
	 * Fait manger tout les Schtroumpfs du villange enssemble
	 */
	public void dinerTousEnsemble() {
		int size;
		
		size = this.Schtroumpfs.size();
		for (int i = 0; i < size; i++) {
			this.Schtroumpfs.get(i).dinerAuVillage();
		}
	
	}
	
	/**
	 * Envoie au récolter de la Salsepareille un Schtroumpf sur 2 habitant au Village
	 */
	public void envoyerCueillirSalsepareille() {
		int size;
		ArrayList<Schtroumpf> schtroumpfContent;
		
		schtroumpfContent = new ArrayList();
		size = this.Schtroumpfs.size();
		// récupérer le nombre de Schtroumpf content
		for (int i = 0; i < size; i++) if (this.Schtroumpfs.get(i).getContent()) schtroumpfContent.add(this.Schtroumpfs.get(i));
		
		size = (int) schtroumpfContent.size() / 2;
		for (int i = 0; i < size; i++) {
			schtroumpfContent.get(i).recolterSalsepareille();
		}
	}
	
	/**
	 * Ajoute un Schtroumpf au village
	 * @param pfSchtroumpf pfSchtroumpf à ajouter au village
	 */
	public void ajouterSchtroumpfVillage(Schtroumpf pfSchtroumpf) {
		Schtroumpfs.add(pfSchtroumpf);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
