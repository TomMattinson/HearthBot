package Game.Heroes;

import Game.BoardState;
import Game.CardType;
import Game.Character;
import Game.Deck;
import Game.Hand;
import Game.MyTurnState;
import Game.TargetsType;
import Game.Heroes.HeroPowers.HeroPower;
import Game.Weapons.Weapon;

public class Hero implements Character {
	private String name;
	private TargetsType side;
	private int HP;
	private int maxHP;
	private int armour;
	private int currentMana;
	private int totalMana;
	private Hand myHand;
	private Deck myDeck;
	private int overload;
	private int fatigue;
	private Weapon weapon;
	private boolean ready;
	private boolean powerUsed;
	private boolean immune;
	
	private HeroPower power;
	
	public Hero(String name, TargetsType side, int HP, int maxHP, int Armour, int currentMana, int totalMana, Hand myHand, Deck myDeck, int overload, int fatigue, Weapon weapon) {
		this.name = name;
		this.side = side;
		this.HP = HP;
		this.maxHP = maxHP;
		this.armour = Armour;
		this.currentMana = currentMana;
		this.totalMana = totalMana;
		this.myHand = myHand;
		this.myDeck = myDeck;
		this.overload = overload;
		this.fatigue = fatigue;
		this.weapon = weapon;
		this.ready = true;
		this.powerUsed = false;
		this.immune = false;
	}

	public Hero(Hero h) {
		this.name = h.getName();
		this.side = h.getSide();
		this.HP = h.getHP();
		this.maxHP = h.getMaxHP();
		this.armour = h.getArmour();
		this.currentMana = h.getCurrentMana();
		this.totalMana = h.getTotalMana();
		this.myHand = h.getMyHand();
		this.myDeck = h.getMyDeck();
		this.overload = h.getOverload();
		this.fatigue = h.getFatigue();
		this.weapon = h.getWeapon();
		this.ready = h.isReady();
		this.powerUsed = h.getPowerUsed();
		this.power = h.getHeroPower();
		this.immune = h.isImmune();
	}
	
	public void setImmune(boolean immune) {
		this.immune = immune;
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}

	public int getTotalMana() {
		return totalMana;
	}

	public void setTotalMana(int totalMana) {
		this.totalMana = totalMana;
	}

	public Hand getMyHand() {
		return myHand;
	}
	
	public int getMyHandSize() {
		return myHand.getSize();
	}
	
	public MyTurnState drawCard(BoardState boardState, int pos) {
		return myDeck.drawCard(boardState, this, pos);
	}
	
	public MyTurnState drawCard(BoardState boardState) {
		return myDeck.drawCard(boardState, this);
	}

	public void setMyHand(Hand myHand) {
		this.myHand = myHand;
	}

	public Deck getMyDeck() {
		return myDeck;
	}

	public void setMyDeck(Deck myDeck) {
		this.myDeck = myDeck;
	}

	public int getOverload() {
		return overload;
	}

	public void setOverload(int overload) {
		this.overload = overload;
	}
	
	public int getAtk() {
		if (weapon.equals(null)) return 0;
		else return weapon.getAtk();
	}

	public Hero fresh() {
		return new Hero(this);
	}
	
