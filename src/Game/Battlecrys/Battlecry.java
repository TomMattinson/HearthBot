package Game.Battlecrys;

import Game.BoardState;
import Game.Minions.Minion;
import Search.State;

public abstract class Battlecry {
	public abstract State perform(Minion minion, BoardState oldstate);
}