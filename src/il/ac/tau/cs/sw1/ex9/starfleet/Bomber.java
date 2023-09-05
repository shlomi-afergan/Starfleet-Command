package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends mySubAbstractSpaceship{

	private int numberOfTechnicians;
	private final int BasicAnnualMaintenanceCost = 5000;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}
	public int getNumberOfTechnicians(){
		return this.numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return (int) (this.BasicAnnualMaintenanceCost + super.getSumOfWeaponsAnnualMaintenanceCost()
				* (1 - this.numberOfTechnicians * 0.1));
	}

	@Override
	public String toString() {
		return "Bomber"
				+ super.toString()
				+ "\n\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost()
				+ "\n\tWeaponArray=" + this.getWeapons()
				+ "\n\tNumberOfTechnicians=" + this.getNumberOfTechnicians();
	}

}
