package gnomeagility.strategies;

import gnomeagility.data.Variables;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;

import com.sun.glass.events.KeyEvent;

public class Relog implements Strategy {

	@Override
	public boolean activate() {
		return !Variables.isLoggedIn();
	}

	@Override
	public void execute() {
		Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Variables.isLoggedIn();
			}
		}, 3000);

	}

}