	public MyTurnState damage(BoardState oldstate, int amount) {
		Hero hero = this.fresh();
		if (hero.getArmour()>=amount) hero.setArmour(hero.getArmour()-2);
		else {int additional = amount - hero.getArmour(); hero.setArmour(0); hero.setHP(hero.getHP()-additional);}
		if (side.equals(TargetsType.ALLYCHAR)) return new BoardState(oldstate.getViewType(),hero,oldstate.getEnemy(),oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
		else return new BoardState(oldstate.getViewType(),oldstate.getHero(),hero,oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
	}
	
	public MyTurnState heal(BoardState oldstate, int amount) {
		Hero hero = this.fresh();
		hero.setHP(Math.min(hero.getHP()+amount,30));
		
		if (side.equals(TargetsType.ALLYCHAR)) return new BoardState(oldstate.getViewType(),hero,oldstate.getEnemy(),oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
		else return new BoardState(oldstate.getViewType(),oldstate.getHero(),hero,oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
	}
	
	public BoardState useMana(BoardState oldstate, int amount) {
		Hero hero = this.fresh();
		hero.setCurrentMana(currentMana-amount);
		return new BoardState(oldstate.getViewType(),hero,oldstate.getEnemy(),oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
	}

	public boolean canAttack() {
		return (weapon!=null && ready && this.getWeapon().getDurability()>0);
	}

	public void setMyPos(TargetsType side) {
		this.side = side;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}
	
	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	public int getArmour() {
		return armour;
	}

	public void setArmour(int armour) {
		this.armour = armour;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public TargetsType getSide() {
		return side;
	}

	public void setSide(TargetsType side) {
		this.side = side;
	}
	
	public boolean getPowerUsed() {
		return powerUsed;
	}
	
	public void setPowerUsed(boolean b) {
		powerUsed = b;
	}

	public boolean isAttackable() {
		return true;
	}
	
	public HeroPower getHeroPower() {
		return power;
	}
	
	public void setHeroPower(HeroPower power) {
		this.power = power;
	} 
	
	public MyTurnState giveWeapon(BoardState oldstate, Weapon weapon) {
		Hero hero = this.fresh();
		Weapon newWeapon = new Weapon(weapon);
		newWeapon.setId(oldstate.getNextId());
		hero.setWeapon(weapon);
		
		if (side.equals(TargetsType.ALLYCHAR)) return  new BoardState(oldstate.getViewType(),hero,oldstate.getEnemy(),oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter()+1);
		else return new BoardState(oldstate.getViewType(),oldstate.getHero(),hero,oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter()+1);
	}
	
	//NEEDS CHANGED
	public MyTurnState equipWeapon(BoardState oldstate, Weapon weapon) {
		MyTurnState tempstate = new BoardState(oldstate.getViewType(),oldstate.getHero(),oldstate.getHero(),oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter()+1);
		tempstate = destroyWeapon(oldstate);
		
		Weapon newWeapon = new Weapon(weapon);
		newWeapon.setId(oldstate.getNextId());
		
		tempstate = tempstate.giveWeapon(this,newWeapon);
		
		return weapon.battleCry(tempstate);
	}
	
	public MyTurnState destroyWeapon(BoardState oldstate) {
		if (weapon==null) return oldstate;
		Hero hero = this.fresh();
		Weapon weapon = hero.getWeapon();
		hero.setWeapon(null);
		BoardState tempstate;
		if (side.equals(TargetsType.ALLYCHAR)) tempstate = new BoardState(oldstate.getViewType(),hero,oldstate.getEnemy(),oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
		else tempstate =  new BoardState(oldstate.getViewType(),oldstate.getHero(),hero,oldstate.getOppSide(),oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
		
		return weapon.deathRattle(tempstate,side);
		
	}
	
	public MyTurnState fatigue(BoardState oldstate) {
		//if (name!="") throw new Error("fat");
		System.out.println("Take fatigue damage: "+(fatigue+1));
		Hero newHero = this.fresh();
		newHero.setFatigue(fatigue+1);
		return newHero.damage(oldstate, fatigue);
	}
	
	@Override
	public boolean equals(Object that) {
		Hero other = (Hero)that;
		if (name != other.getName()) return false;
		if (HP != other.getHP()) return false;
		if (armour != other.getArmour()) return false;
		if (currentMana != other.getCurrentMana()) return false;
		if (totalMana != other.getTotalMana()) return false;
		if (overload != other.getOverload()) return false;
		if (weapon==null && other.getWeapon() != null) return false;
		if (weapon!= null && other.getWeapon() == null) return false;
		if (weapon==null && other.getWeapon() == null);
		else if (!weapon.equals(other.getWeapon())) return false;
		if (ready != other.isReady()) return false;
		return true;
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public MyTurnState playCard(BoardState oldstate, Character target) {
		return null;
	}

	@Override
	public CardType getType() {
		return CardType.HERO;
	}

	@Override
	public boolean isImmune() {
		return immune;
	}

	@Override
	public void playPrint(Character target) {
	}
	
	public String playOutput(Character target) {
		return "";
	}
	
}
