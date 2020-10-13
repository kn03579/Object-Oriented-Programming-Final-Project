package finalProject;

//Abstract class that defines a baked good.
public abstract class BakedGoods {
	// Interface for ingredients
	public interface IngredientBehavior {
		public void ingredientbehavior();
	}

	// Behavior class implementing the ingredient list for cookies
	public class Cookies_Ing implements IngredientBehavior {
		public void ingredientbehavior() {
			ObjectOrientedGUI.mixingStatus.appendText("	Ingredients:\n" + "		2 1/4 cups Gold Medal all-purpose flour\n"
					+ "		1 teaspoon baking soda\n" + "		1/2nteaspoon salt\n"
					+ "		1 cup butter, softened\n" + "		3/4 cup granulated sugar\n"
					+ "		3/4 cup packed brown sugar\n" + "		1 egg\n" + "		1 teaspoon vanilla\n");
		}
	}

	// Behavior class implementing the ingredient list for pies
	public class Cupcakes_Ing implements IngredientBehavior {
		public void ingredientbehavior() {
			ObjectOrientedGUI.mixingStatus.appendText("	Ingredients:\n" + "		1 1/2 cups all-purpose flour\n"
					+ "		1 1/2 teaspoons baking powder \n" + "		1/4 teaspoon fine salt \n"
					+ "		2 large eggs, at room temperature \n" + "		2/3 cup sugar \n"
					+ "		1 1/2 sticks (12 tablespoons) unsalted butter, melted \n"
					+ "		2 teaspoons pure vanilla extract \n" + "		1/2 cup milk\n");
		}
	}

	// Behavior class implementing the ingredient list for poundcake
	public class Cake_Ing implements IngredientBehavior {
		public void ingredientbehavior() {
			ObjectOrientedGUI.mixingStatus.appendText(
					"	Ingredients:\n" + "		1 cup (2 sticks) unsalted butter, room temperature, plus more for pan\n"
							+ "		2 cups all-purpose flour (spooned and leveled), plus more for pan\n"
							+ "		1 cup sugar\n" + "		4 large eggs\n" + "		2 teaspoons pure vanilla extract\n"
							+ "		1/2 teaspoon salt\n");
		}
	}

	// Interface for temperature instructions
	public interface TemperatureBehavior {
		public void temperaturebehavior();
	}

	// Behavior class implementing the temperature for cake
	public class Cake_Temp implements TemperatureBehavior {
		public void temperaturebehavior() {
			ObjectOrientedGUI.ovenStatus.appendText("	Temperature:\n" + "		Preheat oven to 350 degrees.\n"
					+ "		Bake until a toothpick inserted in center of cake comes out clean, about 1 hour (tent with aluminum foil if browning too quickly).\n"
					+ "		Let cool in pan 15 minutes. Invert onto a wire rack, and turn upright to cool completely.\n");
		}
	}

	// Behavior class implementing the temperature for cookies
	public class Cookies_Temp implements TemperatureBehavior {
		public void temperaturebehavior() {
			ObjectOrientedGUI.ovenStatus.appendText("	Temperature:\n" + "		Heat oven to 375°F. \n"
					+ "		Bake 8 to 10 minutes or until light brown (centers will be soft).\n"
					+ "		Cool completely, about 30 minutes. Store covered in airtight container.\n");
		}
	}

	// Behavior class implementing the temperature for cupcakes
	public class Cupcakes_Temp implements TemperatureBehavior {
		public void temperaturebehavior() {
			ObjectOrientedGUI.ovenStatus.appendText("	Temperature:\n" + "		Preheat the oven to 375 degrees F.\n"
					+ "		Bake for about 50 minutes.\n " + "		Remove from the oven and place on a rack to cool.\n");
		}
	}

	public interface TrayBehavior {
		public void traybehavior();
	}

	// Behavior class implementing the tray layout for cake
	public class Cake_Tray implements TrayBehavior {
		public void traybehavior() {
			ObjectOrientedGUI.ovenStatus.appendText(
					"	Tray Layout:\n" + "		Line the sheet pan with parchment paper or grease and flour it.\n"
							+ "		Pour the batter in until the pan is half filled.\n"
							+ "		Place any remaining batter in separate sheet pans.\n");
		}
	}

	// Behavior class implementing the tray layout for cookies
	public class Cookies_Tray implements TrayBehavior {
		public void traybehavior() {
			ObjectOrientedGUI.ovenStatus.appendText("	Tray Layout:\n" + "		Line baking sheets and pans with aluminum foil. \n"
					+ "		Then, grease the top of the foil to prevent sticking.\n"
					+ "		Place dough balls on the try, about 1/2 inch apart.\n");
		}
	}

	// Behavior class implementing the tray layout for cupcakes
	public class Cupcakes_Tray implements TrayBehavior {
		public void traybehavior() {
			ObjectOrientedGUI.ovenStatus.appendText("	Tary Layout:\n" + "		Line baking sheets and pans with aluminum foil. \n"
					+ "		Then, grease the top of the foil to prevent sticking.\n"
					+ "		Fill cupcake liners about 3/4 of the way with batter.\n"
					+ "		Place each liner on the try, about 1/2 inch apart.\n");
		}
	}

	// BakedGoods class abstract methods
	IngredientBehavior ingredientBehavior;
	TemperatureBehavior temperatureBehavior;
	TrayBehavior trayBehavior;
	int frosting;
	int sprinkles;
	int candle;
	boolean mixed = false;
	boolean baked = false;

	public abstract String getDescription();

	public void getIngredients() {
		ingredientBehavior.ingredientbehavior();
	}

	public void setIngredients(IngredientBehavior temp) {
		ingredientBehavior = temp;
	}

	public void getTemperature() {
		temperatureBehavior.temperaturebehavior();
	}

	public void setInstructions(TemperatureBehavior temp) {
		temperatureBehavior = temp;
	}

	public void getTray() {
		trayBehavior.traybehavior();
	}

	public void setTray(TrayBehavior temp) {
		trayBehavior = temp;
	}
	
	public int getFrosting() {
		return frosting;
	}

	public int getSprinkles() {
		return sprinkles;
	}

	public int getCandle() {
		return candle;
	}

	public void setFrosting(int frosting) {
		this.frosting = frosting;
	}

	public void setSprinkles(int sprinkles) {
		this.sprinkles = sprinkles;
	}

	public void setCandle(int candle) {
		this.candle = candle;
	}

	public void toppings() {
		ObjectOrientedGUI.decoratorStatus.appendText("Sprinkles: " + sprinkles +"\n");
		ObjectOrientedGUI.decoratorStatus.appendText("Candles: " + candle +"\n");
		ObjectOrientedGUI.decoratorStatus.appendText("Frosting: " + frosting +"\n\n");
	}

	public boolean isMixed() {
		return mixed;
	}

	public void setMixed(boolean mixed) {
		this.mixed = mixed;
	}

	public boolean isBaked() {
		return baked;
	}

	public void setBaked(boolean baked) {
		this.baked = baked;
	}
	
	
}
