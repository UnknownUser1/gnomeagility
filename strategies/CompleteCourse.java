package gnomeagility.strategies;

import gnomeagility.data.AreaData;
import gnomeagility.data.Variables;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.SceneObjects.Option;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

public class CompleteCourse implements Strategy {
	Tile AFTER_LOG = new Tile(2474, 3429);
	Tile AFTER_NET = new Tile(2474, 3424);
	Tile AFTER_TREE = new Tile(2473, 3420);
	Tile TO_ROPE = new Tile(2477, 3420);
	Tile AFTER_BALANCE_ROPE = new Tile(2483, 3420);
	Tile AFTER_DOWN_TREE = new Tile(2485, 3419);
	Tile AFTER_SECOND_NET = new Tile(2484, 3427);
	Tile AFTER_PIPE = new Tile(2484, 3437);
	Tile BACK_TO_START = new Tile(2474, 3436);

	@Override
	public boolean activate() {
		return Variables.isLoggedIn()
				&& Players.getMyPlayer().getAnimation() == -1
				&& Variables.isAtCourse();
	}

	@Override
	public void execute() {
		SceneObject[] atNet = SceneObjects.getNearest(2285);
		SceneObject[] atTree = SceneObjects.getNearest(2313);
		SceneObject[] downTree = SceneObjects.getNearest(2314);
		SceneObject[] toNet = SceneObjects.getNearest(2286);
		SceneObject[] toPipe = SceneObjects.getNearest(154);
		if (AreaData.LOG_BALANCE.contains(Players.getMyPlayer().getLocation())) {
			AreaData.objInteract();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation()
							.equals(AFTER_LOG);
				}
			}, 3000);
		} else if (Players.getMyPlayer().getLocation().equals(AFTER_LOG)) {
			if (atNet.length > 0 && atNet != null) {
				atNet[0].interact(Option.FIRST);
				;
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(AFTER_NET);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation().equals(AFTER_NET)) {
			if (atTree.length > 0 && atTree != null) {
				atTree[0].interact(Option.FIRST);
				;
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(AFTER_TREE);
					}
				}, 3000);
			}
		} else if (AreaData.BALANCE_ROPE.contains(Players.getMyPlayer()
				.getLocation())) {
			AreaData.objInteract();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation()
							.equals(AFTER_BALANCE_ROPE);
				}
			}, 3000);
		} else if (Players.getMyPlayer().getLocation()
				.equals(AFTER_BALANCE_ROPE)) {
			if (downTree.length > 0 && downTree != null) {
				downTree[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(AFTER_DOWN_TREE);
					}
				}, 3000);
			}

		} else if (Players.getMyPlayer().getLocation().equals(AFTER_DOWN_TREE)) {
			if (toNet.length > 0 && toNet != null) {
				toNet[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(AFTER_SECOND_NET);
					}
				}, 3000);
			}

		} else if (Players.getMyPlayer().getLocation().equals(AFTER_SECOND_NET)) {
			if (toPipe.length > 0 && toPipe != null) {
				toPipe[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(AFTER_PIPE);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation().equals(AFTER_PIPE)) {
			BACK_TO_START.walkTo();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation()
							.equals(BACK_TO_START);
				}
			}, 3000);
		}
	}
}
