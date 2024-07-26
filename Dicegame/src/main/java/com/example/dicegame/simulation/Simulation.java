package com.example.dicegame.simulation;

import java.util.HashMap;
import java.util.Map;

import com.example.dicegame.factory.Factory;
import com.example.dicegame.game.Game;

public class Simulation {
	private final int totalSimulations;
	private final Map<Integer, Integer> score;
	private final Factory gameFactory;

	public Simulation(int totalSimulations, Factory gameFactory) {
		if (totalSimulations <= 0) {
			throw new IllegalArgumentException("Number of simulations must be greater than zero.");
		}
		this.totalSimulations = totalSimulations;
		this.score = new HashMap<>();
		this.gameFactory = gameFactory;
	}

	public void run() {
		for (int i = 0; i < totalSimulations; i++) {
			try {
				Game game = gameFactory.createGame();
				int scoreValue = game.playGame();
				score.put(scoreValue, score.getOrDefault(scoreValue, 0) + 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void printResults() {
		   System.out.println("Number of simulations: " + totalSimulations + " using " + gameFactory.getNumberOfDice() + " dice.");
		for (Map.Entry<Integer, Integer> e : score.entrySet()) {
			double frequency = (double) e.getValue() / totalSimulations;
			System.out.printf("Score %d occurred %.2f%% of the time (%d times).%n", e.getKey(), frequency * 100,
					e.getValue());
		}
	}
}
