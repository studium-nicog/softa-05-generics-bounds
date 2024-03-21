package ohm.softa.a05.tests.models;

import ohm.softa.a05.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlantBedTest {
    private PlantBed<Plant> plantBed;

    @BeforeEach
    void setup() {
        plantBed = new PlantBed<>();

        plantBed.add(new Flower(23.5, "A", "aaa", PlantColor.BLUE));
        plantBed.add(new Flower(24.5, "B", "bbb", PlantColor.YELLOW));
        plantBed.add(new Flower(25.5, "C", "ccc", PlantColor.YELLOW));
        plantBed.add(new Shrub(26.5, "D", "ddd"));
        plantBed.add(new Flower(27.5, "E", "eee", PlantColor.YELLOW));
    }

    @Test
    void testGetPlantsByColor() {
        var result = plantBed.getPlantsByColor(PlantColor.YELLOW);

        assertEquals(3, result.size());
    }
}
