package pl.magines.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainScreen implements Screen {

    final static float BUTTONWIDTH = 300f;
    final static float BUTTONHEIGHT = 70f;
    final static float BUTTONPAD = 10f;

    private OrthographicCamera camera;

    private Stage stage;

    private Table table;
    private Skin skin;

    private Label name;
    private TextButton startButton, optionButton, highScoreButton;

    public MainScreen() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        name = new Label("Super New Game", skin);

        startButton = new TextButton("Play", skin);
        optionButton = new TextButton("Option", skin);
        highScoreButton = new TextButton("High Score", skin);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setCatchBackKey(true);

        if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
            Gdx.app.exit();
        }

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        table = new Table();
        table.setFillParent(true);
        table.add(name);
        table.row();
        table.add(startButton).width(BUTTONWIDTH).height(BUTTONHEIGHT).pad(BUTTONPAD);
        table.row();
        table.add(optionButton).width(BUTTONWIDTH).height(BUTTONHEIGHT).pad(BUTTONPAD);
        table.row();
        table.add(highScoreButton).width(BUTTONWIDTH).height(BUTTONHEIGHT).pad(BUTTONPAD);


        startButton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Down");
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("UP" + event.getTarget());
                ((Game) Gdx.app.getApplicationListener()).setScreen(new LevelScreen());
            }
        });

        optionButton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Down");
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("UP");
                ((Game) Gdx.app.getApplicationListener()).setScreen(new OptionMenu());
            }
        });

        highScoreButton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Down");
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("UP");
                ((Game) Gdx.app.getApplicationListener()).setScreen(new HighScore());
            }
        });

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
