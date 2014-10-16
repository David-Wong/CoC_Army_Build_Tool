import java.util.Arrays;


public class Unit {
	
	public String name;
	public int levels;
	public int[] cost;
	public int time;
	public int space;
	
	public Unit(String name, int levels, int[] cost, int time, int space) {
		this.name = name;
		this.levels = levels;
		this.cost = cost;
		this.time = time;
		this.space = space;
	}
	
	public String toString() {
		return this.name + " " + this.levels + " " + Arrays.toString(this.cost) + " " + this.time + " " + this.space;
	}
}
