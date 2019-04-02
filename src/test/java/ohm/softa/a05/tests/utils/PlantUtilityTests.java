package ohm.softa.a05.tests.utils;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.utils.PlantUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
class PlantUtilityTests {

	private PlantBed<Flower> flowerBed;

	@BeforeEach
	void setup() {
		flowerBed = new PlantBed<>();

		flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.4, PlantColor.YELLOW));
		flowerBed.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
		flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.3, PlantColor.YELLOW));
		flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.35, PlantColor.YELLOW));
		flowerBed.add(new Flower("Rosa", "Abracadabra", 0.35, PlantColor.RED));
		flowerBed.add(new Flower("Rosa", "Rosa chinensis", 0.35, PlantColor.ORANGE));
		flowerBed.add(new Flower("Tulip", "Curly Sue", 0.35, PlantColor.VIOLETTE));
	}

	@Test
	void testSplitByBedByColorResultingSize() {
		Map<PlantColor, SimpleList<Flower>> split = PlantUtility.splitBedByColor(flowerBed);
		assertEquals(4, split.keySet().size());
	}

	@Test
	void testSplitByBedByColorPureness() {
		Map<PlantColor, SimpleList<Flower>> split = PlantUtility.splitBedByColor(flowerBed);
		for (Flower f : split.get(PlantColor.YELLOW)) {
			assertEquals(PlantColor.YELLOW, f.getColor());
		}
	}

	@Test
	void testSplitByBedByColorPureness2() {
		Map<PlantColor, SimpleList<? extends Flower>> split = PlantUtility.splitBedByColor2(flowerBed);
		for (Flower f : split.get(PlantColor.YELLOW)) {
			assertEquals(PlantColor.YELLOW, f.getColor());
		}
	}
}
