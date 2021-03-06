package Search;

import java.util.Set;
import Game.Actions.EndTurn;

public class RandomPlayout implements Search {

	@Override
	public Node solution(State initialConfig, GoalTest goalTest,int step) {
		State currentState = initialConfig;
		Node currentNode = new Node(null,null,currentState);
		
		if (currentState.getApplicableActions(true).isEmpty()) throw new Error("empty");
		while (!currentState.getApplicableActions(true).isEmpty()) {
			Action action = takeRandom(currentState.getApplicableActions(true));
			if (action==null) throw new Error("no");
			
			currentState = currentState.getActionResult(action);
			currentNode = new Node(new Node(currentNode),action,currentState);
			if (currentState.isGameWon()) return currentNode;
		}
		return currentNode;
	}

	public Action takeRandom(Set<Action> set) {
		double number = Math.random();
		Action backup = new EndTurn();
		for (Action action : set) {
			if (action!=null) {
				if (number > 1.0/set.size()) {
					number -= 1.0/set.size();
				}
				else return action;
			}
		}
		return backup;
	}

}
