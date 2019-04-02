package ohm.softa.a05.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
public abstract class Plant implements Comparable<Plant> {

	private final String family;
	private final String name;
	private final double height;

	protected Plant(String family, String name, double height) {
		if(family == null || family.length() == 0) throw new IllegalArgumentException("Specify a family");
		if(name == null || name.length() == 0) throw new IllegalArgumentException("Specify a name");
		if(height <= 0.0) throw new IllegalArgumentException("Height may not be less or equal zero");
		this.family = family;
		this.name = name;
		this.height = height;
	}

	public String getFamily() {
		return family;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public abstract PlantColor getColor();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Plant)) return false;

		Plant plant = (Plant) o;

		return new EqualsBuilder()
				.append(getHeight(), plant.getHeight())
				.append(getFamily(), plant.getFamily())
				.append(getName(), plant.getName())
				.append(getColor(), plant.getColor())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(getFamily())
				.append(getName())
				.append(getHeight())
				.append(getColor())
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("family", family)
				.append("name", name)
				.append("height", height)
				.append("color", getColor())
				.toString();
	}

	@Override
	public int compareTo(Plant plant) {
		return Double.compare(this.height, plant.height);
	}
}
