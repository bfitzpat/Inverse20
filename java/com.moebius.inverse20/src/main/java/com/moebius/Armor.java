package com.moebius;

public class Armor extends Item {
	
	private int armorrating = 0;
	private int armorpoints = 0;
	
	public Armor(String name, String description, int AR, int AP) {
		super(name, description);
		setArmorrating(AR);
		setArmorpoints(AP);
	}
	
	public int getAR() {
		return getArmorrating();
	}
	public int getArmorrating() {
		return armorrating;
	}
	public void setArmorrating(int armorrating) {
		this.armorrating = armorrating;
	}
	public int getAP() {
		return getArmorpoints();
	}
	public int getArmorpoints() {
		return armorpoints;
	}
	public void setArmorpoints(int armorpoints) {
		this.armorpoints = armorpoints;
	}

}
