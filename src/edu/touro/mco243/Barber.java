package edu.touro.mco243;

public class Barber extends Thread {
	private boolean isAvailable = true;

	public void run() {
	}

	public boolean getIsAvailable () {
		return isAvailable;
	}

	public void takeSpot() {
		isAvailable = false;
	}

	public void setFree() {
		isAvailable = true;
	}
}
