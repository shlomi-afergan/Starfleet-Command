package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	private static int numOfStealthCruisers = 0;


	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numOfStealthCruisers++;
	}

	// call the constructor above with new list of weapons.
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, new ArrayList<Weapon>(Arrays.asList(new Weapon("Laser Cannons",10,100))));
	}

	@Override
	public int getAnnualMaintenanceCost(){
		return super.getAnnualMaintenanceCost() + 50*numOfStealthCruisers;
	}

	@Override
	public String toString() {
		return "StealthCruiser"
				+ super.toString().substring(7);
	}
}
