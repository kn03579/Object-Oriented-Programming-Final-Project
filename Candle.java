package finalProject;

//Candle class for the decorator pattern
public class Candle extends Toppings{
	private BakedGoods bakedGood;
	private int amount;
	private String type;

	public Candle(BakedGoods bakedGood, String type) {
		this.bakedGood = bakedGood;
		this.amount = 1;
		this.type = type;
	}
	
	public Candle(BakedGoods bakedGood, int amount, String type) {
		this.bakedGood = bakedGood;
		this.amount = amount;
		this.type = type;
	}

	// Calls the already existing toppings then adds more toppings for the selected topping type
	public void toppings() {
		bakedGood.setSprinkles(sprinkles);
		bakedGood.setFrosting(frosting);
		bakedGood.setCandle(candle + amount);
		bakedGood.toppings();
	}

	@Override
	public String getDescription() {
		return type;
	}
}
