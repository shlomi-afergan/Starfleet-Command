package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship{

	private int CargoCapacity;
	private int PassengerCapacity;
	private final int BasicAnnualMaintenanceCost = 3000;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.CargoCapacity =cargoCapacity;
		this.PassengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity(){
		return this.CargoCapacity;
	}
	public int getPassengerCapacity(){
		return this.PassengerCapacity;
	}
	public int getAnnualMaintenanceCost(){
		return this.BasicAnnualMaintenanceCost + (5 * this.getCargoCapacity()) + (3 * this.getPassengerCapacity());
	}

	@Override
	public String toString(){
		return "TransportShip"
				+ super.toString()
				+ "\n\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost()
				+ "\n\tCargoCapacity=" + this.getCargoCapacity()
				+ "\n\tPassengerCapacity=" + this.getPassengerCapacity();
	}
}
