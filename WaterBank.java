	 * Lab 2: WaterBank
	 * A class modeling a water tracker object that enables users
	 * to track Water intake
	 * @author <Khushi Patel>
	 * @version <1/31/2022>
	 */
	import java.util.Scanner;

	class WaterBank { //class declaration
	  int dailyGoal; //Instance variables/data fields
	  int waterIntake;
	  Scanner scan;
		
	  WaterBank() { //constructor
		  this.dailyGoal = 0;
		  this.waterIntake = 0;
	  } //end constructor 
	
	//Methods:
	  protected void newDay() {
		  //ask the user for daily goal in ounces
		  System.out.println("What is your daily goal?");
		  //Scanner scan = new Scanner(System.in);
		  this.dailyGoal = scan.nextInt();
		  //set input to daily goal
		  //set water intake to 0
		  this.waterIntake = 0;
		  //print new goal is input constant
		  System.out.println("Your daily goal is: " + this.dailyGoal + " cups.");
	  }
	  protected void recordWater() {
		  //ask user how much they drink
		  System.out.println("Enter how much water you drunk?");
		  //Scanner scan = new Scanner(System.in);
		  // set this to waterIntake instance variable
		  this.waterIntake = scan.nextInt();
		  //call report remaining 
		  this.reportRemaining();
	  }
	  protected String reportRemaining() {
		  //set input to waterIntake adding each waterIntake to itself 
		  int cups = (this.dailyGoal - this.waterIntake) % 8;
		  int ounces = (this.dailyGoal - this.waterIntake) / 8;
		  //compute the daily goal - water intake
		  //return the output integers, waterIntake and remaining daily goal with info string/message
		  // print total ounces or cup, ounces left
		  return("You have " + cups + " cup(s) and " + ounces + " ounce(s) left to drink.");
		  
	  }//end methods
		
	  
	  /**
	   * Enables the user to interact with the waterbank using the following commands:
	   * n: new day
	   * r: report remaining
	   * w: record water
	   * q: quit
	   * @param none
	   * @return none
	   * @author Andrea Tartaro
	   */
	  void interact() {
		  //Scanner scan = new Scanner(System.in);
		  String line;
		  do {	
			  System.out.println("WaterBank commands:");
			  System.out.println("\t n: new day");
			  System.out.println("\t r: report remaining");
			  System.out.println("\t w: record water");
			  System.out.println("\t q: quit");
			  line = scan.nextLine();
			  if (line.equals("n") || line.equals("N")) {
				  this.newDay();
			  } else if (line.equals("r") || line.equals("R")) {
				  this.reportRemaining();
			  } else if (line.equals("w") || line.equals("W")) {
				  this.recordWater();
			  }
		  } while (!(line.equals("q") || line.equals("Q")));
	  }
	  
	  public static void main(String[] args) {
	    WaterBank wb = new WaterBank();
	    wb.interact();
	  }
	}	
