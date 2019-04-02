package ohm.softa.a05.model;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
public class Shrub extends Plant {

	public Shrub(String family, String name, double height) {
		super(family, name, height);
	}

	@Override
	public PlantColor getColor() {
		return PlantColor.GREEN;
	}
}
