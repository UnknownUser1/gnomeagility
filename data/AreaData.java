package gnomeagility.data;

import org.parabot.environment.api.utils.Time;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.SceneObjects.Option;
import org.rev317.min.api.wrappers.Area;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

public class AreaData {

	public final static Area LOG_BALANCE = new Area(new Tile(2471, 3435, 0),
			new Tile(2471, 3440, 0), new Tile(2477, 3440, 0), new Tile(2477,
					3435, 0));
	public final static Area BALANCE_ROPE = new Area(new Tile(2472, 3418, 2),
			new Tile(2472, 3421, 2), new Tile(2477, 3421, 2), new Tile(2477,
					3420, 2));

	public static int groundID() {

		if (LOG_BALANCE.contains(Players.getMyPlayer().getLocation())) {
			return 2295;

		} else if (BALANCE_ROPE.contains(Players.getMyPlayer().getLocation())) {
			return 2312;
		}
		return 0;
	}

	public static void objInteract() {
		for (SceneObject s : SceneObjects.getAllSceneObjects()) {
			if (s != null) {
				if (s.getId() == AreaData.groundID()) {
					s.interact(Option.FIRST);
					Time.sleep(1000);
					return;
				}
			}
		}
	}
}
