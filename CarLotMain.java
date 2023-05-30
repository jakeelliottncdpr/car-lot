import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarLotMain {

	public static void main(String[] args) {
		CarLot inventory = new CarLot();
		Scanner input = new Scanner(System.in);
		String prompt = "[0]  Exit\n" + "[1]  Add a car to inventory\n" + "[2]  Sell a car from inventory\n"
				+ "[3]  List inventory by order of acquisition\n" + "[4]  List Inventory From Best MPG to Worst MPG\n"
				+ "[5]  Display car with best MPG\n" + "[6]  Display car with the highest mileage\n"
				+ "[7]  Display overall MPG for the entire inventory\n" + "[8]  Display profit for all sold cars\n"
				+ "[9]  Save to Disk\n" + "[10] Load from Disk\n";
		int option;
		int beginning;
		String continueKey;

		/*
		 * For my chosen improvement, I have chosen to give the user the option when they first load
		 * the program to either start from scratch or to load. This will prevent the user from
		 * forgetting to load an inventory they were already working on before implementing any
		 * changes to the inventory. Another little thing that I am adjusting is that previously, 
		 * when a user would enter a non-integer input for the option, it would give an error but to
		 * help prevent that, I am checking if the input was an integer and if it was, it can proceed
		 * but if it is not an integer, I am setting the option to 10,000,000. I chose this number
		 * to leave the program future-proof since it is not likely that there will ever be
		 * that many options.
		 */
		// First, we need to greet the user and ask them what they want to do.
		System.out.println("Welcome! First of all, would you like to load an existing inventory or start from scratch?\nPress 1 to load an existing invenory or 2 to start from scratch. Press any other key quit.");
		// If the chosen option is an integer, proceed and else, set the chosen integer to 
		// 10,000,000 so the program will exit.
		if (input.hasNextInt())
			beginning = input.nextInt();
		else
			beginning = 10000000;
		// Now we neeed to do the logic for what they want to do
		switch (beginning) {
		case 1:
			// Load from disk
			try {
				inventory.loadFromDisk();
				System.out.println("Successfully loaded the car lot inventory from the disk.");
			} catch (FileNotFoundException e) {
				System.out.println("There was an issue loading the file from the disk. We will begin from scratch.");
			}

			break;
		case 2:
			// We don't need to do anything, we can just proceed
			break;
		default:
			// ABORT
			System.out.println("You have selected an invalid option. Goodbye.");
			System.exit(0);
			break;
		}
		do {
			System.out.println(prompt);
			System.out.print("Enter a number from 0 to 10 : ");
			// This is what I was talking about changing. It checks if the input was an integer
			// and if it is, we set the option to be that integer but if it isn't an integer, we
			// will set the option to 10,000,000.
			if (input.hasNextInt()) {
				option = input.nextInt();
			} else {
				option = 10000000;
			}

			switch (option) {
			case 1:
				// Add a car to inventory
				System.out.print("Identifier: ");
				String newIdentifier = input.next();
				System.out.print("Mileage: ");
				int mileage = input.nextInt();
				System.out.print("MPG: ");
				int mpg = input.nextInt();
				System.out.print("Cost: ");
				double cost = input.nextDouble();
				System.out.print("Sales Price: ");
				double salesPrice = input.nextDouble();
				inventory.addCar(newIdentifier, mileage, mpg, cost, salesPrice);

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 2:
				// Sell a car from inventory
				System.out.print("Identifier: ");
				String sellIdentifier = input.next();
				System.out.print("Actual price: ");
				Double priceSold = input.nextDouble();
				inventory.sellCar(sellIdentifier, priceSold);

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 3:
				// List inventory by order of acquisition
				System.out.println(inventory.getCarsInOrderOfEntry());

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 4:
				// List Inventory From Best MPG to Worst MPG
				System.out.println(inventory.getCardsSortedByMPG());

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 5:
				// Display car with best MPG
				System.out.println(inventory.getCarWithBestMPG());

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 6:
				// Display car with the highest mileage
				System.out.println(inventory.getCarWithHighestMileage());

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 7:
				// Display overall MPG for the entire inventory
				System.out.println(inventory.getAverageMpg());

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 8:
				// Display profit for all sold cars
				System.out.println(inventory.getTotalProfit());

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 9:
				// Save to disk
				try {
					inventory.saveToDisk();
					System.out.println("Successfully saved the car lot inventory to the disk.");
				} catch (FileNotFoundException e) {
					System.out.println("There was an issue saving the file to the disk.");
				}

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 10:
				// Load from disk
				// I am leaving this here incase someone decides last minute that they want to load
				// some cars in from a file. This logic actually adds the cars on to the end anyways.
				try {
					inventory.loadFromDisk();
					System.out.println("Successfully loaded the car lot inventory from the disk.");
				} catch (FileNotFoundException e) {
					System.out.println("There was an issue loading the file from the disk.");
				}

				System.out.print("Press any key and then enter to continue");
				continueKey = input.next();
				break;
			case 0:
				System.out.println("You have selected Option 0. Goodbye.");
				break;
			default:
				// I think that if it is an invalid option, we shouldn't quit incase it was a typo.
				System.out.println("You have selected an invalid option. Let's try that again.");
				// We will need to continue
				continueKey = input.next();
				// And because of our do-while loop, we will need the option to be within that range
				// so the program will continue. It doesn't really matter what the option is just
				// as long as it is within that range.
				option = 1;
				break;
			}

		} while (option >= 1 && option <= 10);
	}

}
