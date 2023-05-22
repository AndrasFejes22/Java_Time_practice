import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {

    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    private String startPlace;
    private String destination;

    private Duration duration;

    public Flight(LocalDateTime departureDateTime, String startPlace, String destination, Duration duration) {
        this.departureDateTime = departureDateTime;
        this.startPlace = startPlace;
        this.destination = destination;
        this.duration = duration;
    }

    public Flight(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (departureDateTime != null ? !departureDateTime.equals(flight.departureDateTime) : flight.departureDateTime != null)
            return false;
        return arrivalDateTime != null ? arrivalDateTime.equals(flight.arrivalDateTime) : flight.arrivalDateTime == null;
    }

    @Override
    public int hashCode() {
        int result = departureDateTime != null ? departureDateTime.hashCode() : 0;
        result = 31 * result + (arrivalDateTime != null ? arrivalDateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                '}';
    }
}
