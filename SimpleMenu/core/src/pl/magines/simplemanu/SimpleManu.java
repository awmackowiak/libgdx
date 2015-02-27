package pl.magines.simplemanu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Stage and viewport means a camera and controls(stage -> InputProcessor) how to display on screen
 */

public class SimpleManu extends ApplicationAdapter {

    private Stage stage;
    private Table table;

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
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        Label label = new Label("Welcome !!", skin);
        TextField textField = new TextField("", skin);
        Label addressLabel = new Label("Address", skin);
        TextField addressField = new TextField("", skin);
        TextButton button = new TextButton("Button1", skin);
        TextButton button2 = new TextButton("Button2", skin);

        table = new Table();
        table.setFillParent(true);
        table.add(label);
        table.add(textField);
        table.row();
        table.add(addressLabel);
        table.add(addressField);
        table.row();
        table.add(button).width(200f).height(50f);
        table.add(button2).width(200f).height(50f);

        stage.addActor(table);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        table.setDebug(true);

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
    }
}
