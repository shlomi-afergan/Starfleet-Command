package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class myOfficerComparator implements Comparator<Map.Entry<OfficerRank,Integer>> {
    public int compare(Map.Entry<OfficerRank,Integer> item1,Map.Entry<OfficerRank,Integer> item2){
        if(Objects.equals(item1.getValue(), item2.getValue())){ return item1.getKey().compareTo(item2.getKey());}
        else return item1.getValue().compareTo(item2.getValue());
    }
}
