
public class Barrack implements Comparable<Barrack> {
	public int capacity;
	public int free;
	public int buildTime;
	
	@Override
	public int compareTo(Barrack o) {
		// TODO Auto-generated method stub
		if (this.free == o.free) {
			return this.buildTime - o.buildTime;
		} else {
			return -(this.free - o.free);
		}
	}
}
