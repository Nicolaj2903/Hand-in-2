package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

/**
 * Adds a entity to be able to shoot
 */

public class ShootingPart implements EntityPart {
    private float x;
    private float y;
    private float radians;


    /**
     * get x position of shooting part
     *
     * @return
     */
    public float getX() {
        return x;
    }

    /**
     * set x position of shooting part
     *
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * get Y position of shooting part
     *
     * @return
     */
    public float getY() {
        return y;
    }

    /**
     * set Y position of shooting part
     *
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Get radians of shooting part
     *
     * @return
     */
    public float getRadians() {
        return radians;
    }

    /**
     * set Radians of shooting part
     *
     * @param radians
     */
    public void setRadians(float radians) {
        this.radians = radians;
    }

    /**
     * The constructor
     *
     * @param x       x position
     * @param y       y position
     * @param radians radians
     */
    public ShootingPart(float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;
    }

    @Override
    public void process(GameData gameData, Entity entity) {

    }
}
