/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.playersystem.Player;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author jcs
 */


public class CollisionDetectorTest {

//    public CollisionDetectorTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }
//
//    @BeforeEach
//    public void setUp() {
//    }
//
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of process method, of class CollisionDetector.
//     */
//    @Test
//    public void testProcess() {
//
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of Collides method, of class CollisionDetector.
     */
    @Test
    public void testCollides()
    {
        System.out.println("Testing collision");

        Entity player = Mockito.mock(Player.class);
        Entity asteroid = Mockito.mock(Asteroid.class);

        Mockito.when(player.getRadius()).thenReturn(3F);
        Mockito.when(asteroid.getRadius()).thenReturn(3F);

        Mockito.when(player.getPart(PositionPart.class)).thenReturn(new PositionPart(10, 20, 3));
        Mockito.when(asteroid.getPart(PositionPart.class)).thenReturn(new PositionPart(10, 20, 3));

        CollisionDetector instance = new CollisionDetector();

        assertEquals(true, instance.Collides(player, asteroid));

        System.out.println("Finished testing collision");
    }
}

