package pl.magines.zombiebird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.magines.zombiebird.MyZombieBird;
import pl.magines.zombiebird.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = Constants.GAMETITLE;
        config.width = Constants.GAMEWIDTH;
        config.height = Constants.GANEHEIGHT;
		new LwjglApplication(new MyZombieBird(), config);
	}
}
