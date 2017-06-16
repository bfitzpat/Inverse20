package com.moebius;

public class Skill extends Trait {
	
	private String keyAttribute;
	private String damageBonus;
	private String reloadSpeedBonus;
	
	public Skill(String name, String description, String attribute) {
		super(name, description);
		setKeyAttribute(attribute);
	}
	
	public String getKeyAttribute() {
		return keyAttribute;
	}
	public void setKeyAttribute(String keyAttribute) {
		this.keyAttribute = keyAttribute;
	}
	public String getDamageBonus() {
		return damageBonus;
	}
	public void setDamageBonus(String damageBonus) {
		this.damageBonus = damageBonus;
	}
	public String getReloadSpeedBonus() {
		return reloadSpeedBonus;
	}
	public void setReloadSpeedBonus(String reloadSpeedBonus) {
		this.reloadSpeedBonus = reloadSpeedBonus;
	}

}
