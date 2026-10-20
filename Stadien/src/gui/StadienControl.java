package gui;

import java.io.IOException;

import business.StadienModel;
import business.Stadion;
import javafx.stage.Stage;

public class StadienControl {
	
	
	
	private StadienModel stadienModel;
	private StadienView stadienView;
	
	public StadienControl(Stage primaryStage) {
		
		this.stadienModel = new StadienModel();
		this.stadienView = new StadienView(this, primaryStage, stadienModel);
		
	}
	
	

	
	public void nehmeStadionAuf() {
		try {
			
			this.stadienModel.setStadion(new Stadion(stadienView.getTxtName().getText(),
					stadienView.getTxtOrt().getText(),
					Integer.parseInt(stadienView.getTxtAnzahlPlaetze().getText()),
					Integer.parseInt(stadienView.getTxtBaujahr().getText()),
					stadienView.getTxtNutzungen().getText().split(";")));
			stadienView.zeigeInformationsfensterAn("Stadion aufgenommen");
		}
		catch(Exception exc){
       		stadienView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
		
	}
	
	void schreibeStadienInDatei(String typ){
	    try{
	        if("csv".equals(typ)){
	            // Aufruf des Models zum Schreiben des
	            // Stadions in die Datei des vorgegebenen
	            // Typs und Ausgabe der Meldung
	        	
	        	stadienModel.schreibeStadienInCsvDatei();
	        	stadienView.zeigeInformationsfensterAn("Stadion erfolgreich geschrieben");
	        }
	        else{
	            stadienView.zeigeInformationsfensterAn(
	                "Noch nicht implementiert!");
	        }
	    }
	    catch(IOException exc){
	        stadienView.zeigeFehlermeldungsfensterAn(
	            "IOException beim Speichern!");
	    }
	    catch(Exception exc){
	        stadienView.zeigeFehlermeldungsfensterAn(
	            "Unbekannter Fehler beim Speichern!");
	    }
	}

}
