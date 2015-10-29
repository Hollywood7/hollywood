package dopses;

public class Homework1 {

	public static void main(String[] args) {

		final HomeWork<String> stack = new HomeWork(5);

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				int counter = 0;

				for (;;) {

					counter++;

					stack.push(String.valueOf(counter));

					try {

						Thread.sleep(3000);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

				}

			}

		});

		thread.start();

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (;;) {

					try {

						Thread.sleep(5000);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					Object value = stack.pull();

					System.out.println(" object: " + value);

				}

			}

		});

		thread2.start();

	}

}