package com.moebius;

public class AliensNAsteroidsPC extends PlayerCharacter {

	@Override
	public void create() {
		super.create();
		Armor combatArmor = new Armor("Combat Armor", "Standard Space Marine Issue", 4, 20);
		getItems().add(combatArmor);
		setCurrentAP(combatArmor.getAP());
		setCurrentAR(combatArmor.getAR());
		
		RangedWeapon pulseRifle = new RangedWeapon("Pulse Rifle", "Standard Space Marine Issue", "1d6", 20, 4, 1);
		getItems().add(pulseRifle);
		RangedWeapon pistol = new RangedWeapon("Pistol", "Standard Space Marine Issue", "1d6", 10, 4, 1);
		getItems().add(pistol);
		Weapon combatKnife = new Weapon("Combat Knife", "Standard Space Marine Issue", "1d6");
		getItems().add(combatKnife);
	}
}
