public class FlightReservation extends Reservation{
    private Airport placeDeparture;
    private Airport placeArrival;

    public FlightReservation(String clientName, Airport placeDeparture, Airport placeArrival){
        super(clientName);
        int distance = Airport.getDistance(placeArrival, placeDeparture);
        if(distance == 0) {
            throw new IllegalArgumentException();
        }
        this.placeArrival = placeArrival;
        this.placeDeparture = placeDeparture;
    }


    public int getCost(){
        double distance = Airport.getDistance(placeArrival, placeDeparture);
        double fuelPrice = (distance/167.52)*1.24*100;
        double total = placeArrival.getFees() + placeDeparture.getFees() + fuelPrice + 53.75*100;

        int totalRounded = (int)total;

        if(total != totalRounded) {
            totalRounded++;
        }
        return totalRounded;
    }

    public boolean equals(Object objct){
        if(objct == this) {
            return true;
        }
        if(!(objct instanceof FlightReservation)) {
            return false;
        }
        FlightReservation reserve = (FlightReservation)objct;
        String clientName = reserve.reservationName();

        if(clientName.equals(this.reservationName()) == false) {
            return false;
        }

        int distanceA = Airport.getDistance(reserve.placeArrival, this.placeArrival);
        int distanceB = Airport.getDistance(reserve.placeDeparture, this.placeDeparture);

        if(distanceA!=0 || distanceB!=0) {
            return false;
        }
        return true;
    }
}
