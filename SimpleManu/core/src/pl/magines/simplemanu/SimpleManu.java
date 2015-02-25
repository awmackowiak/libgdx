package pl.magines.simplemanu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.Shape;

/**
 * Stage and viewport means a camera and controls(stage -> InputProcessor) how to display on screen
 */

public class SimpleManu extends ApplicationAdapter {

    private Stage stage;
    private Table table;
    //For debug drawing
    private ShapeRenderer shapeRenderer;

    //Skin
    private Skin skin;
	
	@Override
	public void create () {
        /**
         * Setup stage and inputProcessor on this stage
         */
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        //Add new skin
        skin = new Skin();
        skin.add("badlogic", new Texture("badlogic.jpg"));
        Texture badlogic = skin.get("badlogic", Texture.class);

        table = new Table();
        table.setFillParent(true);

        TextButton textButton = new TextButton("Button1", skin);
        table.add(textButton);

        stage.addActor(table);

        shapeRenderer = new ShapeRenderer();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(10, 10 , 100, 100);
        shapeRenderer.end();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        table.drawDebug(shapeRenderer);
//        table.setDebug(true);

	}

    /**
     * Setup camera position, true means "centerCamera" to true
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    /**
     * Dispose all graphic
     */
    @Override
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();
    }
}
