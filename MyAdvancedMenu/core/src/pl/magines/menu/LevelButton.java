package pl.magines.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class LevelButton {

    private TextButton button;
    private Table table;

    private int stars;

    private int level;

    public LevelButton(int level) {
        this.level = level;
    }

    public TextButton createButton() {
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        skin.add("top", skin.newDrawable("default-round", Color.RED), Drawable.class);
        skin.add("star-filled", skin.newDrawable("white", Color.YELLOW), Drawable.class);
        skin.add("star-unfilled", skin.newDrawable("white", Color.GRAY), Drawable.class);

        Label label = new Label(Integer.toString(level), skin);
        label.setFontScale(1.5f);
        label.setAlignment(Align.center);

        button = new TextButton("", skin);
        button.stack(new Image(skin.getDrawable("top")), label).width(100f).height(100f).fill(true);
        button.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Down");
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("UP");
                ((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen(level));
            }
        });
        stars = MathUtils.random(-1, +3);
        Table starTable = new Table();
        starTable.defaults();
        if (stars >= 0) {
            for (int star = 0; star < 3; star++) {
                if (stars > star) {
                    starTable.add(new Image(skin.getDrawable("star-filled"))).width(20).height(20);
                } else {
                    starTable.add(new Image(skin.getDrawable("star-unfilled"))).width(20).height(20);
                }
            }
        }

        button.row();
        button.add(starTable).height(30);
        return button;
    }



}
