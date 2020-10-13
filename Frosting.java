package finalProject;

//Frosting class for the decorator pattern
public class Frosting extends Toppings {
	private BakedGoods bakedGood;
	private int amount = 1;
	private String type;

	public Frosting(BakedGoods bakedGood, String type) {
		this.bakedGood = bakedGood;
		this.type = type;
	}
	
	public Frosting(BakedGoods bakedGood, int amount, String type) {
		this.bakedGood = bakedGood;
		this.amount = amount;
		this.type = type;
	}

	// Calls the already existing toppings then adds more toppings for the selected topping type
	public void toppings() {
		bakedGood.setSprinkles(sprinkles);
		bakedGood.setFrosting(frosting  + amount);
		bakedGood.setCandle(candle);
		bakedGood.toppings();
	}

	@Override
	public String getDescription() {
		return type;
	}
}
