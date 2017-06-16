package com.moebius;

public class Weapon extends Item {
	
	private String damage;
	
	public Weapon(String name, String description, String damage) {
		super(name, description);
		setDamage(damage);
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

}
