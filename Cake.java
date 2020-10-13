package finalProject;
//Subclass that inherits from the baked goods abstract class
public class Cake extends BakedGoods
{
	public Cake()
	{
		//Sets the ingredients and instructions of the object as a cake
		ingredientBehavior = new Cake_Ing();
		temperatureBehavior = new Cake_Temp();
		trayBehavior = new Cake_Tray();
	}
	
	@Override
	public String getDescription() {
		return "Cake\n";
	}
}


