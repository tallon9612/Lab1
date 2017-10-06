
public class Mutex {

	// booleans for locks

	private boolean fetched = false;
	private boolean Peeled = false;
	private boolean Squeezed = false;
	private boolean Bottled = false;
	private boolean fetched2 = false;
	private boolean Peeled2 = false;
	private boolean Squeezed2 = false;
	private boolean Bottled2 = false;

	// method so only 1 mango can be fetched
	public synchronized void fetch() {
		while (fetched) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		fetched = true;

	}

	// method so only 1 mango can be Peeled
	public synchronized void Peel() {
		while (Peeled) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		Peeled = true;

	}

	// method so only 1 mango can be squeezed
	public synchronized void Squeeze() {
		while (Squeezed) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		Squeezed = true;

	}

	// method so only 1 mango group can be Bottled
	public synchronized void Bottle() {
		while (Bottled) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		Bottled = true;

	}

	// release of fetch
	public synchronized void fetched() {
		fetched = false;
		System.out.println(Thread.currentThread().getName() + "This Mango has fetched");
		notifyAll();

	}

	// release of peel
	public synchronized void Peeled() {
		Peeled = false;
		System.out.println(Thread.currentThread().getName() + "This Mango has  been peeled");
		notifyAll();

	}

	// release of squeeze
	public synchronized void Squeezed() {
		Squeezed = false;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + "This Mango has  been squeezed");

	}

	// release of bottled
	public synchronized void Bottled() {
		Bottled = false;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + "This Mango has  been bottled");

	}

	// methods for the second plant

	// fetch for second group
	public synchronized void fetch2() {
		while (fetched2) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		fetched2 = true;

	}

	// fetch release for second group
	public synchronized void fetched2() {
		fetched2 = false;
		System.out.println(Thread.currentThread().getName() + "This Mango has fetched");
		notifyAll();

	}

	// peel for second group
	public synchronized void Peel2() {
		while (Peeled2) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		Peeled2 = true;

	}

	// peeled for second group
	public synchronized void Peeled2() {
		Peeled2 = false;
		System.out.println(Thread.currentThread().getName() + "This Mango has  been peeled");
		notifyAll();

	}

	// squeeze for second group
	public synchronized void Squeeze2() {
		while (Squeezed2) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		Squeezed2 = true;

	}

	// squeezed for second group
	public synchronized void Squeezed2() {
		Squeezed2 = false;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + "This Mango has  been squeezed");

	}

	// Bottle for second group
	public synchronized void Bottle2() {
		while (Bottled2) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		Bottled2 = true;

	}

	// Bottled for second group
	public synchronized void Bottled2() {
		Bottled2 = false;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + "This Mango has  been bottled");

	}

}
