package Game;

import java.util.ArrayList;

import Game.Battlecrys.Battlecry;
import Game.Buffs.Buff;
import Game.Deathrattles.Deathrattle;
import Game.Heroes.Hero;
import Game.Inspires.Inspire;
import Game.Minions.Minion;
import Game.Weapons.Weapon;
import Search.State;

public interface MyTurnState extends State {
	
	MyTurnState resolveRNG();
	
	boolean isTurnEnded();
	void setTurnEnded(boolean b);
	
	MyTurnState damageRandomHittable(TargetsType targets, int amount);
	
	MyTurnState drawCard();
	MyTurnState enemyDrawCard();
	
	MyTurnState placeMinion(Minion minion);
	MyTurnState performBC(Battlecry battlecry, PlayableCard card);
	MyTurnState performDR(Deathrattle deathrattle, PlayableCard card);
	MyTurnState performInspire(Inspire inspire, PlayableCard card);
	MyTurnState changeHeroWeaponAtkDurability(int id, int amountAtk, int amountDurability);
	MyTurnState changeEnemyWeaponAtkDurability(int id, int amountAtk, int amountDurability);
	MyTurnState giveWeapon(Hero hero, Weapon weapon);
	MyTurnState equipHeroWeapon(Weapon weapon);
	MyTurnState equipEnemyWeapon(Weapon weapon);
	MyTurnState applyAuras(Minion minion);
	MyTurnState removeAuras(Minion minion);
	MyTurnState doSummonEffects(Minion minion);
	MyTurnState doDeathEffects(Minion minion);
	MyTurnState applyBuff(int minionID, Buff buff);
	MyTurnState removeBuff(int minionID, int id);
	
	MyTurnState simultaneousHeal(TargetsType enemyminions, int i, ArrayList<Minion> arrayList);
	
	MyTurnState doStartTurnEffects(Hero hero);
	MyTurnState doEndTurnEffects(Hero hero);

	MyTurnState viewBiased();

	MyTurnState drawCard(int pos);

	MyTurnState damage(Character defender, int atk);

	MyTurnState heroAttack(int id, Hero defender);
	MyTurnState heroAttack(int id, Minion defender);

	MyTurnState removeTempEffects();

}
