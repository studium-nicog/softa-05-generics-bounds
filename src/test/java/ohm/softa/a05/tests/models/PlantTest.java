package ohm.softa.a05.tests.models;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlantTest {
    @Test
    void testFlowerMustNotBeGreen() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(20.5, "Sunflower", "Sunflower 1", PlantColor.GREEN));
    }

    @Test
    void testShrubIsGreen() {
        var shrub = new Shrub(30, "aa", "testname");

        assertEquals(PlantColor.GREEN, shrub.getColor());
    }
}
