package gnomeagility.core;

import gnomeagility.data.Variables;
import gnomeagility.strategies.CompleteCourse;
import gnomeagility.strategies.Relog;
import gnomeagility.strategies.TeleToCourse;
import gnomeagility.util.*;

import java.util.ArrayList;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;

@ScriptManifest(author = "UnknownHype", category = Category.AGILITY, description = "Completes Gnome Agility Course", name = "UAgility - Gnome", servers = { "Ikov" }, version = 1)
public class Main extends Script implements MessageListener {

	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	private static int LAPS_DONE;

	public boolean onExecute() {
		strategies.add(new Relog());
		strategies.add(new TeleToCourse());
		strategies.add(new CompleteCourse());

		provide(strategies);

		return true;
	}

	public void onFinish() {
		System.out.println("Scriped Ended, Thanks for using!");
		System.out.println("You Completed " + LAPS_DONE + " Laps!");
	}

	public void messageReceived(MessageEvent m) {
		if (m.getMessage().contains("you've completed")) {
			LAPS_DONE += 1;
			System.out.println("You now have done " + LAPS_DONE + " Laps!");
		} else if (m.getMessage().contains("object does not exist,")
				|| (m.getMessage().contains("unable to receive input"))) {
			Reflection.dcClient();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return !Variables.isLoggedIn();
				}
			}, 3000);

		}
	}
}
