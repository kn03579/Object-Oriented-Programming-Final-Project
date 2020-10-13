package finalProject;

//Subclass that inherits from the baked goods abstract class
	public class Cupcake extends BakedGoods
	{
		public Cupcake()
		{
			//Sets the ingredients and instructions of the object as cupcakes
			ingredientBehavior = new Cupcakes_Ing();
			temperatureBehavior = new Cupcakes_Temp();
			trayBehavior = new Cupcakes_Tray();
		}
		
		@Override
		public String getDescription() {
			return "Cupcakes\n";
		}
	}
