package coe528.lab1;

/**
 *
 * @author sameh
 */
public class Member extends Passenger{
   
    private int yearsOfMembership;
    
    /**
     *
     * @param name
     * @param age
     * @param yearsOfMembership
     */
    public Member(String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
   
    @Override
    public double applyDiscount(double p){
        if(this.yearsOfMembership > 5){
            return p*0.5;
        }else if(p > 1){
            return p*0.9;
        }else{
            return p;
        }
    }
    
}