
package coe528.lab1;
import java.util.ArrayList;
/**
 *
 * @author sameh
 */
public class Manager {
    private ArrayList<Flight> Flights = new ArrayList<Flight>();
    private ArrayList<Ticket> Tickets = new ArrayList<Ticket>(); ;
    
    /**
     *
     */
    public void createFlights(){
    
        Flights.add(new Flight(1000,"Toronto","Montreal","07/13/2020 9:00 pm", 5,8500.10));
        Flights.add(new Flight(1200,"Montreal","Ottawa","08/14/2020 8:05 am", 3,10000.1));
       
   
     }
   
    /**
     *
     * @param origin
     * @param destination
     */
    public void displayAvailableFlight(String origin, String destination){
        int x = 0;
         for(Flight testFlight: Flights){
            if(testFlight.getnumberOfSeatsLeft() > 0 && testFlight.getOrigin().equals(origin) && testFlight.getDestination().equals(destination) ){
                System.out.println(testFlight);
                x = 1;
                
            }
     }
            if(x==0){
            System.out.println("No flights available");
            
            
        }
     }
     
    /**
     *
     * @param flightNumber
     * @return
     */
    public Flight getFlight(int flightNumber){
        for(Flight testFlight : Flights){
            if(testFlight.getFlightNumber() == flightNumber){
                return testFlight;
            }
        }
        return null; 
    }

    /**
     *
     * @param flightNumber
     * @param p
     */
    public void bookSeat(int flightNumber, Passenger p){
        Flight testFlight = this.getFlight(flightNumber);
        if (testFlight.bookASeat()){
            double finalPrice= (p.applyDiscount(testFlight.getOriginalPrice()));
            Tickets.add(new Ticket(p,testFlight,finalPrice));
        }
 
     }
       /* In this main method I attempt to show the cases in which all methods are used. I create 3 passengers with different ages and with 2 being a member and 1 being a non member.
         One of the member has 5 + years and the other has 1 + year of membership. With all the possible passenger options I display a Montreal to Ottawa flight which has 3 tickets.
         Then I let all the 3 passengers book a seat in this plane and then display their information including the amount their each paying after the various discounts. Finally I display the 
         flights available from Montreal to Ottawa given and given that all 3 tickets are taken it should display that their are no more available flights. 
         */

    /**
     *
     * @param args
     */

     public static void main(String args[]){
        Manager manager = new Manager();
        Passenger[] traveler = new Passenger[4];
        traveler[0] = new Member("John",23,1);
        traveler[1] = new Member("Tom",32,6);
        traveler[2] = new Member("Tim",70,6);
        traveler[3] = new NonMember("Hank",67);
        manager.createFlights();
        manager.displayAvailableFlight("Montreal","Ottawa");
        manager.bookSeat(1200, traveler[3]);
        manager.bookSeat(1200, traveler[1]);
        manager.bookSeat(1200, traveler[2]);
        System.out.println(manager.Tickets.get(0).toString());
        System.out.println(manager.Tickets.get(1).toString());
        System.out.println(manager.Tickets.get(2).toString());
        manager.displayAvailableFlight("Montreal","Ottawa");
        
    }
     
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

