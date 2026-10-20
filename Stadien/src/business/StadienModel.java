package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StadienModel {
	
	
	
	private Stadion stadion;

	public Stadion getStadion() {
		return stadion;
	}

	public void setStadion(Stadion stadion) {
		this.stadion = stadion;
	}
	
	
	
	
	public void schreibeStadienInCsvDatei() throws IOException
    // Werfen einer IOException
{
    BufferedWriter aus = new BufferedWriter(
        new FileWriter("Stadien.csv", true));
    aus.write(this.getStadion().gibStadionZurueck(';'));
    aus.close();
}

}
