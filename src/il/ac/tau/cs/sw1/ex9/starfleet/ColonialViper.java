package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {

	private final int BasicAnnualMaintenanceCost = 4000;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear,maximalSpeed,crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return (int)(this.BasicAnnualMaintenanceCost
				+ super.getSumOfWeaponsAnnualMaintenanceCost()
				+ 500 * this.getCrewMembers().size()
				+ 500 * this.getMaximalSpeed());
	}

	@Override
	public String toString() {
		return "ColonialViper"
				+ super.toString().substring(7);  //cut "Fighter" from the super toString
	}
}
