
package coe528.lab1;

/**
 *
 * @author sameh
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int uniqueTicketNumber;
    private int ticketTracker;
    
    /**
     *
     * @param p
     * @param flight
     * @param price
     */
    public Ticket(Passenger p,Flight flight,double price){
    this.passenger = p;
    this.flight = flight;
    this.price = price;
    this.ticketTracker=++Ticket.uniqueTicketNumber;
    
    }
    
    /**
     * @return the passenger
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

     /**
     * @return the flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
     /**
     * @return the TicketTracker
     */
    public double getTicketTracker() {
        return this.ticketTracker;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        
        return passenger.getName() + ", "+
                "Flight " + flight.getFlightNumber() +
                ", " + flight.getOrigin() + " to " +
                flight.getDestination() + ", " +
                flight.getDepartureTime() +
                ", original price: $" +
                flight.getOriginalPrice() +
                ", price: $" + this.price;
     
    }
    
    
    
}
