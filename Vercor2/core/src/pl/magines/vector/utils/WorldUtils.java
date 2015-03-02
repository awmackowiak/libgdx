package pl.magines.vector.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class WorldUtils {

    public static World createWorld() {
        return new World(Constans.WORLD_GRAVITY, true);
    }

    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constans.GROUND_X, Constans.GROUND_Y));
        Body body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(Constans.GROUND_WIDTH / 2, Constans.GROUND_HEIGHT / 2);
        body.createFixture(polygonShape, Constans.GROUND_DENSITY);
        polygonShape.dispose();
        return body;
    }

}
