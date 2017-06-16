package com.moebius;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FantasyPC extends PlayerCharacter {
	
	public FantasyPC() {
		super();
	}

	@Override
	public void create() {
		super.create();
		Armor armor = getRandomArmor();
		getItems().add(armor);
		setCurrentAP(armor.getAP());
		setCurrentAR(armor.getAR());
		
		Skill weaponSkill = getWeaponSkill();
		getTraits().add(weaponSkill);
		Item weaponItem = getWeaponForSkill(weaponSkill);
		if (weaponItem != null) {
			getItems().add(weaponItem);
		}
	}
	
	public void createFighter() {
		super.create();
		
		Armor armor = getRandomArmor();
		getItems().add(armor);
		setCurrentAP(armor.getAP());
		setCurrentAR(armor.getAR());

		Skill weaponSkill = getWeaponSkill();
		getTraits().add(weaponSkill);
		Item weaponItem = getWeaponForSkill(weaponSkill);
		if (weaponItem != null) {
			getItems().add(weaponItem);
		}

		getTraits().add(getRandomEdge());
		getTraits().add(getRandomBoon());
		
		setName("Grognard the Fighter");
	}
	
	@Override
	protected Item getWeaponForSkill(Skill weaponSkill) {
		String name = weaponSkill.getName();
		List<Item> applicable = null;
		if (name.equalsIgnoreCase("axes")) {
			applicable = getWeaponsList().stream().filter(w -> w.getName().toLowerCase().contains("axe")).collect(Collectors.toList());
		} else if (name.equalsIgnoreCase("bows")) {
			applicable = getWeaponsList().stream().filter(w -> w.getName().toLowerCase().contains("bow")).collect(Collectors.toList());
		} else if (name.equalsIgnoreCase("staves")) {
			applicable = getWeaponsList().stream().filter(w -> w.getName().toLowerCase().contains("staff")).collect(Collectors.toList());
		} else if (name.equalsIgnoreCase("blades")) {
			List<String> possibles = Arrays.asList("sword", "dagger");
			applicable = new ArrayList<Item>();
			for (String string : possibles) {
				applicable.addAll(0, getWeaponsList().stream().filter(w -> w.getName().toLowerCase().contains(string)).collect(Collectors.toList()));
			}
		} else if (name.equalsIgnoreCase("blunt")) {
			List<String> possibles = Arrays.asList("mace", "club");
			applicable = new ArrayList<Item>();
			for (String string : possibles) {
				applicable.addAll(0, getWeaponsList().stream().filter(w -> w.getName().toLowerCase().contains(string)).collect(Collectors.toList()));
			}
		}
		if (applicable != null && !applicable.isEmpty()) {
			Item random = (Item) getRandomFromList(applicable);
			if (random != null) {
				return random;
			}
		}
		return null;
	}
	
	@Override
	protected void createWeaponsList() {
		getWeaponsList().add(new RangedWeapon("Crossbow", "Powerful bow for punching through armor", "1d6", 1, 20, 1));
		getWeaponsList().add(new RangedWeapon("Long bow", "Longer, powerful hunting weapon", "1d6", 1, 20, 1));
		getWeaponsList().add(new RangedWeapon("Short bow", "Small, short-range hunting weapon", "1d6", 1, 20, 1));
		getWeaponsList().add(new Weapon("Short Sword", "Short, well-balanced combat blade", "1d6"));
		getWeaponsList().add(new Weapon("Dagger", "Short blade for close work", "1d6"));
		getWeaponsList().add(new Weapon("Battleaxe", "Close contact, two-bladed axe for combat", "1d6"));
		getWeaponsList().add(new Weapon("Long Sword", "Longer, well-balanced combat blade", "1d6"));
		getWeaponsList().add(new Weapon("Quarterstaff", "Long, two-handed staff used to attack and defend", "1d6"));
		getWeaponsList().add(new Weapon("Bo staff", "Short, one-handed staff used to attack and defend", "1d6"));
		getWeaponsList().add(new Weapon("Mace", "Short handled bludgeoning weapon", "1d6"));
		getWeaponsList().add(new Weapon("Club", "Short handled bludgeoning weapon", "1d6"));
	}
	
	@Override
	protected void createWeaponsSkillList() {
		getWeaponsSkillList().add(new Skill("Axes", "Skilled with a variety of axes.", "Athletics"));
		getWeaponsSkillList().add(new Skill("Blades", "Skilled with a variety of blade.", "Athletics"));
		getWeaponsSkillList().add(new Skill("Blunt", "Skilled with a variety of blunt weapons.", "Athletics"));
		getWeaponsSkillList().add(new Skill("Bows", "Skilled with a variety of bows.", "Accuracy"));
		getWeaponsSkillList().add(new Skill("Staves", "Skilled with a variety of staves.", "Athletics"));
	}

	@Override
	protected void createArmorList() {
		getArmorList().add(new Armor("Leather Armor", "Tanned hide armor", 2, 10));
		getArmorList().add(new Armor("Chain Mail Armor", "Metal armor composed of interlinked chain pieces.", 3, 15));
		getArmorList().add(new Armor("Plate Mail Armor", "Metal armor composed of solid plate pieces. -10 to Speed", 4, 20));
	}

	@Override
	protected void createEdgeList() {
		getEdgeList().add(new Edge("Sprinter", "Increase base Speed by 30."));
		getEdgeList().add(new Edge("Accelerated Healing", "able to accelerate healing +d6 HP during “downtime” and 8 hours of rest"));
		getEdgeList().add(new Edge("Heavy Armor", "You have trained to move and fight in heavy armor. Those unfamiliar with fighting in heavy armor are slowed by 10’ per turn. You are not."));
		getEdgeList().add(new Edge("Meditation", "able to accelerate healing +d6 HP or +d6 Morale during “downtime” and 8 hours of rest"));
		getEdgeList().add(new Edge("Shields", "You are skilled with using a shield absorb blows, granting you an additional +1 to AR in combat."));
	}

	@Override
	protected void createBoonList() {
		getBoonList().add(new Boon("Take the Hit", "Interrupt: Able to jump in front of a damaging blow if within 5 feet of target."));
		getBoonList().add(new Boon("Behavior Prediction", "Grant Ally superior knowledge to predict creature behavior, granting them Advantage on their next attack"));
		getBoonList().add(new Boon("Observant", "Can predict enemy path and grant an ally an interrupt to attack during enemy turn"));
		getBoonList().add(new Boon("Healing", "You know how to apply common sense to healing wounds (d6) as a free action."));
		getBoonList().add(new Boon("Leadership", "All members on team have Advantage on Morale rolls when your Morale is 10+ and can use ability during encounters to boost confidence (grant Advantage to whole team for next round of attacks at cost of giving GM one Dread point)"));
		getBoonList().add(new Boon("Psyche", "Can help rebuild morale (Heal 1d6 Morale)"));
		getBoonList().add(new Boon("Psyche", "Can help rebuild morale (Heal 1d6 Morale)"));
		getBoonList().add(new Boon("Spotter", "Grant ally Advantage on next attack"));
		getBoonList().add(new Boon("Tactical Training", "Can forgo action to give ally immediate move or attack"));
	}
}
