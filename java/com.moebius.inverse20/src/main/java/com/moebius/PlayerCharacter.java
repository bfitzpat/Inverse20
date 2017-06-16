package com.moebius;

import java.util.ArrayList;
import java.util.List;

import com.moebius.util.DiceUtil;

public class PlayerCharacter {

	private String name;
	private int toughness;
	private int accuracy;
	private int athletics;
	private int education;
	private int presence;
	private int morale;
	private int level;
	private int speed;
	private int currentHP;
	private int currentAR;
	private int currentAP;
	private int currentMorale;

	private ArrayList<Trait> traits = new ArrayList<Trait>();
	private ArrayList<Item> items = new ArrayList<Item>();
	protected DiceUtil roller = new DiceUtil();
	
	private ArrayList<Skill> weaponsSkillList = new ArrayList<Skill>();
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	private ArrayList<Boon> boonList = new ArrayList<Boon>();
	private ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
	private ArrayList<Armor> armorList = new ArrayList<Armor>();
	
	
	public PlayerCharacter() {
		createArmorList();
		createBoonList();
		createEdgeList();
		createWeaponsList();
		createWeaponsSkillList();
	}
	
	public void create() {
		this.name = "Nameless";
		this.level = 1;
		this.speed = 30;
		this.toughness = roller.roll6Plus2D6();
		this.currentHP = this.toughness;
		this.accuracy = roller.roll6Plus2D6();
		this.athletics = roller.roll6Plus2D6();
		this.education = roller.roll6Plus2D6();
		this.presence = roller.roll6Plus2D6();
		this.morale = roller.roll6Plus2D6();
		this.currentMorale = this.morale;
		this.currentAR = 0;
		this.currentAP = 0;
	}
	
