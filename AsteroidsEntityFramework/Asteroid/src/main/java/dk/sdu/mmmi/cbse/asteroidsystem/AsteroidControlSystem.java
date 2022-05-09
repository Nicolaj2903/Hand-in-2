package dk.sdu.mmmi.cbse.asteroidsystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {

    private int numPoints;
    private float[] dists;
    int width;
    int height;
    float speed;
    float radians;
    float rotationSpeed;

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            updateShape(asteroid);
        }

    }

    private void updateShape(Entity entity) {

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();



        PositionPart positionPart = entity.getPart(PositionPart.class);
        MovingPart movingPart = entity.getPart(MovingPart.class);

        numPoints = 8;


        float[] shapex = new float[numPoints];
        float[] shapey = new float[numPoints];

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);


        width = height = 20;
        speed = MathUtils.random(20,30);
        positionPart.setRadians(MathUtils.random(2 * 3.1415f));
        movingPart.setRotationSpeed(MathUtils.random(-1, 1));
        rotationSpeed = movingPart.getRotationSpeed();
        radians = positionPart.getRadians();
        float x = positionPart.getX();
        float y = positionPart.getY();


        movingPart.setDx(MathUtils.cos(radians) * speed);
        movingPart.setDy(MathUtils.sin(radians) * speed);

        dists = new float[numPoints];
        int radius = width /2;

        for (int i = 0; i < numPoints; i++) {
            dists[i] = MathUtils.random(radius / 2, radius);
        }


        float angle = 0;
        for (int i = 0; i < numPoints; i++) {
            shapex[i] = x + MathUtils.cos(angle + radians) * dists[i];
            shapey[i] = y + MathUtils.sin(angle + radians) * dists[i];
            angle += 2 * 3.1415f / numPoints;
        }

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);

    }
}

//
//public class AsteroidControlSystem implements IEntityProcessingService {
//
//    private float[] dists;
//    private float angle = 0;
//
//
//    @Override
//    public void process(GameData gameData, World world) {
//
//        for (Entity asteroid : world.getEntities(Asteroid.class)) {
//            PositionPart positionPart = asteroid.getPart(PositionPart.class);
//            MovingPart movingPart = asteroid.getPart(MovingPart.class);
//
//            movingPart.process(gameData, asteroid);
//            positionPart.process(gameData, asteroid);
//
//            updateShape(asteroid);
//        }
//    }
//
//    private void updateShape(Entity entity) {
//
//        float[] shapex = new float[8];
//        float[] shapey = new float[8];
//
//        entity.setShapeX(shapex);
//        entity.setShapeY(shapey);
//
//
//        shapex = entity.getShapeX();
//        shapey = entity.getShapeY();
//        PositionPart positionPart = entity.getPart(PositionPart.class);
//        MovingPart movingPart = entity.getPart(MovingPart.class);
//        float x = positionPart.getX();
//        float y = positionPart.getY();
//        float radians;
//        radians = MathUtils.random(2 * 3.1415f);
//        int radius = Gdx.graphics.getWidth();
//        movingPart.setDx(MathUtils.cos(radians) * MathUtils.random(20, 30));
//        movingPart.setDy(MathUtils.sin(radians) * MathUtils.random(20, 30));
//        dists = new float[8];
//        for (int i = 0; i < 7; i++) {
//            dists[i] = MathUtils.random(radius / 2, radius);
//        }
//        for (int i = 0; i < 8; i++) {
//            shapex[i] = x + MathUtils.cos(angle + radians) * 20;
//            shapey[i] = y + MathUtils.sin(angle + radians) * 20;
//            angle += 2 * 3.1415f / 8;
//        }
//
//
//
//        entity.setShapeX(shapex);
//        entity.setShapeY(shapey);
//
//
//
//    }
//}
