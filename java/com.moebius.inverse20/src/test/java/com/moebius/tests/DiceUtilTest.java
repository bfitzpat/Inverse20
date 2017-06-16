package com.moebius.tests;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.moebius.util.DiceUtil;

/**
 * Basic test class to test all variations of the DiceUtil
 * @author brianf
 *
 */
public class DiceUtilTest {
	
	private int numberOfRolls = 10;
	
	private void runTest(Method method, int sides, int max) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		runTest(method, sides, 0, max);
	}

	private void runTest(Method method, int sides, int  min, int max) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DiceUtil roller = new DiceUtil();
		for(int i=0; i < numberOfRolls; i++) {
			int die = (Integer) method.invoke(roller);
			boolean isBetweenMinAndMax = (die > min) && (die < max);
			System.out.println("die roll (" + sides + " sides) = " + die);
			assertTrue("die roll (" + sides + " sides) is not between " + min + "and" + max, isBetweenMinAndMax);
		}
	}

	private void runTestWithArg(Method method, int sides, int  min, int max) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DiceUtil roller = new DiceUtil();
		for(int i=0; i < 10; i++) {
			int die = (Integer) method.invoke(roller, sides);
			boolean isBetweenMinAndMax = (die > min) && (die < max);
			System.out.println("die roll (" + sides + " sides) = " + die);
			assertTrue("die roll (" + sides + " sides) is not between " + min + "and" + max, isBetweenMinAndMax);
		}
	}

	private void runTestWithArg(Method method, String sides, int  min, int max) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DiceUtil roller = new DiceUtil();
		for(int i=0; i < 10; i++) {
			int die = (Integer) method.invoke(roller, sides);
			boolean isBetweenMinAndMax = (die > min) && (die < max);
			System.out.println("die roll (" + sides + " sides) = " + die);
			assertTrue("die roll (" + sides + " sides) is not between " + min + "and" + max, isBetweenMinAndMax);
		}
	}

	@Test
	public void testRollDieString() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollDieString");
		Method rollDieMethod = DiceUtil.class.getMethod("rollDie", String.class);
		runTestWithArg(rollDieMethod, "3", 0, 4);
	}

	@Test
	public void testRollDie() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollDie");
		Method rollDieMethod = DiceUtil.class.getMethod("rollDie", int.class);
		runTestWithArg(rollDieMethod, 2, 0, 3);
	}

	@Test
	public void testRollD4() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD4");
		Method rollMethod = DiceUtil.class.getMethod("rollD4", (Class[]) null);
		runTest(rollMethod, 4, 5);
	}

	@Test
	public void testRollD6() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD6");
		Method rollMethod = DiceUtil.class.getMethod("rollD6", (Class[]) null);
		runTest(rollMethod, 6, 7);
	}

	@Test
	public void testRollD8() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD8");
		Method rollMethod = DiceUtil.class.getMethod("rollD8", (Class[]) null);
		runTest(rollMethod, 8, 9);
	}

	@Test
	public void testRollD10() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD10");
		Method rollMethod = DiceUtil.class.getMethod("rollD10", (Class[]) null);
		runTest(rollMethod, 10, 11);
	}

	@Test
	public void testRollD12() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD12");
		Method rollMethod = DiceUtil.class.getMethod("rollD12", (Class[]) null);
		runTest(rollMethod, 12, 13);
	}

	@Test
	public void testRollD20() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD20");
		Method rollMethod = DiceUtil.class.getMethod("rollD20", (Class[]) null);
		runTest(rollMethod, 20, 21);
	}

	@Test
	public void testRollD30() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD30");
		Method rollMethod = DiceUtil.class.getMethod("rollD30", (Class[]) null);
		runTest(rollMethod, 30, 31);
	}

	@Test
	public void testRollD100() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRollD100");
		Method rollMethod = DiceUtil.class.getMethod("rollD100", (Class[]) null);
		runTest(rollMethod, 100, 101);
	}
	
	@Test
	public void testRoll6Plus2D6()  throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("testRoll6Plus2D6");
		Method rollMethod = DiceUtil.class.getMethod("roll6Plus2D6", (Class[]) null);
		runTest(rollMethod, 7, 19);
	}
}
