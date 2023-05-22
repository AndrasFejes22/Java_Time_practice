public class FlightAssignment {

    private Flight flight;
    private String crewCode;

    public FlightAssignment(Flight flight, String crewCode) {
        this.flight = flight;
        this.crewCode = crewCode;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getCrewCode() {
        return crewCode;
    }

    public void setCrewCode(String crewCode) {
        this.crewCode = crewCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightAssignment that = (FlightAssignment) o;

        if (flight != null ? !flight.equals(that.flight) : that.flight != null) return false;
        return crewCode != null ? crewCode.equals(that.crewCode) : that.crewCode == null;
    }

    @Override
    public int hashCode() {
        int result = flight != null ? flight.hashCode() : 0;
        result = 31 * result + (crewCode != null ? crewCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FlightAssignment{" +
                "flight=" + flight +
                ", crewCode='" + crewCode + '\'' +
                '}';
    }
}
