import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class CoC_Army_Build_Tool {
	
	public static final String UNIT_PATH = "Unit_Stats";
	public static final String BUILD_PATH = "Build_Request";
	
	public static void main(String[] args) throws IOException {
		Map<String, Unit> CoC_Units = new HashMap<String, Unit>();
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(UNIT_PATH));
			
			String unitLine;
			while ((unitLine = reader.readLine()) != null) {
				String[] unitLineParts = unitLine.split(",");
				
				String name = unitLineParts[0];
				int maxLevel = Integer.parseInt(unitLineParts[1]);
				String[] elixirCostString = unitLineParts[2].split(":");
				int buildTime = Integer.parseInt(unitLineParts[3]);
				int housingSpace = Integer.parseInt((unitLineParts[4]));
				
				int[] elixirCost = new int[maxLevel];
				for (int i = 0; i < maxLevel; i++) {
					elixirCost[i] = Integer.parseInt(elixirCostString[i]);
				}
				
				CoC_Units.put(name, new Unit(name, maxLevel, elixirCost, buildTime, housingSpace));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error: Designated file not found.");
		}
		
		
		List<Barrack> Barrack = new ArrayList<Barrack>();
		Barrack.add(new Barrack());
		Barrack.add(new Barrack());
		Barrack.add(new Barrack());
		Set<Unit_Order> UnitOrders = new HashSet<Unit_Order>();
		
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(BUILD_PATH));
			
			String requestLine;
			while ((requestLine = reader.readLine()) != null) {
				String[] requestStats = requestLine.split(",");
				
				String requestName = requestStats[0];
				int requestLevel = Integer.parseInt(requestStats[1]);
				int requestAmount = Integer.parseInt(requestStats[2]);
				
				UnitOrders.add(new Unit_Order(CoC_Units.get(requestName), requestLevel, requestAmount));
			}
			
			for (Unit_Order u : UnitOrders) {
				System.out.println(u.unit.toString());
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			
		}
		
		
		
	}
}
