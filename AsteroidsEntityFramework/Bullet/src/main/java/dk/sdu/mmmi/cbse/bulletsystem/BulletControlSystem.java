package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.TimePart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.data.Entity;


public class BulletControlSystem implements IEntityProcessingService {
    private float x;
    private float y;
    private float radians;
    private int maxBullets = 4;
    private int bulletCount = 0;

    @Override
    public void process(GameData gameData, World world) {


        if (gameData.getKeys().isPressed(GameKeys.SPACE)) {
            if (bulletCount<maxBullets){
                shoot(gameData, world);
            }
        }


        for (Entity entity : world.getEntities()) {
            if (entity.getPart(ShootingPart.class) != null) {
                PositionPart positionPart = entity.getPart(PositionPart.class);

                x = positionPart.getX();
                y = positionPart.getY();
                radians = positionPart.getRadians();
            }
        }
        for (Entity bullet : world.getEntities(Bullet.class)) {
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);
            TimePart timePart = bullet.getPart(TimePart.class);


            timePart.setTime(timePart.getTime() + gameData.getDelta());

            //remove bullet if lifetime reaches expiration time
            if (timePart.getTime() > timePart.getExpiration()) {
                world.removeEntity(bullet);
                bulletCount--;
            }

            //move the bullet
            movingPart.setMaxSpeed(100);
            movingPart.setUp(true);

            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            updateShape(bullet);
        }

    }


    private void updateShape(Entity entity) {


        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();


        PositionPart positionPart = entity.getPart(PositionPart.class);

        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();


        shapex[0] = (float) (x + Math.cos(radians) * 1);
        shapey[0] = (float) (y + Math.sin(radians) * 1);

        shapex[1] = (float) (x + Math.cos(radians) * 1);
        shapey[1] = (float) (y + Math.sin(radians) * 1);

        shapex[2] = (float) (x + Math.cos(radians) * 2);
        shapey[2] = (float) (y + Math.sin(radians) * 2);

        shapex[3] = (float) (x + Math.cos(radians) * 1);
        shapey[3] = (float) (y + Math.sin(radians) * 1);


        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }


    private void shoot(GameData gameData, World world) {

        Entity bullet = createBullet(gameData);
        world.addEntity(bullet);
        bulletCount++;
    }


    /**
     *
     * @return return entity
     * @param gameData --gets created in shoot helper method
     */
    private Entity createBullet(GameData gameData) {

        float[] color = {1, 1, 0, 1};

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 1;
        float time = 0;
        float expiration = 3;

        Entity bullet = new Bullet();
        bullet.setColor(color);
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new TimePart(time, expiration));

        return bullet;
    }
}
