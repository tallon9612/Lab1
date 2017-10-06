public class Workers {
	Mutex m = new Mutex();

	// States of the mangos
	public enum State {
		Fetched(15), Peeled(38), Squeezed(29), Bottled(17), Finished(15);

		// length of Index
		private static final int finalIndex = State.values().length - 1;

		// int for amount of time given
		final int timeToComplete;

		State(int timeToComplete) {
			this.timeToComplete = timeToComplete;
		}

		// method to return state of mango
		State getNext() {
			int currIndex = this.ordinal();
			if (currIndex >= finalIndex) {
				throw new IllegalStateException("Already at final state");
			}
			return State.values()[currIndex + 1];
		}
	}

	// state declareration
	private State state;

	// workers method
	public Workers() {
		state = State.Fetched;
		doWork();
	}

	// get state method
	public State getState() {

		return state;

	}

	// method to run through all the processes, most critical data is eddited
	// here
	public void runProcess() {

		// fetching
		// cheek to see if its correct threads
		if (getName().equals("Employee[1]")) {
			if (state == State.Fetched) {
				m.fetch();
				try {
					delay(100);

				} finally {
					m.fetched();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.print(Thread.currentThread().getName() + "This is not
			// my job");
			// }
		}

		// fetching for second plant
		// cheek to see if its correct threads
		if (getName().equals("Employee2[1]")) {
			if (state == State.Fetched) {
				m.fetch2();
				try {
					delay(100);

				} finally {
					m.fetched2();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.print(Thread.currentThread().getName() + "This is not
			// my job");
			// }
		}

		// peeling
		// cheek to see if its correct threads
		if (getName().equals("Employee[2]")) {
			if (state == State.Peeled) {
				m.Peel();
				try {
					delay(200);

				} finally {
					m.Peeled();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.println(Thread.currentThread().getName() + "This is
			// not my job");
			// }
		}

		// peeling for second plant
		// cheek to see if its correct threads
		if (getName().equals("Employee2[2]")) {
			if (state == State.Peeled) {
				m.Peel2();
				try {
					delay(200);

				} finally {
					m.Peeled2();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.println(Thread.currentThread().getName() + "This is
			// not my job");
			// }
		}

		// squeezing
		// cheek to see if its correct threads
		if (getName().equals("Employee[3]")) {
			if (state == State.Squeezed) {
				m.Squeeze();
				try {

					delay(500);

				} finally {
					m.Squeezed();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.println(Thread.currentThread().getName() + "This is
			// not my job");
			// }
		}
		// squeezing for second plant
		// cheek to see if its correct threads
		if (getName().equals("Employee2[3]")) {
			if (state == State.Squeezed) {
				m.Squeeze2();
				try {

					delay(500);

				} finally {
					m.Squeezed2();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.println(Thread.currentThread().getName() + "This is
			// not my job");
			// }
		}
		// bottling
		// cheek to see if its correct threads
		if (getName().equals("Employee[4]")) {
			if (state == State.Bottled) {
				m.Bottle();
				try {
					delay(500);
				} finally {
					m.Bottled();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.println(Thread.currentThread().getName() + "This is
			// not my job");
			// }
		}

		// bottling second plant
		// cheek to see if its correct threads
		if (getName().equals("Employee2[4]")) {
			if (state == State.Bottled) {
				m.Bottle2();
				try {
					delay(500);
				} finally {
					m.Bottled2();
				}
			}
			// used for debug, keeping it in for now
			// else{
			// System.out.println(Thread.currentThread().getName() + "This is
			// not my job");
			// }
		}

		// Don't attempt to process an already completed Mango
		if (state == State.Finished) {
			throw new IllegalStateException("This Mango has already been processed");
		}
		state = state.getNext();
		doWork();

	}

	// gets threads name and puts it in it statement
	private Object getName() {
		// used for debug, keeping it in for now
		// System.out.println(Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}

	// method that runs sleep to simulate work
	private void doWork() {
		// Sleep for the amount of time necessary to do the work
		try {
			Thread.sleep(state.timeToComplete);
		} catch (InterruptedException e) {
			System.err.println("Incomplete Mango processing, juice may be bad");
		}
	}

	// sleep method
	private void delay(long timeInMs) {
		timeInMs = Math.max(1, timeInMs);
		try {
			Thread.sleep(timeInMs);
		} catch (InterruptedException ignored) {
		}
	}
}
// CREDIT TO STEVEN HARPER FOR GIVING ME IDEAS TO MAKE MY IF STATEMENTS