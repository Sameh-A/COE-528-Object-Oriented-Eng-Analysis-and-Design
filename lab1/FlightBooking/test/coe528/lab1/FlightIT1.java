package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Sameh Ahmed
 */
public class FlightIT1 {
    
    private Flight test;
    
    @Before
    public void setUp() {
        test = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm", 10, 1000.0);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
        test = null;
    }

    
    /**
     * Test of constructor method, of class Flight.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        test = new Flight(1030,"Toronto","Kolkata","03/02/99 7:50 pm", 10, 1000);
        assertEquals("Toronto", test.getOrigin());
        assertEquals("Kolkata", test.getDestination());
      
     
    }
    
    /**
     * Test of InvalidConstructor method, of class Flight
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        System.out.println("InvalidConstructor");
        test = new Flight(1030,"Toronto","Toronto","07/13/2020 3:30 pm", 7, 1000.0);
        System.out.println("test works");
        
        
    }
    
    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        int resultX = 1030;
        int resultY = test.getFlightNumber();
        assertEquals(resultX, resultY);
         // TODO review the generated test code and remove the default call to fail.
          System.out.println("test works");
    }
    
     /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int resultX = 1030;
        test.setFlightNumber(resultX);
        assertEquals(resultX, test.getFlightNumber());
         System.out.println("test works");
    }
    
    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        String resultX = "Toronto";
        String resultY = test.getOrigin();
        assertEquals(resultX, resultY);
         // TODO review the generated test code and remove the default call to fail.
          System.out.println("test works");
    }
    
      /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String resultX = "Toronto";
        test.setOrigin(resultX);
        assertEquals(resultX, test.getOrigin());
        System.out.println("test works");
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        String resultX = "Kolkata";
        String resultY = test.getDestination();
        assertEquals(resultX, resultY);
     // TODO review the generated test code and remove the default call to fail.
          System.out.println("test works");
    }
    
      /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String resultX = "Toronto";
        test.setDestination(resultX);
        assertEquals(resultX, test.getDestination());
        System.out.println("test works");
    }


    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        String resultX = "03/02/99 7:50 pm";
        String resultY = test.getDepartureTime();
        assertEquals(resultX, resultY);
     // TODO review the generated test code and remove the default call to fail.
        System.out.println("test works");
    }
    
       /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String resultX = "07/12/2020 1:20 am";
        test.setDepartureTime(resultX);
        assertEquals(resultX, test.getDepartureTime());
        System.out.println("test works");
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        int resultX = 10;
        int resultY = test.getCapacity();
        assertEquals(resultX, resultY);
     // TODO review the generated test code and remove the default call to fail.
        System.out.println("test works");
    }
      
    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int resultX = 1030;
        test.setCapacity(resultX);
        assertEquals(resultX,test.getCapacity());
         // TODO review the generated test code and remove the default call to fail.
        System.out.println("test works");
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        int resultX = 10;
        int resultY = test.getnumberOfSeatsLeft();
        assertEquals(resultX, resultY);
        System.out.println("test works");
    }
    
    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int resultX = 120;
        test.setnumberOfSeatsLeft(resultX);
        assertEquals(resultX,test.getnumberOfSeatsLeft());
         // TODO review the generated test code and remove the default call to fail.
        System.out.println("test works");
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        double resultX = 1000.0;
        double resultY = test.getOriginalPrice();
        assertEquals(resultX, resultY, 0.0);
        System.out.println("test works");
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double resultX = 1000.1;
        test.setOriginalPrice(resultX);
        assertEquals(resultX,test.getOriginalPrice(),0.0);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("test works");
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
        public void testBookASeat() {
        System.out.println("bookASeat");
         boolean resultX =true;       
        test.setnumberOfSeatsLeft(100);
         assertEquals(resultX, test.bookASeat());
         // TODO review the generated test code and remove the default call to fail.
         System.out.println("test works");
    }

  
    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String resultX = "Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price: $1000.0";
        String resultY = test.toString();
        assertEquals(resultX, resultY);
         // TODO review the generated test code and remove the default call to fail.
         System.out.println("test works");
       
        
    }
}