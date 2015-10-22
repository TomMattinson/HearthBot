package Game.Auras;

import Game.MyTurnState;
import Game.Buffs.AdditiveBuff;
import Game.Minions.Minion;

public class LeokkAura extends Aura {
	
	private double id;

	public LeokkAura() {
		id = Math.random();
	}

	@Override
	public MyTurnState apply(MyTurnState oldstate, Minion source, Minion target) {
		if ((source.getMyPos()<7 && target.getMyPos()<7) || (source.getMyPos()>=7 && target.getMyPos()>=7)) return oldstate.applyBuff(target.getId(),new AdditiveBuff(id,1,0,0));
		else return oldstate;
	}

}
