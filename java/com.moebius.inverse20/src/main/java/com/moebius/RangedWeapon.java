package com.moebius;

public class RangedWeapon extends Weapon {
	
	private int clipSize;
	private int roundsRemaining;
	private int reloads;
	private int reloadSpeed;
	
	public RangedWeapon(String name, String description, String damage, int clipSize, int reloads, int reloadSpeed) {
		super(name, description, damage);
		setClipSize(clipSize);
		setRoundsRemaining(clipSize);
		setReloads(reloads);
		setReloadSpeed(reloadSpeed);
	}
	
	public int getClipSize() {
		return clipSize;
	}
	public void setClipSize(int clipSize) {
		this.clipSize = clipSize;
	}
	public int getRoundsRemaining() {
		return roundsRemaining;
	}
	public void setRoundsRemaining(int roundsRemaining) {
		this.roundsRemaining = roundsRemaining;
	}
	public int getReloads() {
		return reloads;
	}
	public void setReloads(int reloads) {
		this.reloads = reloads;
	}

	public int getReloadSpeed() {
		return reloadSpeed;
	}

	public void setReloadSpeed(int reloadSpeed) {
		this.reloadSpeed = reloadSpeed;
	}

}
