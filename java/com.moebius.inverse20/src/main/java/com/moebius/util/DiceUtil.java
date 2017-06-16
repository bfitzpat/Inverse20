package com.moebius.util;

/**
 * Simple Dice Rolling utility class
 * @author brianf
 *
 */
public class DiceUtil {

	public int rollDie(int sides) {
		Math.random();
		return (int) (Math.random() * sides) + 1;
	}
	
	public int rollDie(String sides) {
		if (sides != null && !sides.isEmpty()) {
			Integer numSides = Integer.decode(sides);
			if (numSides != null) {
				return rollDie(numSides.intValue());
			}
		}
		return -1;
	}

	public int rollD4() {
		return rollDie(4);
	}
	
	public int rollD6() {
		return rollDie(6);
	}

	public int rollD8() {
		return rollDie(8);
	}

	public int rollD10() {
		return rollDie(10);
	}

	public int rollD12() {
		return rollDie(12);
	}

	public int rollD20() {
		return rollDie(20);
	}

	public int rollD30() {
		return rollDie(30);
	}

	public int rollD100() {
		return rollDie(100);
	}
	
	public int roll6Plus2D6() {
		int d6a = rollD6();
		int d6b = rollD6();
		return 6 + d6a + d6b;
	}
	
}
