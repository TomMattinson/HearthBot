package Game.Heroes.HeroPowers;

import Game.BoardState;
import Game.MyTurnState;
import Game.Heroes.Hero;

public class HunterPower extends HeroPower {

	private int manacost = 2;
	private int damage = 2;
	
	public int getCost() {
		return manacost;
	}
	
	public boolean useable(BoardState oldstate) {
		return ((oldstate.getHero()).getCurrentMana() >= manacost);
	}

	@Override
	public MyTurnState result(BoardState oldstate) {
		Hero hero = (oldstate.getHero()).fresh();
		hero.setPowerUsed(true);
		hero.setCurrentMana(hero.getCurrentMana()-manacost);
		
		BoardState tempstate = new BoardState(oldstate.getViewType(), hero, oldstate.getEnemy(),oldstate.getOppSide(), oldstate.getMySide(),oldstate.getIdsInPlayOrder(),oldstate.getEnemyHandSize(),oldstate.isTurnEnded(),oldstate.getIdCounter());
	
		return (tempstate.getEnemy()).damage(tempstate, damage);
	}

	@Override
	public void print() {
		System.out.println("Rexxar uses hero power");

	}
	
	@Override
	public String output() {
		return ("Rexxar uses hero power");

	}

}
