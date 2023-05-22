import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ArrivalTimeCalculator {


    public ZonedDateTime arrivalTime (Flight flight){
        Locale hungarian = new Locale("hu", "HU");
        DateTimeFormatter customHun =DateTimeFormatter.ofPattern("yyyy. MMMM dd. (eeee) HH:mm zzzz", hungarian);

        String zoneIDStart = zones(flight.getStartPlace());
        String zoneIDDestination = zones(flight.getDestination());
        ZonedDateTime travelFromStart = ZonedDateTime.of(flight.getDepartureDateTime(), ZoneId.of(zoneIDStart));
        ZonedDateTime inDestination = travelFromStart.withZoneSameInstant(ZoneId.of(zoneIDDestination));
        ZonedDateTime arrivalTime = inDestination.plus(flight.getDuration().toMinutes(), ChronoUnit.MINUTES);
        //String arrival = inDestination.plus(flight.getDuration().toMinutes(), ChronoUnit.MINUTES).format(customHun);

        return arrivalTime;
    }

    public String zones(String zone){
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<>(allZones);
        Collections.sort(zoneList);
        List<String> zoneID = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(zone.contains(" ")){
            zone = zone.replace(" ", "_");
        }

        for (String s : zoneList) {
            if(s.contains(zone)){
                sb.append(s);
            }
            if(zone.contains("Boston")){// nyilvan hulyeseg, de a listában nincs "America/Boston"
                return "America/New_York";
            }

        }
        return sb.toString();
    }

}
