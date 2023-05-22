import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Szállodafoglalást kell végezni, ha a járat érkezése és a következő járat indulása között eltelt idő egy éjszakát metszi.

        Az éjszaka definíciója az este 10 és reggel 5 óra közötti időszak.
        */

        //Flight(departureDateTime, arrivalDateTime  = indulas/erkezes)
        /*
        Flight flight1 = new Flight(LocalDateTime.of(2022, Month.JANUARY, 14, 12, 5), LocalDateTime.of(2022, Month.JANUARY, 14, 15, 5));
        Flight flight2 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 14, 23, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 5, 6));
        Flight flight3 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 6, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 10, 6));
        Flight flight4 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 12, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 21, 9));
        */

        //uj:
        Flight flight1 = new Flight(LocalDateTime.of(2022, Month.JANUARY, 14, 12, 5), LocalDateTime.of(2022, Month.JANUARY, 14, 20, 5));
        Flight flight2 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 16, 6, 3), LocalDateTime.of(2022, Month.FEBRUARY, 16, 7, 6));

        List<Flight> flights = new ArrayList<>();

        flights.add(flight1);
        flights.add(flight2);
        //flights.add(flight3);
        //flights.add(flight4);

        FlightAssignment flightAssignment1 = new FlightAssignment(flight1, "MRT");
        FlightAssignment flightAssignment2 = new FlightAssignment(flight2, "BGD");
        //FlightAssignment flightAssignment3 = new FlightAssignment(flight3, "BGD");
        //FlightAssignment flightAssignment4 = new FlightAssignment(flight4, "ZCV");

        long flight1bw = Duration.between(flight1.getDepartureDateTime(), flight1.getArrivalDateTime()).toMinutes();
        long flight2bw = Duration.between(flight2.getDepartureDateTime(), flight2.getArrivalDateTime()).toMinutes();
        //long flight3bw = Duration.between(flight3.getDepartureDateTime(), flight3.getArrivalDateTime()).toMinutes();
        //long flight4bw = Duration.between(flight4.getDepartureDateTime(), flight4.getArrivalDateTime()).toMinutes();




        System.out.println("Flight 1 flight time: " + flight1bw + " crew: " + flightAssignment1.getCrewCode());
        System.out.println("Flight 2 flight time: " + flight2bw + " crew: " + flightAssignment2.getCrewCode());
        //System.out.println("Flight 3 flight time: " + flight3bw + " crew: " + flightAssignment3.getCrewCode());
        //System.out.println("Flight 4 flight time: " + flight4bw + " crew: " + flightAssignment4.getCrewCode());

        List<FlightAssignment> flightAssignmentList = new ArrayList<>();

        flightAssignmentList.add(flightAssignment1);
        flightAssignmentList.add(flightAssignment2);
        //flightAssignmentList.add(flightAssignment3);
        //flightAssignmentList.add(flightAssignment4);

        FlightAssignmentService flightAssignmentService = new FlightAssignmentService();

        System.out.println("Crew: " + flightAssignmentService.getCrewCodesOfLongestAssignments(flightAssignmentList));

        HotelBookingService hotelBookingService = new HotelBookingService();

        System.out.println("bookings: "+hotelBookingService.countHotelBookings(flights));

        System.out.println();

        System.out.println("------ArrivalCalculator------");
        Duration durationToWarsaw = Duration.ofMinutes((11 * 60) + 35);
        Duration durationToBerlin = Duration.ofMinutes(100);
        ArrivalTimeCalculator arrivalTimeCalculator = new ArrivalTimeCalculator();

        Flight flightToWarsaw = new Flight(LocalDateTime.of(2023, 6, 30, 16, 35, 0, 0), "Los_Angeles", "Warsaw" , durationToWarsaw);
        System.out.println(arrivalTimeCalculator.arrivalTime(flightToWarsaw));

        Flight flightToBerlin = new Flight(LocalDateTime.of(2023, 7, 1, 20, 40, 0, 0), "Warsaw", "Berlin" , durationToBerlin);
        System.out.println(arrivalTimeCalculator.arrivalTime(flightToBerlin));
    }
}
