import java.io.FileNotFoundException;

public class CarLotTester {

	public static void main(String[] args) {
		// Test that the addCar() and sellCar() methods work as expected
		CarLot inventory = new CarLot();
		inventory.addCar("778899", 100, 900, 300, 400);
		Car testCar = new Car();
		testCar.NewCar("778899", 100, 900, 300, 400);
		inventory.addCar("200000", 500, 600, 700, 800);
		inventory.sellCar("200000", 1100);
		try {inventory.saveToDisk();} catch (Exception ex) {}
		try {inventory.loadFromDisk();} catch (FileNotFoundException e) {}

		if ((inventory == null)) {
			System.out.println("Error: inventory is null");
		}
		if (inventory.getTotalProfit() != 400.0) {
			System.out.println("Error");
		}

		// Verify that the accessor methods work as expected by creating a CarLot
		// with an inventory of at least 2 Cars. Your code should call the appropriate
		// accessor and if the correct Car is not returned, print an error message on
		// the Console
		// I already have the CarLot created with 2 cars from step 1
		if (inventory.getInventory().isEmpty()) {
			System.out.println("Error: inventory not returned as expected");
		}
		if (!inventory.findCarByIdentifier(testCar.getID()).toString().equals(testCar.toString())) {
			System.out.println("Error: findCarByIdentifier() did not return the expected car");
		}
		if (!inventory.getCarsInOrderOfEntry().equals(inventory.getInventory())) {
			System.out.println("Error: getCarsInOrderOfEntry() did not return the expected order");
		}
		if (!inventory.getCardsSortedByMPG().get(0).getID().equals(testCar.getID())) {
			System.out.println(inventory.getCardsSortedByMPG().get(0).getID());
			System.out.println(testCar.getID());
			System.out.println("Error: getCardsSortedByMPG() did not return the expected car");
		}
		if (!inventory.getCarWithBestMPG().getID().equals(testCar.getID())) {
			System.out.println("Error: getCarWithBestMPG() did not return the expected car");
		}
		if (inventory.getCarWithHighestMileage().getID() == testCar.getID()) {
			System.out.println("Error: getCarWithHighestMileage() did not return the expected car");
		}
		if (inventory.getAverageMpg() != 750) {
			System.out.println("Error: getAverageMpg() did not return the expected value");
		}
		if (inventory.getTotalProfit() != 400.0) {
			System.out.println("Error: getTotalProfit() did not return the expected profit value");
		}
	}

}
