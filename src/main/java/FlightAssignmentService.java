import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightAssignmentService {

    /**
     * TODO implement this method
     * Return the crew code(s) of the crew members who have the longest total assignments,
     * counted based on the given FlightAssignments.
     * A crew member has the longest total flight assignment if he/she is assigned to flights that have the longest combined flying time.
     * The flying time is the time passed between the departure and the arrival of a flight.
     *
     * @param assignments - flight assignments consisting of a flight and a crew member's code that is assigned to the flight
     * @return - list of crew codes, who have the longest total assignments, returned in alphabetical order !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Adja vissza a legénység azon tagjainak legénységi kódját (kódjait), akiknek a leghosszabb az összes megbízása,
     *      * a megadott FlightAssignments alapján számolva.
     *      * A legénységi tagnak van a leghosszabb összes repülési megbízása, ha olyan járatokra van beosztva, amelyeknek a leghosszabb az összesített repülési ideje.
     *      * A repülési idő a járat indulása és érkezése között eltelt idő.
     */

    public List<String> getCrewCodesOfLongestAssignments(List<FlightAssignment> assignments) {
        List<String> crews = new ArrayList<>();
        Map<String, Long> map = new TreeMap<>();
        for(int i = 0; i < assignments.size(); i++){
            if(map.containsKey(assignments.get(i).getCrewCode())){
                long dur = map.get(assignments.get(i).getCrewCode());
                map.put(assignments.get(i).getCrewCode(), (Duration.between(assignments.get(i).getFlight().getDepartureDateTime(), assignments.get(i).getFlight().getArrivalDateTime()).toMinutes()) + dur);
                //System.out.println("code: "+assignments.get(i).getCrewCode());
            } else {
                map.put(assignments.get(i).getCrewCode(), Duration.between(assignments.get(i).getFlight().getDepartureDateTime(), assignments.get(i).getFlight().getArrivalDateTime()).toMinutes());//**
            }
        }

        List<Map.Entry<String, Long>> collect = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());

        System.out.println("Crew and his/her total flight minutes:");
        map.forEach((key, value) -> System.out.println("Crew: "+ key + ", minutes: " + value));
        for(int i = 0; i < collect.size(); i++){
            crews.add(collect.get(i).getKey());
        }


        return crews;
    }

    //** minutes legyen, ill a legkissebb időegység!
}
