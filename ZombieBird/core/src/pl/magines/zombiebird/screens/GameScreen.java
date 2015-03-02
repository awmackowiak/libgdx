package pl.magines.zombiebird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import pl.magines.zombiebird.gameworld.GameRenderer;
import pl.magines.zombiebird.gameworld.GameWorld;
import pl.magines.zombiebird.zbHelpers.InputHandler;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    private float runTime = 0;

    public GameScreen() {
        Gdx.app.log("GameScreen", "Created");

        float screenWidth = Gdx.graphics.getWidth();
        Gdx.app.log("GameScreen Width", Float.toString(screenWidth));
        float screeHeight = Gdx.graphics.getHeight();
        Gdx.app.log("GameScreen Height", Float.toString(screeHeight));
        float gameWidth = 136;
        float gameHeight = screeHeight / (screenWidth / gameWidth);
        Gdx.app.log("GameScreen GameHeight", Float.toString(gameHeight));

        int minPointY = (int) (gameHeight / 2);

        world = new GameWorld(minPointY);
        renderer = new GameRenderer(world, (int) gameHeight, minPointY);

        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.app.log("GameScreen FPS", (int) (1/delta) + "");

        runTime += delta;
        world.update(delta);
        renderer.render(runTime);

    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "Hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resume called");
    }

    @Override
    public void dispose() {

    }
}
