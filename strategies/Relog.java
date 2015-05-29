package gnomeagility.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;

import com.sun.glass.events.KeyEvent;

public class Relog implements Strategy {

	@Override
	public boolean activate() {
		return !Game.isLoggedIn();
	}

	@Override
	public void execute() {
		Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Game.isLoggedIn();
			}
		}, 3000);

	}

}
