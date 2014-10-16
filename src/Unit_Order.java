
public class Unit_Order implements Comparable<Unit_Order> {

	public Unit unit;
	public int level;
	public int amount;
	public int space;
	
	public Unit_Order(Unit unit, int level, int amount) {
		this.unit = unit;
		this.level = level;
		this.amount = amount;
		this.space = unit.space;
	}

	@Override
	public int compareTo(Unit_Order o) {
		return this.space - o.space;
	}
}
