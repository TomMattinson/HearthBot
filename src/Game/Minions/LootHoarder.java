package Game.Minions;

import Game.Deathrattles.LootHoarderDR;

public class LootHoarder extends Minion {
	public LootHoarder() {
		super("Loot Hoarder",1,2,1);
		addDeathrattle(new LootHoarderDR());
	}
	
	public LootHoarder(Minion m) {
		super(m);
	}
}
