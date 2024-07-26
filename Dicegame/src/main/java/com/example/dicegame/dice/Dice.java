package com.example.dicegame.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
	private List<Integer> diceList;
	private final Random random;

	public Dice(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of dice must be greater than zero.");
		}
		this.diceList = new ArrayList<>();
		this.random = new Random();
		roll(n);
	}

	private void roll(int numDice) {
		for (int i = 0; i < numDice; i++) {
			this.diceList.add(random.nextInt(6) + 1);
		}
	}

	public List<Integer> roll() {
		List<Integer> rolledDice = new ArrayList<>();
		for (int i = 0; i < diceList.size(); i++) {
			rolledDice.add(random.nextInt(6) + 1);
		}
		return rolledDice;
	}

	public boolean isEmpty() {
		return diceList.isEmpty();
	}

	public void setDice(List<Integer> diceList) {
		this.diceList = diceList;
	}
}
