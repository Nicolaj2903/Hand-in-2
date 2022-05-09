package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class TimePart implements EntityPart{

    private float time;
    private float expiration;
    private boolean expired;

    /**
     *
     * @param time  the time
     * @param expiration expiration time
     */
    public TimePart(float time, float expiration){
        this.time = time;
        this.expiration = expiration;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    /**
     * get expiration time
     * @return
     */
    public float getExpiration() {
        return expiration;
    }


    /**
     * check if time part is expired
     * @return
     */
    public boolean isExpired() {
        return expired;
    }

    /**
     * set time part to expired
     * @param expired
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }




    public void setExpiration(float expiration) {
        this.expiration = expiration;
    }

    @Override
    public void process(GameData gameData, Entity entity) {

    }
}
