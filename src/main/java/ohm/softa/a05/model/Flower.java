package ohm.softa.a05.model;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
public class Flower extends Plant {

	private final PlantColor color;

	public Flower(String family, String name, double height, PlantColor color) {
		super(family, name, height);

		/* ensure that a flower is never green */
		if(color == PlantColor.GREEN){
			throw new IllegalArgumentException("A plant may not be green!");
		}

		this.color = color;
	}

	@Override
	public PlantColor getColor() {
		return color;
	}
}
