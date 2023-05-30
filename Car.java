public class Car {
	// Declare our car's attributes
	private String ID;
	private int mileage;
	private int MPG;
	private double cost;
	private double salesPrice;
	private boolean sold;
	private double priceSold;
	private double profit;

	// Constructors
	// Default constructor
	public Car() {
		ID = "";
		mileage = 0;
		MPG = 0;
		cost = 0;
		salesPrice = 0;
		sold = true;
		priceSold = 0;
		profit = 0;
	}

	// Constructor to add a new car to the inventory
	public void NewCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		this.ID = id;
		this.mileage = mileage;
		this.MPG = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
		this.sold = false;
		this.priceSold = 0;
		this.profit = 0;
	}

	// Accessors
	// Car ID
	public String getID() {
		return ID;
	}

	// Mileage on car
	public int getMileage() {
		return mileage;
	}

	// Miles Per Gallon
	public int getMPG() {
		return MPG;
	}

	// Cost to car lot
	public double getCost() {
		return cost;
	}

	// Goal sale price
	public double getSalesPrice() {
		return salesPrice;
	}

	// Whether car has been sold or not
	public boolean getSold() {
		return sold;
	}

	// Price car was sold for
	public double getPriceSold() {
		return priceSold;
	}

	// Profit car was sold at
	public double getProfit() {
		return profit;
	}

	// Get a string that contains all of the car attributes
	public String toString() {
		// Car: test1, Mileage: 10000, MPG 30, Sold: Yes, Cost: $12500.00, Selling
		// price: $17500.00, Sold For $18000.00, Profit: $5500.00
		return ("Car:" + '\t' + ID + ", " + "Mileage:" + '\t' + mileage + ", " + "MPG:" + '\t' + MPG + ", " + "Sold:"
				+ '\t' + (sold ? "Yes" : "No") + ", " + "Cost:" + '\t' + String.format("$%,.2f", cost) + ", "
				+ "Selling price:" + '\t' + String.format("$%,.2f", salesPrice) + ", " + "Sold For:" + '\t'
				+ String.format("$%,.2f", priceSold) + ", " + "Profit:" + '\t' + String.format("$%,.2f", profit));
	}

	// Compare MPG of two cars
	public int compareMPG(Car otherCar) {
		if (MPG == otherCar.MPG) {
			return 0;
		} else if (MPG > otherCar.MPG) {
			return 1;
		} else {
			return -1;
		}
	}

	// Compare mileage of two cars
	public int compareMiles(Car otherCar) {
		if (mileage == otherCar.mileage) {
			return 0;
		} else if (mileage > otherCar.mileage) {
			return 1;
		} else {
			return -1;
		}
	}

	// Compare price of two cars
	public int comparePrice(Car otherCar) {
		if (salesPrice == otherCar.salesPrice) {
			return 0;
		} else if (salesPrice > otherCar.salesPrice) {
			return 1;
		} else {
			return -1;
		}
	}

	// Mutators
	// Car ID
	public void changeID(String newID) {
		ID = newID;
	}

	// Mileage on car
	public void changeMileage(int newMileage) {
		mileage = newMileage;
	}

	// Miles Per Gallon
	public void changeMPG(int newMPG) {
		MPG = newMPG;
	}

	// Cost to car lot
	public void changeCost(double newCost) {
		cost = newCost;
	}

	// Goal sale price
	public void changeSalesPrice(double newSalesPrice) {
		salesPrice = newSalesPrice;
	}

	// Whether car has been sold or not
	public void changeSold(boolean newSold) {
		sold = newSold;
	}

	// Price car was sold for
	public void changePriceSold(double newPriceSold) {
		priceSold = newPriceSold;
	}

	// Profit car was sold at
	public void changeProfit(double newProfit) {
		profit = newProfit;
	}

	// Change attributes whenever the car is sold
	public void sellCar(double priceSold) {
		// The Car is marked sold
		sold = true;
		// The priceSold attribute is updated appropriately
		this.priceSold = priceSold;
		// The profit is calculated
		this.profit = priceSold - cost;
	}
}
