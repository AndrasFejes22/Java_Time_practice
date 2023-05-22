import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightAssignmentServiceTest {

    private FlightAssignmentService flightAssignmentService;
    List<String> crews = new ArrayList<>();
    List<Flight> flights = new ArrayList<>();
    List<FlightAssignment> flightAssignmentList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        this.flightAssignmentService = new FlightAssignmentService();

        Flight flight1 = new Flight(LocalDateTime.of(2022, Month.JANUARY, 14, 12, 5), LocalDateTime.of(2022, Month.JANUARY, 14, 15, 5));
        Flight flight2 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 14, 23, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 5, 6));
        Flight flight3 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 6, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 10, 6));
        Flight flight4 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 12, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 21, 9));

        FlightAssignment flightAssignment1 = new FlightAssignment(flight1, "MRT");
        FlightAssignment flightAssignment2 = new FlightAssignment(flight2, "BGD");
        FlightAssignment flightAssignment3 = new FlightAssignment(flight3, "BGD");
        FlightAssignment flightAssignment4 = new FlightAssignment(flight4, "ZCV");


        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        flightAssignmentList.add(flightAssignment1);
        flightAssignmentList.add(flightAssignment2);
        flightAssignmentList.add(flightAssignment3);
        flightAssignmentList.add(flightAssignment4);

        //crews = new ArrayList<String>(Arrays.asList("BGD", "ZCV", "MRT"));
        crews.add("BGD");
        crews.add("ZCV");
        crews.add("MRT");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getCrewCodesOfLongestAssignmentsTest() {

        assertEquals(crews, flightAssignmentService.getCrewCodesOfLongestAssignments(flightAssignmentList)); // expected, actual
    }
}