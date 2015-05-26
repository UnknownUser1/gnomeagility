package gnomeagility.data;

import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.SceneObjects;

public class Variables {
	public static boolean isLoggedIn() {
		return Game.isLoggedIn();
	}

	public static boolean isAtCourse() {
		return SceneObjects.getNearest(2285, 2313, 2314).length > 0;
	}
}
