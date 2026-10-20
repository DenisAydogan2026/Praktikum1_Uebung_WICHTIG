package business;

public class Stadion {

    private String name;
    private String ort;
    private int anzahlPlaetze;
    private int baujahr;
    private String[] nutzungen;

    public Stadion(String name, String ort, int anzahlPlaetze,
       	int baujahr, String[] nutzungen){
    	this.name = name;
      	this.ort = ort;
       	this.anzahlPlaetze = anzahlPlaetze;
       	this.baujahr = baujahr;
       	this.nutzungen = nutzungen;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

	public void setAnzahlPlaetze(int anzahlPlaetze) {
		this.anzahlPlaetze = anzahlPlaetze;
	}

	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}

	public String[] getNutzungen() {
		return nutzungen;
	}

	public void setNutzungen(String[] nutzungen) {
		this.nutzungen = nutzungen;
	}

 	public String getNutzungenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getNutzungen().length - 1; i++) {
			ergebnis = ergebnis + this.getNutzungen()[i] + trenner;
		}
		return ergebnis	+ this.getNutzungen()[i];
	}

	public String gibStadionZurueck(char trenner){
  		return this.getName() + trenner
  			+ this.getOrt() + trenner
  			+ this.getAnzahlPlaetze() + trenner
  		    + this.getBaujahr() + trenner + "\n"
  		    + this.getNutzungenAlsString(trenner) + "\n";
  	}
}
