package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Game.BoardState;
import Game.Card;
import Game.Deck;
import Game.GameGoalTest;
import Game.GamePrinting;
import Game.Hand;
import Game.MulliganState;
import Game.MyTurnState;
import Game.ViewType;
import Game.Minions.AbusiveSergeant;
import Game.Minions.AcidicSwampOoze;
import Game.Minions.ArgentSquire;
import Game.Minions.GrimscaleOracle;
import Game.Minions.KnifeJuggler;
import Game.Minions.LeperGnome;
import Game.Minions.LootHoarder;
import Game.Minions.Murloc;
import Game.Minions.MurlocTidecaller;
import Game.Minions.MurlocWarleader;
import Game.Minions.ShieldedMinibot;
import Game.Minions.SouthseaDeckhand;
import Game.Minions.Wisp;
import Game.Minions.Wolfrider;
import Game.Actions.PlayCard;
import Game.Actions.SwapCards;
import Game.Cards.Spells.TargettedSpell.BlessingOfMight;
import Game.Cards.Spells.TargettedSpell.Fireball;
import Game.Cards.Spells.TargettedSpell.HammerOfWrath;
import Game.Cards.Spells.Untargetted.AvengingWrath;
import Game.Cards.Spells.Untargetted.Consecration;
import Game.Cards.Spells.Untargetted.DivineFavour;
import Game.Cards.Spells.Untargetted.Equality;
import Game.Cards.Spells.Untargetted.MusterForBattle;
import Game.Cards.Spells.Untargetted.TheCoin;
import Game.Heroes.Hero;
import Game.Heroes.Uther;
import Game.Minions.Minion;
import Game.SummonEffects.KnifeJugglerSE;
import Game.SummonEffects.SummonEffect;
import Game.SummonEffects.SwordOfJusticeSE;
import Game.Weapons.FieryWarAxe;
import Game.Weapons.SwordOfJustice;
import Game.Weapons.TruesilverChampion;
import GameSearch.GameHeuristic;
import Search.AStarFunction;
import Search.BestFirstFrontier;
import Search.Frontier;
import Search.GraphSearch;
import Search.Node;
import Search.Search;
import Search.State;

public class Test {

	public static void main(String[] args) {
		GamePrinting Printer = new GamePrinting();
		GameGoalTest goalTest = new GameGoalTest();
		
		Frontier frontier = new BestFirstFrontier(new AStarFunction(new GameHeuristic()));
		
		Search search = new GraphSearch(frontier);
		
		//initOpp.add(new LootHoarder(7));
		//initMy.add(new MurlocTidecaller(0));
		
		//positionsInPlayOrder.add(7);
		//positionsInPlayOrder.add(0);
		
		//initMy.get(0).setReady(true);
	//	initMy[1].setReady(true);
	//	initMy[2].setReady(true);
	//	initMy[3].setReady(true);
	//	initMy[4].setReady(true);
	//	initMy[5].setReady(true);
	//  initMy[6].setReady(true);
		
	//	myHand.add(new ArgentSquire());
	//	myHand.add(new Equality());
	//	myHand.add(new AbusiveSergeant());
	//	myHand.add(new DivineFavour());
	//	myHand.add(new TheCoin());
	//	myHand.add(new MurlocTidehunter());
	//	myHand.add(new MurlocScout());
	//	myHand.add(new MurlocWarleader());
	//	myHand.add(new Murloc());
	//	myHand.add(new GrimscaleOracle());
		
		//int startmana = 10;
		Deck myDeck = new Deck();
		myDeck = myDeck.add(new BlessingOfMight(),2);
		myDeck = myDeck.add(new Equality(),2);
		myDeck = myDeck.add(new ShieldedMinibot(),2);
		myDeck = myDeck.add(new SwordOfJustice(),1);
		myDeck = myDeck.add(new DivineFavour(),2);
		myDeck = myDeck.add(new MusterForBattle(),2);
		myDeck = myDeck.add(new TruesilverChampion(),2);
		myDeck = myDeck.add(new Consecration(),2);
		myDeck = myDeck.add(new HammerOfWrath(),2);
		myDeck = myDeck.add(new AvengingWrath(),1);
		myDeck = myDeck.add(new AbusiveSergeant(),2);
		myDeck = myDeck.add(new ArgentSquire(),2);
		myDeck = myDeck.add(new LeperGnome(),2);
		myDeck = myDeck.add(new SouthseaDeckhand(),2);
		myDeck = myDeck.add(new KnifeJuggler(),2);
		myDeck = myDeck.add(new LootHoarder(),1);
		myDeck = myDeck.add(new Wolfrider(), 1);
		
		Hero hero1 = new Uther("Uther",14,30,30,0,1,1,new Hand(), myDeck, 0, 0, null);
		Hero hero2 = new Uther("Uther2",15,30,30,0,1,1,new Hand(), myDeck, 0, 0, null);
		
		MyTurnState config = new BoardState(ViewType.UNBIASED,hero1,hero2,new ArrayList<Minion>(),new ArrayList<Minion>(),new ArrayList<Integer>(),0);
		
	/*	config = config.drawCard();
		config = config.drawCard();
		config = config.drawCard();
		config = config.drawCard();
		config = config.resolveRNG();
		config.print();
		
		//config = config.getActionResult(new PlayCard(new KnifeJuggler(),hero1,0));
		//config = config.getActionResult(new PlayCard(new ShieldedMinibot(),hero1,0));##
		//config = config.resolveRNG();
		
		State config2 = new MulliganState((BoardState) config);
		
		Set<Integer> tempset = new HashSet<Integer>();
		tempset.add(1);
		tempset.add(3);
		
		config2 = config2.getActionResult(new SwapCards(tempset, 0));
		config2 = ((MyTurnState) config2).resolveRNG();
		
		config2.print();*/
		
		
		Player player1 = new Player(hero1);
		Player player2 = new Player(hero2);
		
		PlayGame simulation = new PlayGame(player1,player2);
		
		if (simulation.play()==1) System.out.println("Player 1 wins");
		else System.out.println("Player 2 wins");
		
		/*System.out.println("A Star graph search on game");
		System.out.println();
		
		Node solution1 = search.solution(config, goalTest,1);
		Printer.printSolution(solution1);
		System.out.println("Total Nodes: "+(search.lastSearch()));
		System.out.println("Max Nodes: "+(frontier).maxNodes());*/
		
		
	
	}
}
