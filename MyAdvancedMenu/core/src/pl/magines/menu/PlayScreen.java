package pl.magines.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PlayScreen implements Screen {

    private Stage stage;
    private Table table;
    private int level;

    private Hero hero;

    public PlayScreen(int level) {
        this.level = level;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setCatchBackKey(true);

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            ((Game) Gdx.app.getApplicationListener()).setScreen(new LevelScreen());
        }

        table.debug();

        stage.act(delta);
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

        hero = new Hero();

        Table skills = new Table();
        for(int i = 0; i < 4; i++) {
            skills.add(
                    new TextButton(Integer.toString(i),
                    new Skin(Gdx.files.internal("uiskin.json")
                    ))).height(100f).width(100f);
        }
        table = new Table();
        table.setFillParent(true);
        table.setBounds(10,10,10,10);
        table.add().colspan(4).expand();
        table.row();
        table.add(
                new TextButton("<=", new Skin(Gdx.files.internal("uiskin.json"))),
                new TextButton("=>", new Skin(Gdx.files.internal("uiskin.json")))
        );
        table.add(skills);
        table.add(new TextButton("JUMP", new Skin(Gdx.files.internal("uiskin.json")))).size(100,100);

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
