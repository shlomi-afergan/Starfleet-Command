package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;


public class Fighter extends mySubAbstractSpaceship{

	private final int BasicAnnualMaintenanceCost = 2500;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		return this.BasicAnnualMaintenanceCost
				+ super.getSumOfWeaponsAnnualMaintenanceCost()
				+ (int)(1000 * super.getMaximalSpeed());
	}
	@Override
	public String toString() {
		return "Fighter"
				+ super.toString()
				+ "\n\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost()
				+ "\n\tWeaponArray=" + this.getWeapons();
	}
}
