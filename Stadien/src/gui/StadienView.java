package gui;

import business.StadienModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class StadienView {
	
	
	
	  //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblOrt   		 			= new Label("Ort:");
    private Label lblAnzahlPlaetze  	 	= new Label("Anzahl Plaetze:");
    private Label lblBaujahr   	 			= new Label("Baujahr:");
    private Label lblNutzungen  			= new Label("Nutzungen:");
    private TextField txtName 	 			= new TextField();
    private TextField txtOrt				= new TextField();
    private TextField txtAnzahlPlaetze		= new TextField();
    private TextField txtBaujahr			= new TextField();
    private TextField txtNutzungen	 		= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");
    private MenuItem mnItmTxtExport 		= new MenuItem("txt-Export");
    //-------Ende Attribute der grafischen Oberflaeche-------
    private StadienControl stadienControl;
	private StadienModel stadienModel;
	
	public StadienView(StadienControl stadienControl, Stage primaryStage, StadienModel stadienModel) {
		
		this.stadienControl = stadienControl;
		this.stadienModel = stadienModel;
		Scene scene = new Scene(this.pane, 700, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Stadien");
    		primaryStage.show();
    		this.initKomponenten();
		this.initListener();
		
	}
	
	  private void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24);
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;");
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;");
	       	lblName.setLayoutX(20);
	    	lblName.setLayoutY(90);
	    	lblOrt.setLayoutX(20);
	    	lblOrt.setLayoutY(130);
	    	lblAnzahlPlaetze.setLayoutX(20);
	    	lblAnzahlPlaetze.setLayoutY(170);
	    	lblBaujahr.setLayoutX(20);
	    	lblBaujahr.setLayoutY(210);
	    	lblNutzungen.setLayoutX(20);
	    	lblNutzungen.setLayoutY(250);
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige,
	       		lblName, lblOrt, lblAnzahlPlaetze,
	       		lblBaujahr, lblNutzungen);

	    	// Textfelder
	     	txtName.setLayoutX(170);
	    	txtName.setLayoutY(90);
	    	txtName.setPrefWidth(200);
	    	txtOrt.setLayoutX(170);
	    	txtOrt.setLayoutY(130);
	    	txtOrt.setPrefWidth(200);
	    	txtAnzahlPlaetze.setLayoutX(170);
	    	txtAnzahlPlaetze.setLayoutY(170);
	    	txtAnzahlPlaetze.setPrefWidth(200);
	      	txtBaujahr.setLayoutX(170);
	    	txtBaujahr.setLayoutY(210);
	    	txtBaujahr.setPrefWidth(200);
	    	txtNutzungen.setLayoutX(170);
	    	txtNutzungen.setLayoutY(250);
	    	txtNutzungen.setPrefWidth(200);
	      	pane.getChildren().addAll(
	     		txtName, txtOrt, txtAnzahlPlaetze,
	     		txtBaujahr, txtNutzungen);

	        // Textbereich
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige);

	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige);

	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	  	    this.mnDatei.getItems().add(mnItmTxtExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }

	   private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	        	   stadienControl.nehmeStadionAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeStadienAn();
		        }
	   	    });
		    
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
		        public void handle(ActionEvent e) {
		           schreibeStadienInDatei("csv");
		            
		        }
		    });
		    mnItmTxtExport.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
		        public void handle(ActionEvent e) {
		          schreibeStadienInDatei("txt");
		        }
		    });
	    }
	   private void zeigeStadienAn(){
	    	if(this.stadienModel.getStadion() != null){
	    		txtAnzeige.setText(
	    			this.stadienModel.getStadion().gibStadionZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde kein Stadion aufgenommen!");
	    	}
	    }
	   
	   private void schreibeStadienInDatei(String typ){
		    // Aufruf des Controls zum Schreiben des Stadions in die
		    // Datei des vorgegebenen Typs.
		   
		   stadienControl.schreibeStadienInDatei(typ);
		  
		}

	    public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }

	   public void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn();
	    }

		public TextField getTxtName() {
			return txtName;
		}

		public void setTxtName(TextField txtName) {
			this.txtName = txtName;
		}

		public TextField getTxtOrt() {
			return txtOrt;
		}

		public void setTxtOrt(TextField txtOrt) {
			this.txtOrt = txtOrt;
		}

		public TextField getTxtAnzahlPlaetze() {
			return txtAnzahlPlaetze;
		}

		public void setTxtAnzahlPlaetze(TextField txtAnzahlPlaetze) {
			this.txtAnzahlPlaetze = txtAnzahlPlaetze;
		}

		public TextField getTxtBaujahr() {
			return txtBaujahr;
		}

		public void setTxtBaujahr(TextField txtBaujahr) {
			this.txtBaujahr = txtBaujahr;
		}

		public TextField getTxtNutzungen() {
			return txtNutzungen;
		}

		public void setTxtNutzungen(TextField txtNutzungen) {
			this.txtNutzungen = txtNutzungen;
		}

		public TextArea getTxtAnzeige() {
			return txtAnzeige;
		}

		public void setTxtAnzeige(TextArea txtAnzeige) {
			this.txtAnzeige = txtAnzeige;
		}

	    
	    
	    
	    
	    
	}
	
	


