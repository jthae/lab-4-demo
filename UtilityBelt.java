import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that represents Batman's utility belt. Stores the list of all equipment
 * in the belt and computes statistics about the equipment.
 * 
 * Reads in equipment information from files and outputs stats to other files.
 * 
 * @author Stephen
 * @version 2018-01-27
 */
public class UtilityBelt
{
    /**
     * The list of equipment in the utility belt.
     * Don't worry about the "protected" for now; this is done to make tests easier.
     */
    protected ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    
    /**
     * THIS METHOD IS PROVIDED TO YOU.
     * YOU SHOULD NOT MODIFY IT!
     * 
     * Constructor, takes in a csv file of Equipment and stores them in a list.
     * 
     * @param filename The name of the csv file containing a list of Equipment, one Equipment on each line.
     * Assumes that the csv file is at the top level of the project
     * (not within any folders; at the same level as src and TODO.json - this will be handled automatically
     * in Zylabs).
     */
    public UtilityBelt(String filename)
    {
    	// Attempt to read a csv file, catch an error if something goes wrong:
    	try
    	{
    		read(filename);
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error reading from file!\n");
    		e.printStackTrace();
    	}
    }
    
    /**
     * Loads a list of equipment from a CSV file. Each line of the csv represents a single Equipment.
     * The first line of the csv denotes the order of the fields, you should not
     * construct a player from the first line.
     * 
     * @param filename The file to read from.
     * @throws IOException Throw this exception if a major issue with the file occurs.
     */
    public void read(String filename) throws IOException
    {
    	// Use a buffered Reader on the file:
    	BufferedReader br = new BufferedReader(new FileReader(filename));
        String strg = br.readLine();
       
        while ((strg = br.readLine()) != null)
        {
        	Equipment equip = new Equipment(strg);
        	equipment.add(equip);
        }
        
        
        br.close();
    }
    
    /**
     * Writes out information about the Equipment in the UtilityBelt.
     * Specifically, loop through the list of equipments write out each equipment's toString().
     * A newline is added after each toString (using BufferedWriter's newLine() method).
     * 
     * @param filename the file to write out to (should be a .txt file).
     * When you run this method locally this file may not load into eclipse. You should use
     * File>Refresh on the project to view the files in eclipse.
     */
    public void writeEquipment(String filename) throws IOException
    {
    	// Set up the writer:
    	BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
    	
    	// Write out each equipment, adding a newline between toStrings:
    	for(int i = 0; i < equipment.size(); ++i)
    	{
    		bw.write(equipment.get(i).toString() + "\n");
    	}
    	// TODO: complete method
    	
    	// Close the writer:
    	bw.close();
    }
    
    /**
     * Formats and writes out information about the statistics of a UtilityBelt.
     * Specifically, write out information in the following format:
     * 
     * "Total Weight: (total weight)\nMost Expensive Equipment: (name of the most expensive equipment)\n""
     * 
     * @param filename the file to write out to (should be a .txt file).
     * When you run this method locally this file may not load into eclipse. You should use
     * File>Refresh on the project to view the files in eclipse.
     */
    public void writeStatistics(String filename) throws IOException
    {
    	BufferedWriter bw = new BufferedWriter(new FileWriter (filename));
    	String weight = "Total Weight: " + computeTotalWeight();
    	bw.write(weight);
    	bw.newLine();
    	
    	String expensive = "Most Expensive Equipment: " + findMostExpensiveEquipment().getName();
    	bw.write(expensive);
    	bw.newLine();
    	
    	bw.close();
    }
    
    /**
     * Gives the total weight of the UtilityBelt.
     * 
     * @return Sum of the weights of the Equipment in the UtilityBelt.
     */
    public double computeTotalWeight()
    {
        double result = 0;
    	for (int index = 0; index < equipment.size(); ++index)
        {
        	Equipment equip = equipment.get(index);
        	result += equip.getTotalWeight();
        }
    	return result;
    }
    
    /**
     * Find equipment with the same name. 
     * 
     * @param name The name to compare to.
     * @return The equipment with the same name, ignoring case. Return null if
     * no equipment has the same name.
     */
    public Equipment getNamedEquipment(String name)
    {
    	Equipment sameName = null;
    	
    	for (int i = 0; i < equipment.size(); ++i)
    	{
    		if (equipment.get(i).getName().equalsIgnoreCase(name))
    		{
    			sameName = equipment.get(i);
    		}
    	}
    	return sameName;
    }
    
    /**
     * Calculates the subset of equipments which have a count above a certain amount.
     * 
     * @param state Equipment with a count variable above the input amount should be aggregated and returned.
     * @return An arraylist containing all equipments whose count is above the input variable "count".
     */
    public ArrayList<Equipment> equipmentAboveCount(int count)
    {
        ArrayList<Equipment> equipAboveCount = new ArrayList<Equipment>();
    	for (int i = 0; i < equipment.size(); i++)
        {
        	Equipment equip = equipment.get(i);
        	if(equip.getCount() > count)
        	{
        		equipAboveCount.add(equip);
        	}
        }
    	return equipAboveCount;
    }
    
    /**
     * Finds the most expensive Equipment (highest total price variable).
     * 
     * @return A Equipment object that has the highest total price variable out of all Equipment recorded.
     *         If there are no equipment in the utility belt, return null.
     */
    public Equipment findMostExpensiveEquipment()
    {
    	Equipment mostExpensive = equipment.get(0);
    	for (int i = 0; i < equipment.size(); ++i)
        {
        	
    		if(equipment.get(i).getTotalPrice() > mostExpensive.getTotalPrice())
    		{
    			mostExpensive = equipment.get(i);
    		}
        }
    	return mostExpensive;
    }
}