package finalProject;

//Subclass that inherits from the baked goods abstract class
public class Cookie extends BakedGoods {
	public Cookie() {
		// Sets the ingredients and instructions of the object as cookies
		ingredientBehavior = new Cookies_Ing();
		temperatureBehavior = new Cookies_Temp();
		trayBehavior = new Cookies_Tray();
	}

	@Override
	public String getDescription() {
		return "Cookies\n";
	}


}
