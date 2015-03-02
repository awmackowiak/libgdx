package pl.magines.vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import pl.magines.vector.stages.GameStage;

public class GameScreen implements Screen {

    private GameStage stage;

    @Override
    public void render(float delta) {
//        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        stage = new GameStage();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
