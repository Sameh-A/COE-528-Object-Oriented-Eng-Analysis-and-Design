package coe528.lab1;

/**
 *
 * @author Sameh Ahmed
 */
public class Flight {
    
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    /**
     *
     * @param flightNumber
     * @param origin
     * @param destination
     * @param departureTime
     * @param capacity
     * @param originalPrice
     */
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
        if(origin.equals(destination)){
            throw new IllegalArgumentException("Destination and Origin cannot be the same"); //If origin is the same as destination, no flight is needed
        }
        //initialize instance variables
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice;
    }
        
     /**
     *
     * @return
     */
    public int getFlightNumber() {
        return this.flightNumber;
    }

    /**
     *
     * @param flightNumber
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     *
     * @return
     */
    public String getOrigin() {
        return this.origin;
    }

    /**
     *
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     *
     * @return
     */
    public String getDestination() {
        return this.destination;
    }

    /**
     *
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     *
     * @return
     */
    public String getDepartureTime() {
        return this.departureTime;
    }

    /**
     *
     * @param departureTime
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     *
     * @return
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return
     */
    public double getOriginalPrice() {
        return this.originalPrice;
    }

    /**
     *
     * @param originalPrice
     */
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    /**
     *
     * @return
     */
    public int getnumberOfSeatsLeft() {
        return this.numberOfSeatsLeft;
    }

    /**
     *
     * @param numberOfSeatsLeft
     */
    public void setnumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
   
    /**
     *
     * @return
     */
    public boolean bookASeat(){
        if(this.numberOfSeatsLeft > 0){
            this.numberOfSeatsLeft--;
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
       
      return "Flight "
              + this.flightNumber 
              + ", " + this.origin 
              + " to " + this.destination 
              + ", " + this.departureTime 
              + ", original price: $" 
              + this.originalPrice;
        
    }
    
}