package com.example.dicegame;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dicegame.factory.Factory;
import com.example.dicegame.simulation.Simulation;

@SpringBootApplication
public class DicegameApplication {

	public static void main(String[] args) {
		try {
			int totalSimulations = 10000;
			int numberOfDice = 5;
			Simulation simulation = new Simulation(totalSimulations, new Factory(numberOfDice));
			simulation.run();
			simulation.printResults();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
