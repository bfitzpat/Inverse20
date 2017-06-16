package com.moebius.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.moebius.FantasyPC;

public class FantasyPCTests {

	@Test
	public void testCreateFighter() {
		FantasyPC testCharacter = new FantasyPC();
		testCharacter.createFighter();
		assertNotNull(testCharacter);
		System.out.println(testCharacter.toString());
	}

}
