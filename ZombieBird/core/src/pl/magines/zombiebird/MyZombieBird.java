package pl.magines.zombiebird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import pl.magines.zombiebird.screens.GameScreen;
import pl.magines.zombiebird.zbHelpers.AssetLoader;

public class MyZombieBird extends Game {

	@Override
	public void create () {
        Gdx.app.log("ZBGame", "Created");
        AssetLoader.load();
        setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
