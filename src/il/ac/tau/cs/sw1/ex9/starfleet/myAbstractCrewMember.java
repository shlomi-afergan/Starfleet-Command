package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myAbstractCrewMember implements CrewMember {
    protected int age;
    protected int yearsInService;
    protected String name;


    public myAbstractCrewMember(int age, int yearsInService, String name) {
        this.age = age;
        this.yearsInService = yearsInService;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getYearsInService() {
        return this.yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractCrewMember that = (myAbstractCrewMember) o;
        return age == that.age && yearsInService == that.yearsInService && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, yearsInService, name);
    }
}
