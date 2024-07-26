package com.example.dicegame.game;

import java.util.Collections;
import java.util.List;

import com.example.dicegame.dice.Dice;

public class Game {
	private Dice dice;
	private int total;

	public Game(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of dice must be greater than zero.");
		}
		this.dice = new Dice(n);
		this.total = 0;
	}

	public int playGame() {
		while (!dice.isEmpty()) {
			List<Integer> list = dice.roll();
			if (list.contains(3)) {
				list.removeIf(die -> die == 3);
			} else {
				int min = Collections.min(list);
				total += min;
				list.remove(Integer.valueOf(min));
			}
			dice.setDice(list);
		}
		return total;
	}
}
