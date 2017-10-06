
public class Employee implements Runnable {

	// ints for the employee methods
	public final int MANGOS_PER_BOTTLE = 5;
	private final Thread thread;
	private int MangosProvided;
	private int MangosProcessed;
	private volatile boolean timeToWork;

	// creates employee2 threads
	Employee(int num) {
		MangosProvided = 0;
		MangosProcessed = 0;
		thread = new Thread(this, "Employee[" + num + "]");
	}
	
	

	// start workers method
	public void startWorkers() {
		timeToWork = true;
		thread.start();

	}

	// stop worker method
	public void stopWork() {
		timeToWork = false;

	}

	// method to wait untill stop
	public void waitToStop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.println(thread.getName() + "  malfunction");
		}

	}

	// runs the threads
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Starting work");
		while (timeToWork) {

			processEntireMango(new Workers());

			MangosProvided++;
			// System.out.print(".");

		}
		System.out.println("");

	}

	// method to get num of mangos
	public int getProvidedMangos() {
		return MangosProvided;
	}

	// method to get num of processed mangos
	public int getProcessedMangos() {
		return MangosProcessed;
	}

	// method to get amount of botteled mangos
	public int getBottles() {
		return MangosProcessed / MANGOS_PER_BOTTLE;
	}

	// method to show amount of mangos wasted
	public int getWaste() {
		return MangosProcessed % MANGOS_PER_BOTTLE;
	}

	// runs process method if mangos are not bottled
	public void processEntireMango(Workers w) {
		while (w.getState() != Workers.State.Finished) {
			w.runProcess();
		}
		MangosProcessed++;
	}
}
