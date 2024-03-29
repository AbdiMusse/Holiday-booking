import java.util.*;

/**
 * This is a website class that allows a person to use the webiste and purchase holidays. 
 *
 * @author (Abdi-rahman Musse)
 * @version (16/11/2017)
 */
public class Website
{
    //This gives us the name of the website.
    private String websiteName;
    //This tells us the number of browsers who logged into the website.
    private int hits;
    //This tells us the total amount of money taken at the checkout .
    private double salesTotal;
    //This is an ArrayList of member which stores members who are logged in the website.
    private ArrayList<Member>loggedInList;
    //This holds the a new memberShip number for a new member
    private int biggestNumber;
    /**
     * Constructor for objects of class Website
     */
    public Website(String newWebsiteName)
    {
        // initialise instance variables
        websiteName = newWebsiteName;
        hits = 0;
        salesTotal = 0;
        loggedInList = new ArrayList<Member>();
        biggestNumber = 1;
    }
    
    /**
     * Default constructor for objects of class Website
     */
    public Website()
    {
        // initialise instance variables
        websiteName = "Club 18";
        hits = 8;
        salesTotal = 1500;
        loggedInList = new ArrayList<Member>();
        biggestNumber = 1;
    }
     
    /**
     * This allows a member to log in to the site
     */
    public void memberLogin(Member member)
    {
        member.setloginStatus(true);
        member.setWebsite(this);
        member.memberShipNumber();
        if (getBiggestNumber()  <= member.getMembershipNum())
        {biggestNumber += 1;
        }
        System.out.println (websiteName + " welcomes member " + member.getMembershipNum() 
        + ", you are now logged in.");
        hits = hits + 1;
        loggedInList.add(member);
    }
    
    /**
     * This prints out the detail of all memebers looged in the website
     */
    public void listMembersLoggedIn()
    {
        for (Member member : loggedInList)
        {
            System.out.println (member.toString());
        }
    }
    
    /**
     * This allows a member to logout of the site
     */
    public void memberLogOut(Member member)
    {
        member.setWebsite(null);
        member.setloginStatus(false);
    }
    
    /**
     * This allows the person to do a transaction of purchasing a holiday
     */
    public void checkOut(Member member)
    { 
        if (member.getLoginStatus() == true)
      {
          if (member.getHoliday() != null)
          {
             if (checkHitDiscount() == true)
            {
              System.out.println ("Thank you, your transaction has been completed.");
              System.out.println ("congratulations, you have a discount!!");
              double newPrice = member.getHoliday().getHolidayPrice()-(member.getHoliday().getHolidayPrice()/10);
              System.out.println ("Member " + member.getMembershipNum() +" has paid for a " 
              + member.getHoliday().getHolidayType() + " holiday which costs £" + newPrice + ".");
              salesTotal = salesTotal + newPrice;
              memberLogOut(member);
            }
            else
            {
              System.out.println ("Thank you, your transaction has been completed.");
              System.out.println ("Member " + member.getMembershipNum() +" has paid for a " 
              + member.getHoliday().getHolidayType() + " holiday which costs £" + member.getHoliday().getHolidayPrice() + ".");
              salesTotal = salesTotal + member.getHoliday().getHolidayPrice();
              memberLogOut(member);
           }
        }
        else
        {
            System.out.println("Please select a holiday before checking out.");
        }
      }
      else 
      {
        System.out.println ("Please log in before checking out and paying for holiday.");
      }
    }
    
    /**
     * This allows us to change the name of the website
     */
    public void setWebsiteName(String newWebsiteName)
    {
        websiteName = newWebsiteName;
    }
    
    /**
     * This allows us to change the number of browsers who logged into the website
     */
    public void setNumberOfhits(int newhits)
    {
        hits = newhits;
    }
    
    /**
     * This allows us to change the total amount of money paid in the checkout
     */
    public void setSalesTotal(double newSalesTotal)
    {
        salesTotal = newSalesTotal;
    }
    
    /**
     * This checks if a discount is available
     */
    public boolean checkHitDiscount()
    {
      int is10thPerson = hits;
      is10thPerson = is10thPerson % 10;
      if (is10thPerson == 0)
      {
            return true;
      }
      else 
      {
            return false;
      } 
    }
    
    /**
     * This tells us how many people are presently logged in the website
     */
    public int numberOfUsers()
    {
        return loggedInList.size();
    }
    
    /**
     * This returns the name of the website
     */
    public String getWebsiteName()
    {
        return websiteName;
    }
    
    /**
     * This returns the number of browsers who logged into the website
     */
    public int getNumberOfhits()
    {
        return hits;
    }
    
    /**
     * This returns the total amount of money paid in the checkout
     */
    public double getSalesTotal()
    {
        return salesTotal;
    }
    
    /**
     * This gives us the MemberShipNumber of the last person.
     */
    public int getBiggestNumber()
    {
        return biggestNumber;
    }
}