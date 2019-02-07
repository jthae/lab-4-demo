import java.io.IOException;

/**
 * Driver class that passes in the name of a csv file to UtilityBelt to parse. The csv file is a list of equipments.
 * The data is then displayed.
 * @author Stephen
 * @version 2018-09-03
 */
public class Driver {

	public static void main(String[] args) throws IOException
	{
		
		// When you submit, you should only read in from "InputOfficial.csv".
		   // You may test by using different .csv files, however.
		   UtilityBelt utilityBelt = new UtilityBelt("InputOfficial.csv");
	       
	       // TODO: test your code here:
	       utilityBelt.writeEquipment("BeltInfo.txt");
	       utilityBelt.writeStatistics("BeltStats.txt");
	       
	       
		
			// Equipment equip = new Equipment("idkbro/5,6.9,4.20,yeet man");
			// System.out.println(equip.toString());
			
	       
	       // TODO: modify the Input.csv file to allow proper testing of playersFromState() and writePlayers(). Currently,
	       //       Input.csv has only equipments from the same state. writePlayers() with two parameters should only write
	       //       out information about a subset of equipments, not all equipments. This functionality needs to be tested.
	}

}
