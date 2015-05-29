package gnomeagility.util;

import java.lang.reflect.Method;

import org.rev317.min.Loader;
 
public class Reflection {
	public static void dcClient() {
		try {
			Method dropClient = Loader.getClient().getClass()
					.getDeclaredMethod("V");
			dropClient.setAccessible(true);
			dropClient.invoke(Loader.getClient());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
