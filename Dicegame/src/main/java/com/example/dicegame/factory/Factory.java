package com.example.dicegame.factory;

import com.example.dicegame.game.Game;

public class Factory {
	private final int diceNum;

	public Factory(int numberOfDice) {
		if (numberOfDice <= 0) {
			throw new IllegalArgumentException("Number of dice must be greater than zero.");
		}
		this.diceNum = numberOfDice;
	}

	public Game createGame() {
		return new Game(diceNum);
	}

	public int getNumberOfDice() {
		return diceNum;
	}
}
