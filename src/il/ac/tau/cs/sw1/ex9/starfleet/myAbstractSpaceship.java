package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship{
    protected String name;
    protected int CommissionYear;             // 4 digits.
    protected float MaximalSpeed;            // Scale: 0-10.
    protected int BasicFirePower = 10;      // The basic FirePower of each spaceship.
    protected Set<? extends CrewMember> CrewMembers;


    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.CommissionYear = commissionYear;
        this.MaximalSpeed = maximalSpeed;
        this.CrewMembers = crewMembers;
    }

    public String getName(){
        return this.name;
    }
    public int getCommissionYear(){
        return this.CommissionYear;
    }
    public float getMaximalSpeed(){
        return this.MaximalSpeed;
    }
    public int getFirePower(){
        return this.BasicFirePower;
    }
    public Set<? extends CrewMember> getCrewMembers(){
        return this.CrewMembers;
    }

    @Override
    public String toString(){
        return "\n\tName=" + this.getName()
                + "\n\tCommissionYear=" + this.getCommissionYear()
                + "\n\tMaximalSpeed=" + this.getMaximalSpeed()
                + "\n\tFirePower=" + this.getFirePower()
                + "\n\tCrewMembers=" + this.getCrewMembers().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractSpaceship that = (myAbstractSpaceship) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public int compareTo(Spaceship other){
        if (this.getFirePower() == other.getFirePower()) {
            if (this.getCommissionYear() == other.getCommissionYear()) {
                return (this.getName().compareTo(other.getName()));
            } else {
                return Integer.compare(other.getCommissionYear(), this.getCommissionYear());
            }
        }
        else{
                return Integer.compare(other.getFirePower(), this.getFirePower());
            }
        }


    public abstract int getAnnualMaintenanceCost();   // different implementation of each spaceship.
}