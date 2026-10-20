package main;

import gui.StadienAnwendungssystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new StadienAnwendungssystem(primaryStage);
	}

	public static void main(String[] args){
		launch(args);
	}
}
