package pl.magines.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;

public class Hero extends Actor {

    private Texture hero;

    private Vector2 vector;

    private float heroX = 0f;
    private float heroY = 0f;

    public Hero() {
        hero = new Texture("badlogic.jpg");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(hero, getHeroX(), getHeroY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public Texture getHero() {
        return hero;
    }

    public void setHero(Texture hero) {
        this.hero = hero;
    }

    public float getHeroX() {
        return heroX;
    }

    public void setHeroX(float heroX) {
        this.heroX = heroX;
    }

    public float getHeroY() {
        return heroY;
    }

    public void setHeroY(float heroY) {
        this.heroY = heroY;
    }
}
