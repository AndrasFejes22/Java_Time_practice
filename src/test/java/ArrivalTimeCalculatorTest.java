import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalTimeCalculatorTest {

    ArrivalTimeCalculator arrivalTimeCalculator;

    @BeforeEach
    void setUp() {
        this.arrivalTimeCalculator = new ArrivalTimeCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void arrivalTimeTest() {
        Duration durationToWarsaw = Duration.ofMinutes((11 * 60) + 35);
        Flight flightToWarsaw = new Flight(LocalDateTime.of(2023, 6, 30, 16, 35, 0, 0), "Los Angeles", "Warsaw" , durationToWarsaw);
        assertEquals(ZonedDateTime.of(2023, 7, 1, 13, 10, 0, 0, ZoneId.of("Europe/Warsaw")), arrivalTimeCalculator.arrivalTime(flightToWarsaw));

        Duration durationToBerlin = Duration.ofMinutes(100);
        Flight flightToBerlin = new Flight(LocalDateTime.of(2023, 7, 1, 20, 40, 0, 0), "Warsaw", "Berlin" , durationToBerlin);
        assertEquals(ZonedDateTime.of(2023, 7, 1, 22, 20, 0, 0, ZoneId.of("Europe/Berlin")), arrivalTimeCalculator.arrivalTime(flightToBerlin));

        Duration durationToBoston = Duration.ofMinutes((8 * 60) + 25);
        Flight flightToBoston = new Flight(LocalDateTime.of(2023, 5, 29, 12, 55, 0, 0), "Zurich", "Boston" , durationToBoston);
        assertEquals(ZonedDateTime.of(2023, 5, 29, 15, 20, 0, 0, ZoneId.of("America/New_York")), arrivalTimeCalculator.arrivalTime(flightToBoston));
    }

    @Test
    void zoneTest() {

        assertEquals("America/Los_Angeles", arrivalTimeCalculator.zones("Los Angeles"));

    }

}