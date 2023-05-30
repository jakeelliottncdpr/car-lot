public class CarTester {

	public static void main(String[] args) {
		// Instantiate at least 2 Car objects
		Car carOne = new Car();
		Car carTwo = new Car();

		/*
		 * Insure that both constructors work as specified. This is especially important
		 * for the constructor used to add a new Car to the inventory.
		 */
		// Create two variables to know which constructor is working or not
		boolean defaultConstructorWorks;
		boolean NewCarConstructorWorks;
		// Ensure default constructor is working properly...
		defaultConstructorWorks = carOne.toString().equals(carTwo.toString()) ? true : false;
		// Ensure other constructor (NewCar) is working properly
		// ID, mileage, MPG, cost, salesPrice
		carOne.NewCar("Test Car One", 10, 20, 30.00, 40.01);
		carTwo.NewCar("Test Car Two", 10, 21, 30.00, 40.00);
		NewCarConstructorWorks = carOne.getCost() == 30.00 ? true : false;

		// Insure that the sellCar() method works properly
		boolean sellCarWorks;
		carOne.sellCar(300);
		sellCarWorks = carOne.getSold() ? true : false;

		/*
		 * Test each of the Compare methods above by creating two Car objects and
		 * verifying that each possible return value (negative number, zero, or positive
		 * number) is generated as expected
		 */
		boolean compareMilesWorks = false;
		boolean compareMPGWorks = false;
		boolean comparePriceWorks = false;
		if (carOne.compareMiles(carTwo) == 0 && carOne.compareMPG(carTwo) == -1 && carOne.comparePrice(carTwo) == 1) {
			carOne.changeMPG(21);
			carOne.changeMileage(11);
			carOne.changeSalesPrice(40.00);
			if (carOne.compareMiles(carTwo) == 1 && carOne.compareMPG(carTwo) == 0
					&& carOne.comparePrice(carTwo) == 0) {
				carOne.changeMPG(22);
				carOne.changeMileage(9);
				carOne.changeSalesPrice(39);
				if (carOne.compareMiles(carTwo) == -1 && carOne.compareMPG(carTwo) == 1
						&& carOne.comparePrice(carTwo) == -1) {
					compareMilesWorks = true;
					compareMPGWorks = true;
					comparePriceWorks = true;
				} else {
					if (carOne.compareMiles(carTwo) != -1) {
						compareMilesWorks = false;
					}
					if (carOne.compareMPG(carTwo) != 1) {
						compareMPGWorks = false;
					}
					if (carOne.comparePrice(carTwo) != -1) {
						comparePriceWorks = false;
					}
				}
			} else {
				if (carOne.compareMiles(carTwo) != 1) {
					compareMilesWorks = false;
				}
				if (carOne.compareMPG(carTwo) != 0) {
					compareMPGWorks = false;
				}
				if (carOne.comparePrice(carTwo) != 0) {
					comparePriceWorks = false;
				}
			}
		} else {
			if (carOne.compareMiles(carTwo) != 0) {
				compareMilesWorks = false;
			}
			if (carOne.compareMPG(carTwo) != -1) {
				compareMPGWorks = false;
			}
			if (carOne.comparePrice(carTwo) != 1) {
				comparePriceWorks = false;
			}
		}
		// Print the results of our testing (only if there was an error)
		// Print in the console the status of both our constructors
		if (defaultConstructorWorks == false && NewCarConstructorWorks == false) {
			System.err.println("Both constructors are broken.");
		} else if (defaultConstructorWorks == false || NewCarConstructorWorks == false) {
			System.err.println(defaultConstructorWorks == false ? "The default constructor is broken"
					: "The NewCar constructor is broken");
		}
		// Print in the console the status of the sellCar() method
		if (!sellCarWorks) {
			System.err.println("the sellCar() mutator seems to be broken");
		}
		// Print in the console the status of all of the compare methods work
		if (!compareMilesWorks && !compareMPGWorks && !comparePriceWorks) {
			System.err.println("All of the compare methods are broken");
		} else {
			if (!compareMilesWorks) {
				System.err.println("compareMiles method is broken");
			}
			if (!compareMPGWorks) {
				System.err.println("compareMPG method is broken");
			}
			if (!comparePriceWorks) {
				System.err.println("comparePrice method is broken");
			}
		}
	}

}
