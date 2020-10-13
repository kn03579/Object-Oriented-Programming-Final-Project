package finalProject;

//Sprinkles class for the decorator pattern
public class Sprinkles extends Toppings {
	private BakedGoods bakedGood;
	private int amount;
	private String type;

	public Sprinkles(BakedGoods bakedGood, String type) {
		this.bakedGood = bakedGood;
		amount = 1;
		this.type = type;
	}
	
	public Sprinkles(BakedGoods bakedGood, int amount, String type) {
		this.bakedGood = bakedGood;
		this.amount = amount;
		this.type = type;
	}

	// Calls the already existing toppings then adds more toppings for the selected topping type
	public void toppings() {
		bakedGood.setSprinkles(sprinkles + amount);
		bakedGood.setFrosting(frosting);
		bakedGood.setCandle(candle);
		bakedGood.toppings();
	}

	@Override
	public String getDescription() {
		return type;
	}
}
