package gnomeagility.strategies;

import gnomeagility.data.Variables;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Menu;

public class TeleToCourse implements Strategy {

	@Override
	public boolean activate() {

		return !Variables.isAtCourse() && Variables.isLoggedIn();
	}

	@Override
	public void execute() {
		if (Game.getOpenBackDialogId() != 2492) {
			Menu.sendAction(315, 1303, 0, 1541);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenBackDialogId() == 2492;
				}
			}, 3000);
		} else if (Game.getOpenBackDialogId() == 2492) {
			Menu.sendAction(315, 37453824, 329, 2498);
			Time.sleep(1500);
			Menu.sendAction(315, 507, 0, 2496);
			Time.sleep(1500);
			Menu.sendAction(315, 1569, 247, 2494);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Variables.isAtCourse();
				}
			}, 3000);
		}
	}
}
