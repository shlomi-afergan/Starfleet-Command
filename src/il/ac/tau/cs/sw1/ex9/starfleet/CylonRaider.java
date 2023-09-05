package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	private final int BasicAnnualMaintenanceCost = 3500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return (int)(this.BasicAnnualMaintenanceCost
				+ super.getSumOfWeaponsAnnualMaintenanceCost()
				+ 500 * super.getCrewMembers().size()
				+ 1200 * super.getMaximalSpeed());
	}

	@Override
	public String toString() {
		return "CylonRaider"
				+ super.toString().substring(7);  //cut "Fighter" from the super toString
	}
}
