package com.moebius.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.moebius.AliensNAsteroidsPC;
import com.moebius.FantasyPC;
import com.moebius.PlayerCharacter;

public class CharacterTest {

	@Test
	public void testCreateNewCharacter() {
		PlayerCharacter testCharacter = new PlayerCharacter();
		testCharacter.create();
		assertNotNull(testCharacter);
		System.out.println(testCharacter.toString());
		assertNotNull(testCharacter.toString());
	}

	@Test
	public void testCreateAnACharacter() {
		AliensNAsteroidsPC testCharacter = new AliensNAsteroidsPC();
		testCharacter.create();
		assertNotNull(testCharacter);
		System.out.println(testCharacter.toString());
		assertNotNull(testCharacter.toString());
		assertEquals(testCharacter.getCurrentAP(), 20);
		assertEquals(testCharacter.getCurrentAR(), 4);
	}

	@Test
	public void testCreateFantasyCharacter() {
		FantasyPC testCharacter = new FantasyPC();
		testCharacter.create();
		assertNotNull(testCharacter);
		System.out.println(testCharacter.toString());
		assertNotNull(testCharacter.toString());
		assertEquals(testCharacter.getCurrentAP(), 10);
		assertEquals(testCharacter.getCurrentAR(), 2);
	}
}
