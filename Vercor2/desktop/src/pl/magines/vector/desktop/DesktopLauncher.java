package pl.magines.vector.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.magines.vector.MyVector;
import pl.magines.vector.utils.Constans;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = Constans.APP_WIDTH;
        config.height = Constans.APP_HEIGHT;
		new LwjglApplication(new MyVector(), config);
	}
}
