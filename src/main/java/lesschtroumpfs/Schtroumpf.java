package lesschtroumpfs;
import lesschtroumpfs.Village;

public class Schtroumpf {
	
	private String nom;
	private int age;
	private boolean content;
	private Village village;

	/**
	 * Constructeur Schtroumpf ermite
	 * @param pfNom nom du Schtroumpf
	 * @param pfAge age du Schtroumpf
	 * @param pfetat état du Schtroumpf (content ou pas)
	 */
	public Schtroumpf(String pfNom, int pfAge) {
		this.nom = pfNom;
		this.age = pfAge;
		this.content = true;
		this.village = null;
	}
	
	/**
	 * Constructeur Schtroumpf village
	 * @param pfNom nom du Schtroumpf
	 * @param pfAge age du Schtroumpf
	 * @param pfetat état du Schtroumpf (content ou pas)
	 * @param pfvillage village de naissance du Schtroumpf
	 */
	public Schtroumpf(String pfNom, int pfAge, Village pfvillage) {
		this.nom = pfNom;
		this.age = pfAge;
		this.content = true;
		this.village = pfvillage;
	}
	
	/**
	 * Récuperer l'age du Schtroumpf
	 * @return age l'age du Schtroumpf
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * Récuperer le nom du Schtroumpf
	 * @return nom le nom du Schtroumpf
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Récuperer le l'humeur du Schtroumpf
	 * @return content humeur du Schtroumpf
	 */
	public boolean getContent() {
		return this.content;
	}
	
	/**
	 * Récuperer le viallge dans lequel se trouve le Schtroumpf
	 * @return Village village dans lequel se trouve le Schtroumpf
	 */
	public Village getVillage() {
		return this.village;
	}
	
	/**
	 * Permets de changer/attribuer le village dans lequel se trouve le Schtroumpf.
	 * @param pfVillage nouveau village d'habitation du Schtroumpf.
	 */
	public void setVillage(Village pfVillage) {
		this.village = pfVillage;
		pfVillage.ajouterSchtroumpfVillage(this);
	}
	
	/** Permets de transformer les attributs du schtroumpf sous forme de String
	 * @return String un Schtroumpf
	 */
	public String toString() {
		String res;
		
		res = "";
		if (this.content) res += "Je suis " + this.nom + ", j'ai " + this.age + " ans et je suis content.";	
		else res += "Je suis " + this.nom + ", j'ai " + this.age + " ans et je suis PAS content.";	
		if (this.village == null) res += " Je suis ermite";
		else res += " Je viens du village " + this.village.getNom();
		
		return res;
	}
	
	/**
	 * Affiche dans la console une présentation du Schtroumpf
	 */
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	/**
	 * Le chant du Schtroumpf
	 * @return String le chant du Schtroumpf si il est content ou pas
	 */
	public String leChant() {
		if (this.content) return "la, la, la Schtroumpf la, la";
		else return "gloups";
	}
	
	/**
	 * Affiche dans la console le chant du Schtroumpf
	 */
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	/**
	 * Ajoute 1 ans au Schtroumpf
	 */
	public void anniversaire() {
		this.age++;
	}
	
	/**
	 * Le Schtroumpf mange de la salsepareille. Lorsqu'un Schtroumpf mange, il devient heureux
	 * @param pfQte quantitée de salsepareille à manger
	 */
	public void manger(int pfQte) {
		if (pfQte > 0) this.content = true; 
	}
	
	/**
	 * Fait travaller le Schtroumpf ce qui a pour effet direct de rendre un Schtroumpf triste
	 */
	public void allerTravailler() {
		this.content = false;
	}
	
	/**
	 * Le Schtroumpf part récolter de la Salsepareille
	 */
	public void recolterSalsepareille() {
		if (this.village != null) this.village.setNbSalsepareille(this.village.getStockSalsepareille() + 5);
		this.content = false;
		if (this.village == null) this.manger(5);
	}
	
	/**
	 * Le Schtroumpf dîne au village
	 */
	public void dinerAuVillage() {
		if (this.village != null) {
			if (this.village.getStockSalsepareille() >= 3) {
				this.village.setNbSalsepareille(this.village.getStockSalsepareille() - 3);
				this.content = true;
			} else {
				this.content = false;
			}
		} else {
			this.content = false;
		}
	}
	
}