	private void addNewLine(String text, StringBuffer buffer) {
		buffer.append(text);
		buffer.append('\n');
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		addNewLine("--------------------------------", buffer);
		addNewLine("Name = " + this.name, buffer);
		addNewLine("Level = " + this.level, buffer);
		addNewLine("speed = " + this.speed, buffer);
		addNewLine("--------------------------------", buffer);
		addNewLine("Attributes:", buffer);
		addNewLine("toughness = " + this.toughness, buffer);
		addNewLine("accuracy = " + this.accuracy, buffer);
		addNewLine("athletics = " + this.athletics, buffer);
		addNewLine("education = " + this.education, buffer);
		addNewLine("presence = " + this.presence, buffer);
		addNewLine("morale = " + this.morale, buffer);
		addNewLine("--------------------------------", buffer);
		addNewLine("currentHP = " + this.currentHP, buffer);
		addNewLine("currentAR = " + this.currentAR, buffer);
		addNewLine("currentAP = " + this.currentAP, buffer);
		addNewLine("currentMorale = " + this.currentMorale, buffer);
		addNewLine("--------------------------------", buffer);
		addNewLine("Traits:", buffer);
		for (Trait trait : traits) {
			StringBuffer traitBuffer = new StringBuffer();
			traitBuffer.append(trait.getName());
			if (trait.getDescription() != null && !trait.getDescription().isEmpty()) {
				traitBuffer.append(" (" + trait.getDescription() + ")");
			}
			if (trait instanceof Skill) {
				Skill skill = (Skill) trait;
				if (skill.getKeyAttribute() != null) {
					traitBuffer.append(" (" + skill.getKeyAttribute() + ")");
				}
				if (skill.getDamageBonus() != null) {
					traitBuffer.append(" (Dmg bonus " + skill.getDamageBonus() + ")");
				}
				if (skill.getReloadSpeedBonus() != null) {
					traitBuffer.append(" (RS " + skill.getReloadSpeedBonus() + ")");
				}
			}
			addNewLine(traitBuffer.toString(), buffer);			
		}
		addNewLine("--------------------------------", buffer);
		addNewLine("Items:", buffer);
		for (Item item : items) {
			StringBuffer itemBuffer = new StringBuffer();
			itemBuffer.append(item.getName());
			if (item.getDescription() != null && !item.getDescription().isEmpty()) {
				itemBuffer.append(" (" + item.getDescription() + ")");
			}
			if (item instanceof Armor) {
				Armor armor = (Armor) item;
				itemBuffer.append(" (AR" + armor.getAR() + "/AP" + armor.getAP() + ")");
			} else if (item instanceof RangedWeapon) {
				RangedWeapon rangedWeapon = (RangedWeapon) item;
				itemBuffer.append(" (RS" + rangedWeapon.getReloadSpeed() 
				+ "/Rounds " + rangedWeapon.getRoundsRemaining() + " of " + rangedWeapon.getClipSize() 
				+ "/Reloads " + rangedWeapon.getReloads() 
				+ "/Damage " + rangedWeapon.getDamage() + ")");
			} else if (item instanceof Weapon) {
				Weapon weapon = (Weapon) item;
				itemBuffer.append(" (Damage " + weapon.getDamage() + ")");
			}
			addNewLine(itemBuffer.toString(), buffer);			
		}
		return buffer.toString();
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public ArrayList<Trait> getTraits() {
		return traits;
	}
	public void setTraits(ArrayList<Trait> traits) {
		this.traits = traits;
	}
	public int getToughness() {
		return toughness;
	}
	public void setToughness(int toughness) {
		this.toughness = toughness;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getAthletics() {
		return athletics;
	}
	public void setAthletics(int athletics) {
		this.athletics = athletics;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public int getPresence() {
		return presence;
	}
	public void setPresence(int presence) {
		this.presence = presence;
	}
	public int getMorale() {
		return morale;
	}
	public void setMorale(int morale) {
		this.morale = morale;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public int getCurrentAR() {
		return currentAR;
	}
	public void setCurrentAR(int currentAR) {
		this.currentAR = currentAR;
	}
	public int getCurrentAP() {
		return currentAP;
	}
	public void setCurrentAP(int currentAP) {
		this.currentAP = currentAP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentMorale() {
		return currentMorale;
	}

	public void setCurrentMorale(int currentMorale) {
		this.currentMorale = currentMorale;
	}

	public ArrayList<Skill> getWeaponsSkillList() {
		return weaponsSkillList;
	}

	public void setWeaponsSkillList(ArrayList<Skill> weaponsSkillList) {
		this.weaponsSkillList = weaponsSkillList;
	}

	public ArrayList<Weapon> getWeaponsList() {
		return weaponsList;
	}

	public void setWeaponsList(ArrayList<Weapon> weaponsList) {
		this.weaponsList = weaponsList;
	}

	protected void createWeaponsList() {
		// empty
	}
	
	protected void createWeaponsSkillList() {
		// empty
	}

	protected void createArmorList() {
		// empty
	}

	protected void createEdgeList() {
		// empty
	}

	protected void createBoonList() {
		// empty
	}
	
	protected Skill getWeaponSkill() {
		return (Skill) getRandomFromList(weaponsSkillList);
	}

	protected Object getRandomFromList(List<?> inList) {
		int total = inList.size();
		int random = roller.rollDie(total) - 1;
		return inList.get(random);
	}
	
	protected Item getWeaponForSkill(Skill weaponSkill) {
		return null;
	}

	public ArrayList<Armor> getArmorList() {
		return armorList;
	}

	public void setArmorList(ArrayList<Armor> armorList) {
		this.armorList = armorList;
	}

	protected Armor getRandomArmor() {
		return (Armor) getRandomFromList(armorList);
	}

	protected Weapon getRandomWeapon() {
		return (Weapon) getRandomFromList(weaponsList);
	}

	protected Edge getRandomEdge() {
		return (Edge) getRandomFromList(edgeList);
	}

	protected Boon getRandomBoon() {
		return (Boon) getRandomFromList(boonList);
	}

	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(ArrayList<Edge> edgeList) {
		this.edgeList = edgeList;
	}

	public ArrayList<Boon> getBoonList() {
		return boonList;
	}

	public void setBoonList(ArrayList<Boon> boonList) {
		this.boonList = boonList;
	}
}

