package pl.magines.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.Iterator;

public class LevelScreen implements Screen {

    private Stage stage;
    private ArrayList<TextButton> button = new ArrayList();
    private Table table;
    private Skin skin;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setCatchBackKey(true);

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new MainScreen());
        }

        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        table = new Table();
        table.setFillParent(true);

        for(int i=0; i<12; i++) {
            button.add(new TextButton("B" + i, skin));
        }
        Iterator<TextButton> iter = button.iterator();
        int i = 0;
        while (iter.hasNext()) {
            table.add(iter.next()).width(50f).height(50f).pad(10f);
            i++;
            if(i % 4 == 0) {
                table.row();
            }
            iter.remove();
        }

        stage.addActor(table);

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
