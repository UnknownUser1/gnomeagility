package gnomeagility.strategies;

import gnomeagility.data.AreaData;
import gnomeagility.data.Variables;
import gnomeagility.data.Constants;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.SceneObjects.Option;
import org.rev317.min.api.wrappers.SceneObject;

public class CompleteCourse implements Strategy {
	@Override
	public boolean activate() {
		return Game.isLoggedIn() && Players.getMyPlayer().getAnimation() == -1
				&& Variables.isAtCourse();
	}

	@Override
	public void execute() {
		SceneObject[] gnomeObjects = SceneObjects.getNearest(2285, 2313, 2314,
				2286, 154);

		if (AreaData.LOG_BALANCE.contains(Players.getMyPlayer().getLocation())) {
			AreaData.objInteract();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation()
							.equals(Constants.AFTER_LOG);
				}
			}, 3000);
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.AFTER_LOG)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[2].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.AFTER_NET);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.AFTER_NET)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.AFTER_TREE);
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
							.equals(Constants.AFTER_BALANCE_ROPE);
				}
			}, 3000);
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.AFTER_BALANCE_ROPE)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.AFTER_DOWN_TREE);
					}
				}, 3000);
			}

		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.AFTER_DOWN_TREE)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.AFTER_SECOND_NET);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.AFTER_SECOND_NET)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[6].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.AFTER_PIPE);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.AFTER_PIPE)) {
			Constants.BACK_TO_START.walkTo();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation()
							.equals(Constants.BACK_TO_START);
				}
			}, 3000);
		}
	}
}
