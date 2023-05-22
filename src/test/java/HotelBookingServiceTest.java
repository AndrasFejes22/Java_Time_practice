import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelBookingServiceTest {

    private HotelBookingService hotelBookingService;
    List<Flight> flights = new ArrayList<>();


    @BeforeEach
    void setUp() {
        this.hotelBookingService = new HotelBookingService();


        //Flight flight3 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 6, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 10, 6));
        //Flight flight4 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 12, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 21, 9));


        //flights.add(flight3);
        //flights.add(flight4);
    }

    @AfterEach
    void tearDown() {
        System.out.println("flights.size(): "+flights.size());
    }

    @Test
    void countHotelBookingsTwoFlightsOneNight() {
        Flight flight1 = new Flight(LocalDateTime.of(2022, Month.JANUARY, 14, 12, 5), LocalDateTime.of(2022, Month.JANUARY, 14, 20, 5));
        Flight flight2 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 15, 6, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 16, 6));
        flights.add(flight1);
        flights.add(flight2);

        assertEquals(1, hotelBookingService.countHotelBookings(flights));
    }

    @Test
    void countHotelBookingsTwoFlightsManyNights() {// departure/arrival
        Flight flight1 = new Flight(LocalDateTime.of(2022, Month.JANUARY, 14, 12, 5), LocalDateTime.of(2022, Month.JANUARY, 14, 20, 5));
        Flight flight2 = new Flight(LocalDateTime.of(2022, Month.FEBRUARY, 17, 6, 3), LocalDateTime.of(2022, Month.FEBRUARY, 15, 16, 6));
        flights.add(flight1);
        flights.add(flight2);

        assertEquals(3, hotelBookingService.countHotelBookings(flights));
    }

}