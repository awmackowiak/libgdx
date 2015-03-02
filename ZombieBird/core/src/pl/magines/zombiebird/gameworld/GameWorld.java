package pl.magines.zombiebird.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import pl.magines.zombiebird.gameobjects.Bird;
import pl.magines.zombiebird.gameobjects.ScrollHandler;
import pl.magines.zombiebird.utils.Constants;
import pl.magines.zombiebird.zbHelpers.AssetLoader;

public class GameWorld {

//    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    private enum GameState {
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    private Bird bird;
    private ScrollHandler scroller;

    private Rectangle ground;
    private int score = 0;

    private GameState currentState;
    public int midPointY;

    public GameWorld(int midPointY) {
        currentState = GameState.READY;
        this.midPointY = midPointY;
        bird = new Bird(33, midPointY - 5, Constants.BIRDWIDTH, Constants.BIRDHEIGHT);
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public void update(float delta) {
        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }
    }

    public void updateReady(float delta) {

    }

    public void updateRunning(float delta) {

        if(delta > .15f){
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if(bird.isAlive && scroller.collides(bird)){
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if(Intersector.overlaps(bird.getCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;

            if(score > AssetLoader.getHighScore()){
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }

    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY -5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }


    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public int getScore() {
        return score;
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

}
