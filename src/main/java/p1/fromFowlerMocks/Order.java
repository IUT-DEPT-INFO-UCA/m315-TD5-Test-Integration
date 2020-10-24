package p1.fromFowlerMocks;

public class Order {

	private String product;
	private int amount;
	private boolean isFilled;

	public Order(String product, int i) {
		this.product = product;
		this.amount = i;
		this.isFilled = false;
	}

	public void fill(Warehouse warehouse) {
		if (warehouse.hasInventory(product,amount)) {
			warehouse.remove(product,amount);
			isFilled = true;
		}
	}

	public boolean isFilled() {
		return isFilled;
	}
}