package Game.Minions;

import Game.Battlecrys.NightbladeBC;

public class Nightblade extends Minion {

	public Nightblade() {
		super("Nightblade",5,4,4);
		battlecrys.add(new NightbladeBC());
	}
	
	public Nightblade(Minion m) {
		super(m);
	}
	
}