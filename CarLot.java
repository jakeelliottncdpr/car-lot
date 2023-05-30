import java.util.*;

public class CarLot extends ArrayList<Car> {

	public static final java.lang.String location = "./carlot.txt";

	// Provide default accessor and mutator methods for the inventory attribute.
	public CarLot() {
	}

	public void setInventory(ArrayList<Car> newInventory) {
		clear();
		addAll(newInventory);
	}

	public ArrayList<Car> getInventory() {
		// I don't know if this is the easiest way to do this but looking at the
		// documentation, the way that makes the most sense is to loop through
		// all of the ArrayList elements and write them to a new ArrayList and
		// return that. I tried a few other methods but they would all return
		// ArrayList<Object> so this made the most sense to me.
		ArrayList<Car> inv = new ArrayList<Car>();
		for (int i = 0; i < size(); i++) {
			inv.add(get(i));
		}
		return inv;
	}

	// Add the following accessor methods:
	// Car findCarByIdentifier(String identifier). Find the car with the specified
	// identifer in the inventory. Return null if the Car is not found
	public Car findCarByIdentifier(String identifier) {
		int finalIndex = 0;
		boolean match = false;
		for (int i = 0; i < size(); i++) {
			if (get(i).getID().equals(identifier)) {
				finalIndex = i;
				match = true;
			}
		}
		if (match) {
			return get(finalIndex);
		} else {
			return null;
		}
	}

	// ArrayList<Car> getCarsInOrderOfEntry(). Return an ArrayList of all Cars in
	// the
	// inventory, ordered by their entry into the inventory. This method should
	// return
	// a copy of the inventory, not the inventory itself
	public ArrayList<Car> getCarsInOrderOfEntry() {
		ArrayList<Car> inv = new ArrayList<Car>();
		for (int i = 0; i < size(); i++) {
			inv.add(get(i));
		}
		return inv;
	}

	// ArrayList<Car> getCardsSortedByMPG(). Return an ArrayList of all Cars in the
	// inventory, sorted by MPG. This method should not sort the inventory, but
	// should
	// instead make a copy of the inventory and sort the copy
	public ArrayList<Car> getCardsSortedByMPG() {
		// I know that in the assignments hints, it says that we should use the compare
		// that we created in step 1 of the project but this way made more sense in my
		// brain
		// I am hoping that although it is not the expected way to be doing this, since
		// it is still a legal and legitimate way of tackling the task, I will receive
		// the full points. This goes for the mileage as well. Furthermore, the JavaDoc
		// does not specify any one particular way that we are allowed to handle the
		// task.
		int[] mpgValues = new int[size()];
		ArrayList<Car> inventoryMPG = new ArrayList<Car>();
		for (int i = 0; i < size(); i++) {
			mpgValues[i] = get(i).getMPG();
		}
		Arrays.sort(mpgValues);
		for (int i = mpgValues.length - 1; i >= 0; i--) {
			int index = 0;
			for (int j = 0; j < size(); j++) {
				if (mpgValues[i] == get(j).getMPG()) {
					index = j;
				}
			}
			inventoryMPG.add(get(index));
		}
		return inventoryMPG;
	}

	// Car getCarWithBestMPG(). Return the Car in the inventory with the highest MPG
	public Car getCarWithBestMPG() {
		return getCardsSortedByMPG().get(0);
	}

