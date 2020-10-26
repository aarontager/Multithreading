package edu.touro.mco243;

public class Main {
	private static boolean isBarberAvailable = true;
	private static Barber[] barbers = new Barber[2];
	private static Client[] clients = new Client[10];

	public static void main(String[] args) {

		for(int i = 0; i < barbers.length; i++) {
			barbers[i] = new Barber();
		}
		for(int i = 0; i < clients.length; i++) {
			clients[i] = new Client(Integer.toString(i + 1));
			clients[i].start();
		}

		while(true) {
			if(barbers[0].getIsAvailable() || barbers[1].getIsAvailable()) {
				isBarberAvailable = true;
			}
			else {
				isBarberAvailable = false;
			}
		}
	}

	public static int waitForBarber() {
		while(true) {
			if(isBarberAvailable) {
				for(int i = 0; i < barbers.length; i++) {
					if(barbers[i].getIsAvailable()) {
						barbers[i].takeSpot();
						return i;
					}
				}
			}
		}
	}

	public static void leaveShop(int id) {
		barbers[id].setFree();
	}
}
