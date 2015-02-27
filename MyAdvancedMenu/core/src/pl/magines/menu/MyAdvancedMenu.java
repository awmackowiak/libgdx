package pl.magines.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyAdvancedMenu extends Game {

    public void create() {
        Gdx.input.setCatchBackKey(true);
        this.setScreen(new MainScreen());

    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
    }
}