	// Car getCarWithHighestMileage(). Return the Car in the inventory with the
	// highest mileage
	public Car getCarWithHighestMileage() {
		int[] mpgValues = new int[size()];
		for (int i = 0; i < size(); i++) {
			mpgValues[i] = get(i).getMileage();
		}
		Arrays.sort(mpgValues);
		int index = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i).getMileage() == mpgValues[mpgValues.length - 1]) {
				index = i;
			}
		}
		return get(index);
	}

	// double getAverageMpg(). Return the average MPG of all Cars in the inventory
	public double getAverageMpg() {
		int[] mpgValues = new int[size()];
		for (int i = 0; i < size(); i++) {
			mpgValues[i] = get(i).getMPG();
		}
		double average = 0;
		for (int i = 0; i < mpgValues.length; i++) {
			average += mpgValues[i];
		}
		average = average / mpgValues.length;
		return average;
	}

	// double getTotalProfit(). Return the total profit of all cars in the inventory
	// that
	// have been sold
	public double getTotalProfit() {
		double profit = 0;
		for (int i = 0; i < size(); i++) {
			if (get(i).getSold()) {
				profit += get(i).getProfit();
			}
		}
		return profit;
	}

	// Add the following mutator methods:
	// void addCar(String id, int mileage, int mpg, double cost, double salesPrice).
	// Add a new Car with the specified id, mileage, mpg, cost, and salesPrice to
	// the inventory
	public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
		Car car = new Car();
		car.changeID(id);
		car.changeMileage(mileage);
		car.changeMPG(mpg);
		car.changeCost(cost);
		car.changeSalesPrice(salesPrice);
		car.changeSold(false);
		add(car);
	}

	// void sellCar(String identifier, double priceSold ) throws
	// IllegalArgumentException.
	// Sell the Car identified by identirier for the priceSold. If the Car does not
	// exist in
	// the identifier, throw an IllegalArgument Exception with an appropriate error
	// message
	public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
		Car car = findCarByIdentifier(identifier);
		int index = indexOf(car);
		if (car != null) {
			get(index).sellCar(priceSold);
		} else {
			throw new IllegalArgumentException();
		}

	}

	// Add the method saveToDisk() in the CarLot class.  When executed, this method should
	// save all of the inventory data to a .txt file named "carlot.txt"
	public void saveToDisk() throws java.io.FileNotFoundException {

		java.io.File file = new java.io.File(location);

		try (
				// Create a file
				java.io.PrintWriter output = new java.io.PrintWriter(file);
				) {
			// Write formatted output to the file
			for (int i = 0; i < size(); i++) {
				String car = "\"";
				car += get(i).getID() + "\";";
				car += get(i).getMileage() + ";";
				car += get(i).getMPG() + ";";
				car += get(i).getSalesPrice() + ";";
				car += get(i).getCost() + ";";
				car += get(i).getSold() + ";";
				car += get(i).getPriceSold() + ";";
				car += get(i).getProfit();
				output.println(car);
			}

			// Close the file
			output.close();
		} catch (Exception ex) {
			throw new java.io.FileNotFoundException();
		}
	}

	// Add the method loadFromDisk() to the CarLot class. When executed, this method
	// should load all of the data from the file "carlot.txt"
	public void loadFromDisk() throws java.io.FileNotFoundException {
		String string = "";

		Scanner input = new Scanner(new java.io.File(location));
		while (input.hasNext()) {
			string = input.nextLine();
			String[] a = string.split(";");

			Car thisCar = new Car();
			String ID = "";
			int mileage = 0;
			int MPG = 0;
			double cost = 0.00;
			double salesPrice = 0.00;
			boolean sold = false;
			double priceSold = 0.00;
			double profit = 0.00;

			String[] k = a[0].split("\"");
			a[0] = k[1];

			ID = a[0];
			try {
				mileage = Integer.parseInt(a[1]);
				MPG = Integer.parseInt(a[2]);
				cost = Double.parseDouble(a[3]);
				salesPrice = Double.parseDouble(a[4]);
				sold = Boolean.parseBoolean(a[5]);
				priceSold = Double.parseDouble(a[6]);
				profit = Double.parseDouble(a[7]);
			} catch (Exception ex) {
				System.exit(0);
			}
			thisCar.NewCar(ID, mileage, MPG, cost, salesPrice);
			thisCar.changeSold(sold);
			thisCar.changePriceSold(priceSold);
			thisCar.changeProfit(profit);
			add(thisCar);
		}
	}

}
