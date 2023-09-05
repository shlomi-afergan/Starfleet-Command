package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

/**
 * implementation for Fighter and Bomber
 */

public abstract class mySubAbstractSpaceship extends myAbstractSpaceship{

    protected List<Weapon> weapons;

    public mySubAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers,List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }

    public List<Weapon> getWeapons(){
        return this.weapons;
    }

    public int getFirePower() {
        int sumOfWeaponsPower = this.weapons.stream()
                .map(Weapon::getFirePower)
                .mapToInt(Integer::intValue)
                .sum();
        return super.getFirePower() + sumOfWeaponsPower;
    }
    public int getSumOfWeaponsAnnualMaintenanceCost(){
        return this.weapons.stream()
                .map(Weapon::getAnnualMaintenanceCost)
                .mapToInt(Integer::intValue)
                .sum();
    }
    public abstract int getAnnualMaintenanceCost();   // different implementation of each spaceship.

}
