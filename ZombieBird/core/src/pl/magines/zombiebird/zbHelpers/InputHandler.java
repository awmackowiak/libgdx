package pl.magines.zombiebird.zbHelpers;

import com.badlogic.gdx.InputProcessor;

import pl.magines.zombiebird.gameobjects.Bird;
import pl.magines.zombiebird.gameworld.GameWorld;

public class InputHandler implements InputProcessor {

    private GameWorld myGame;
    private Bird myBird;

    public InputHandler(GameWorld myGame) {
        this.myGame = myGame;
        this.myBird = myGame.getBird();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(myGame.isReady()){
            myGame.start();
        }
        myBird.onClick();
        if(myGame.isGameOver() || myGame.isHighScore()) {
            myGame.restart();
        }

        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
