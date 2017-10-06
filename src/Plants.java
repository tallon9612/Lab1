public class Plants {
	
	
	//int for number of workers per plant
	private static final int Worker = 5;

	// time for plants to run
	public static final long PROCESS_TIME = 5 * 1000;

	// start of main
	public static void main(String[] args) {

		// makes as many employee threads as there are workers(plant 1)
		Employee[] workergroup1 = new Employee[Worker];
		for (int i = 0; i < Worker; i++) {
			workergroup1[i] = new Employee(i);
			workergroup1[i].startWorkers();
		}


		// makes as many employee threads as there are workers(plant 2)
		Employee2[] workergroup2 = new Employee2[Worker];
		for (int i = 0; i < Worker; i++) {
			workergroup2[i] = new Employee2(i);
			workergroup2[i].startWorkers();
		}

		// Kill switch if a issue occurs
		delay(PROCESS_TIME, "Critical Plant malfunction");

		// Stop employee/worker group1, and wait for shutdown
		for (Employee p : workergroup1) {
			p.stopWork();
		}
		for (Employee p : workergroup1) {
			p.waitToStop();
		}

		// Stop employee/worker group2, and wait for shutdown
				for (Employee2 p : workergroup2) {
					p.stopWork();
				}
				for (Employee2 p : workergroup2) {
					p.waitToStop();
				}

		// init values for provided mangos
		int totalProvided = 0;
		// init values for total processed mangos
		int totalProcessed = 0;
		// init values for total Bottles
		int totalBottles = 0;
		// init values for total wasted mangos
		int totalWasted = 0;

		// adds up the count of all ints used by workergroup1
		for (Employee p : workergroup1) {
			totalProvided += p.getProvidedMangos();
			totalProcessed += p.getProcessedMangos();
			totalBottles += p.getBottles();
			totalWasted += p.getWaste();
		}
		// adds up the count of all ints used by workergroup2
		// count total mangos and other items here
				for (Employee2 p : workergroup2) {
					totalProvided += p.getProvidedMangos();
					totalProcessed += p.getProcessedMangos();
					totalBottles += p.getBottles();
					totalWasted += p.getWaste();
				}

		// Grand total
		System.out.println("Total provided and processed = " + totalProvided + "/" + totalProcessed);
		System.out.println("Created " + totalBottles + " bottles, and wasted " + totalWasted + " Mangos");

	}
	// end of main
	
	//Delay method for timer
	private static void delay(long time, String errMsg) {
		long sleepTime = Math.max(1, time);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			System.err.println(errMsg);
		}
	}

}