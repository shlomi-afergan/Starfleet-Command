package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public interface Spaceship extends Comparable<Spaceship>{

    public abstract String getName();
    public abstract int getCommissionYear();
    public abstract float getMaximalSpeed();
    public abstract int getFirePower();
    public abstract Set<? extends CrewMember> getCrewMembers();
    public abstract int getAnnualMaintenanceCost();
}
