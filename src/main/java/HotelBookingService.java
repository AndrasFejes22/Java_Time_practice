import java.time.Duration;
import java.util.List;

public class HotelBookingService {

    /**
     * TODO implement this method
     * Return the number of hotel bookings that have to be made for the given flights.
     * A hotel booking has to be made if the period between a flight's arrival and the next flight's departure
     * intersects a night.
     * <p>
     * The definition of a night is the period between 10pm and 5am.
     *
     *  * Visszaadja az adott járatokhoz szükséges szállodafoglalások számát.
     *      * Szállodafoglalást kell végezni, ha a járat érkezése és a következő járat indulása között eltelt idő...// két gép!!!
     *      * egy éjszakát metszik.
     *      * <p>
     *      * Az éjszaka definíciója az este 10 és reggel 5 óra közötti időszak.
     *
     * @param flights - list of flights
     * @return number of hotel bookings
     */
    // Flight(departureDateTime, arrivalDateTime  = indulas/erkezes)
    // Flight flight1 = new Flight(LocalDateTime.of(2022, Month.JANUARY, 14, 12, 5), LocalDateTime.of(2022, Month.JANUARY, 14, 23, 5));
    public int countHotelBookings(List<Flight> flights) { // TEST!!!!
        //Duration duration;
        int countBooking = 0;
        for (int i = 0; i < flights.size()-1; i++) {
                                //érkezés                                                // indulás
            if(flights.get(i).getArrivalDateTime().getHour() <= 22 && flights.get(i+1).getDepartureDateTime().getHour() >= 5 &&
                    (flights.get(i).getArrivalDateTime().getDayOfMonth() == flights.get(i+1).getDepartureDateTime().getDayOfMonth())){
                countBooking++;

            } else if (flights.get(i).getArrivalDateTime().getDayOfMonth() != flights.get(i+1).getDepartureDateTime().getDayOfMonth()){
                countBooking += flights.get(i+1).getDepartureDateTime().getDayOfMonth() - flights.get(i).getArrivalDateTime().getDayOfMonth();
                System.out.println("days: ");
                System.out.println(flights.get(i+1).getDepartureDateTime().getDayOfMonth());
                System.out.println(flights.get(i).getArrivalDateTime().getDayOfMonth());
            }
        }

        return countBooking;
    }
}
