package finalProject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ObjectOrientedGUI extends Application {
	// Oven
	static Oven oven;
	static Button ovenB = new Button("Oven");
	static TextArea ovenStatus = new TextArea();

	// Mixer
	static Mixer mixer;
	Button mixerB = new Button("Mixer");
	static TextArea mixingStatus = new TextArea();

	// Appliance
	Button applianceOnB = new Button("Appliance Power On");
	Button applianceOffB = new Button("Appliance Power Off");
	static TextArea applianceStatus = new TextArea();
	static boolean applianceOn = false;

	//Command Pattern makes up remote control
	
	//Remote Control
	static RemoteControl remoteControl;

	
	//Strategy Pattern represented in abstract class BakedGoods and concrete classes Cake, Cupake, Cookie
	
	//Cake
	static BakedGoods cake = new Cake();
	Button cakeB = new Button("Cake");

	//Cupcake
	static BakedGoods cupcake = new Cupcake();
	Button cupcakeB = new Button("Cupcake");

	//Cookie
	static BakedGoods cookie = new Cookie();
	Button cookieB = new Button("Cookie");

	//Arrays with selections that are changed by buttons that updated selectedBG
	static int selectedBG = 0;
	static BakedGoods goods[] = { cake, cupcake, cookie };
	int speeds[] = { 4, 3, 5 };
	int temps[] = { 350, 375, 375 };

	// Decorator
	Button sprinkleB = new Button("Sprinkles");
	Button candleB = new Button("Candle");
	Button frostingB = new Button("Frosting");
	static TextArea decoratorStatus = new TextArea();

	// Results
	Button resultsB = new Button("Result");
	static TextArea resultsText = new TextArea();

	// BakeAll
	Button bakeAllB = new Button("Bake");

	@Override
	public void start(Stage primaryStage) {
		//Create appliances and initialize the bakeryFacade
		mixer = new Mixer("Mixer", 3);
		oven = new Oven("Baking Oven", 350);
		remoteControl = new RemoteControl();
		
		//Facade Pattern 
		BakeryFacade bf = new BakeryFacade(mixer, oven, remoteControl);
		bf.initialize();

		// Create text fields
		applianceStatus.setPrefSize(200, 200);
		mixingStatus.setPrefSize(200, 200);
		ovenStatus.setPrefSize(200, 200);
		decoratorStatus.setPrefSize(200, 200);
		resultsText.setPrefSize(200, 100);

		// Create Buttons
		bakeAllB.setMaxSize(300, 300);

		// Create Register/Handler-----------------------
		cakeB.setOnAction(e -> {
			cake = new Cake();
			selectedBG = 0;
		});

		cupcakeB.setOnAction(e -> {
			cupcake = new Cupcake();
			selectedBG = 1;
		});

		cookieB.setOnAction(e -> {
			cookie = new Cookie();
			selectedBG = 2;
		});

		applianceOnB.setOnAction(e -> {
			//Activates Party mode
			remoteControl.onButtonWasPressed(2);
			applianceOn = true;
		});

		applianceOffB.setOnAction(e -> {
			remoteControl.offButtonWasPressed(2);
			applianceOn = false;
		});

		mixerB.setOnAction(e -> {
			//If appliance is on and goods are not mixed, print and mix ingredients
			if (goods[selectedBG].isMixed()) {
				mixingStatus.appendText("Already Mixed!\n");
			} else if (applianceOn == false) {
				applianceStatus.appendText("Please turn on appliances\n");
			} else {
				mixingStatus.appendText("Making " + goods[selectedBG].getDescription());
				bf.mix(goods[selectedBG], speeds[selectedBG]);
			}
			
			goods[selectedBG].setMixed(true);
			
		});

		ovenB.setOnAction(e -> {
			//If appliance is on and goods are not baked, print and mix ingredients
			if (goods[selectedBG].isBaked()) {
				ovenStatus.appendText("Already Baked!\n");
			} else if (applianceOn == false) {
				applianceStatus.appendText("Please turn on appliances\n");
			} else {
				ovenStatus.appendText("Making " +goods[selectedBG].getDescription());
				bf.bake(goods[selectedBG], temps[selectedBG]);
			}
			decoratorStatus.appendText("Ready to decorate " + goods[selectedBG].getDescription());
		
			goods[selectedBG].setBaked(true);
		});

		sprinkleB.setOnAction(e -> {
			goods[selectedBG] = new Sprinkles(goods[selectedBG], 10, goods[selectedBG].getDescription());
			goods[selectedBG].toppings();
		});

		candleB.setOnAction(e -> {
			goods[selectedBG] = new Candle(goods[selectedBG], goods[selectedBG].getDescription());
			goods[selectedBG].toppings();
		});

		frostingB.setOnAction(e -> {
			goods[selectedBG] = new Frosting(goods[selectedBG], goods[selectedBG].getDescription());
			goods[selectedBG].toppings();
		});
		// Decorator

		bakeAllB.setOnAction(e -> {
			if (applianceOn == false) {
				applianceOnB.fire();				
			}
			mixerB.fire();
			ovenB.fire();
		});

		resultsB.setOnAction(e -> {
			resultsText.appendText("Finished " + goods[selectedBG].getDescription());
			decoratorStatus.appendText("\nFINAL TOPPINGS ---------\n");
			goods[selectedBG].toppings();
		});

		HBox resultsBox = new HBox();
		resultsBox.setAlignment(Pos.CENTER);
		resultsBox.getChildren().add(resultsB);
		resultsBox.getChildren().add(resultsText);

		HBox row1 = new HBox(10);
		row1.setAlignment(Pos.CENTER);
		row1.getChildren().add(cakeB);
		row1.getChildren().add(cupcakeB);
		row1.getChildren().add(cookieB);

		HBox toppings = new HBox();
		toppings.setAlignment(Pos.CENTER);
		toppings.getChildren().add(sprinkleB);
		toppings.getChildren().add(candleB);
		toppings.getChildren().add(frostingB);

		VBox vbox1 = new VBox();
		vbox1.getChildren().add(applianceOnB);
		vbox1.getChildren().add(applianceOffB);
		vbox1.getChildren().add(applianceStatus);

		VBox vbox2 = new VBox();
		vbox2.getChildren().add(mixerB);
		vbox2.getChildren().add(mixingStatus);

		VBox vbox3 = new VBox();
		vbox3.getChildren().add(ovenB);
		vbox3.getChildren().add(ovenStatus);

		VBox vbox4 = new VBox();
		vbox4.getChildren().add(toppings);
		vbox4.getChildren().add(decoratorStatus);

		HBox hbox = new HBox(20);
		hbox.getChildren().add(vbox1);
		hbox.getChildren().add(vbox2);
		hbox.getChildren().add(vbox3);
		hbox.getChildren().add(vbox4);

		VBox vboxFinal = new VBox(10);
		vboxFinal.setAlignment(Pos.CENTER);
		vboxFinal.getChildren().add(row1);
		vboxFinal.getChildren().add(bakeAllB);
		vboxFinal.getChildren().add(hbox);
		vboxFinal.getChildren().add(resultsBox);

		Scene scene = new Scene(vboxFinal);
		primaryStage.setTitle("Baked Goods");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}