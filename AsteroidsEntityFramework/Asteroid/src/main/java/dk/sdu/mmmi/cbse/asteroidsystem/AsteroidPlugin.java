package dk.sdu.mmmi.cbse.asteroidsystem;

import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    private Entity createAsteroid(GameData gameData){

        Entity asteroid = new Asteroid();



        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2 + MathUtils.random(-50,150);
        float y = gameData.getDisplayHeight() / 2 + MathUtils.random(-50,150);
        float radians = 2 * 3.1415f;


        float[] color = {1,1,1,1};


        asteroid.setColor(color);
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroid.add(new PositionPart(x, y, radians));

        return asteroid;

    }

    @Override
    public void start(GameData gameData, World world) {

        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);

    }

    @Override
    public void stop(GameData gameData, World world) {

        world.removeEntity(asteroid);

    }
}


//public class AsteroidPlugin implements IGamePluginService {
//
//    private Entity asteroid;
//
//    public AsteroidPlugin(){
//
//    }
//
//    private Entity createAsteroid(GameData gameData){
//
//        Entity asteroid = new Asteroid();
//
//
//
//        float deacceleration = 10;
//        float acceleration = 200;
//        float maxSpeed = 400;
//        float rotationSpeed = 1;
//        float x = gameData.getDisplayWidth() / 2 + MathUtils.random(-50,150);
//        float y = gameData.getDisplayHeight() / 2 + MathUtils.random(-50,150);
//        float radians = 2 * 3.1415f;
//
//
//        float[] color = {1,1,1,1};
//
//
//        asteroid.setColor(color);
//        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
//        asteroid.add(new PositionPart(x, y, radians));
//
//        return asteroid;
//
//    }
//
//    @Override
//    public void start(GameData gameData, World world) {
//
//        asteroid = createAsteroid(gameData);
//        world.addEntity(asteroid);
//    }
//
//    @Override
//    public void stop(GameData gameData, World world) {
//
//        world.removeEntity(asteroid);
//
//    }
//}
