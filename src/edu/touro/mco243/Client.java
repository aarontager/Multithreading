package edu.touro.mco243;

public class Client extends Thread {
	boolean isInShop = false;

	public Client(String name) {
		super(name);
	}

	public void run() {
		enterShop();
		int barberId = Main.waitForBarber();
		getHaircut(barberId);
		return;
	}

	private void enterShop() {
		try {
			Thread.sleep((long)(Math.random() * 1000));
			isInShop = true;
			System.out.println(String.format("Client %s entered the shop", Thread.currentThread().getName()));
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void getHaircut( int id) {
		try {
			System.out.println(String.format("Client %s getting haircut with barber %d",
					Thread.currentThread().getName(), id + 1)
			);

			Thread.sleep((long) (Math.random() * 1000));
			System.out.println(String.format("Client %s haircut complete, barber %d free.",
					Thread.currentThread().getName(), id + 1)
			);
			Main.leaveShop(id);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
