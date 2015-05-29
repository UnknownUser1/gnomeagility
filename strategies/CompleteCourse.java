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
							.equals(Constants.afterLog);
				}
			}, 3000);
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.afterLog)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[2].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.afterNet);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.afterNet)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.afterTree);
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
							.equals(Constants.afterBalanceRope);
				}
			}, 3000);
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.afterBalanceRope)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.afterDownTree);
					}
				}, 3000);
			}

		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.afterDownTree)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[0].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.afterSecondNet);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.afterSecondNet)) {
			if (gnomeObjects.length > 0 && gnomeObjects != null) {
				gnomeObjects[6].interact(Option.FIRST);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation()
								.equals(Constants.afterPipe);
					}
				}, 3000);
			}
		} else if (Players.getMyPlayer().getLocation()
				.equals(Constants.afterPipe)) {
			Constants.backToStart.walkTo();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation()
							.equals(Constants.backToStart);
				}
			}, 3000);
		}
	}
}
