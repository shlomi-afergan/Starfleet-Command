package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;
import java.util.stream.Collectors;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		return fleet.stream().sorted(Comparable::compareTo).map(Object::toString).collect(Collectors.toList());
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> res = new HashMap<>();
		for (Spaceship spaceship: fleet){
			res.merge(spaceship.getClass().getSimpleName(),1,Integer::sum);
//			if (res.containsKey(spaceship.getClass().getSimpleName())){
//				res.put(spaceship.getClass().getSimpleName(), res.get(spaceship.getClass().getSimpleName())+1);
//			}
//			else {
//				res.put(spaceship.getClass().getSimpleName(), 1);
//			}
		}
		return res;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int total = 0;
		for (Spaceship spaceship: fleet){
			total += spaceship.getAnnualMaintenanceCost();
		}
		return total;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> allWeapons = new HashSet<>();
		for (Spaceship spaceship: fleet){
			if (spaceship instanceof Fighter){
				for(Weapon weapon :((Fighter) spaceship).getWeapons()){
					allWeapons.add(weapon.getName());
				}
			}
			else if (spaceship instanceof Bomber){
				for(Weapon weapon:((Bomber) spaceship).getWeapons()){
					allWeapons.add(weapon.getName());
				}
			}
		}
		return allWeapons;
	}

	/**
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int total = 0;
		for (Spaceship spaceship: fleet){
			total += spaceship.getCrewMembers().size();
		}
		return total;
	}

	/**
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int AVG = 0;
		int Officers = 0;
		for (Spaceship spaceship: fleet){
			for (CrewMember crewMember: spaceship.getCrewMembers()){
				if (crewMember instanceof Officer){
					AVG += crewMember.getAge();
					Officers ++;
				}
			}
		}
		return (float)AVG / Officers;
	}

	/**
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRanking = new HashMap<>();
		Officer officer = null;
		OfficerRank maxRank = null;
		for (Spaceship spaceship: fleet){  // pass over spaceships
			for (CrewMember crewMember: spaceship.getCrewMembers()){  //pass over crewMembers
				if (crewMember instanceof Officer){   // if is officer:
					if ((maxRank == null) || ((Officer) crewMember).getRank().compareTo(maxRank)>0){  // if this is the highest rank so far
						maxRank = ((Officer) crewMember).getRank();  // update maxRank and officer.
						officer = (Officer) crewMember;
					}
				}
			}
			if (officer != null){  // if we found someone - add him to the map.
				highestRanking.put(officer, spaceship);
			}
			officer = null; maxRank = null;  // reset maxRank and officer.
		}
		return highestRanking;
	}

	/**
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> CountedRanks = new HashMap<>();
		for (Spaceship spaceship: fleet){
			for (CrewMember crewMember: spaceship.getCrewMembers()){
				if (crewMember instanceof Officer){
					CountedRanks.merge(((Officer) crewMember).getRank(), 1, Integer::sum);
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> res = new ArrayList<>(CountedRanks.entrySet());
		myOfficerComparator comparator = new myOfficerComparator();
		res.sort(comparator);
		return res;
	}

}
