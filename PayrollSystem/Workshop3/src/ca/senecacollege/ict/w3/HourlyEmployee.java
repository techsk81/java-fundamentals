package ca.senecacollege.ict.w3;

public class HourlyEmployee extends Employee {
	
	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		this.wage = wage;
		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		try {
			if (wage <= 0.0) {
				
				this.wage = wage;
				
			}
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		
		try {
			if (hours > 0.0 && hours < 168.0) {
				
				this.hours = hours;
				
			}
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
		this.hours = hours;
	}
 
	public double getPaymentAmount() {
		
		if(getHours() <= 40) {
			
			return getWage() * getHours();
		} else {
						
			return 40 * getWage()  + (getHours()-40) * getWage()  * 1.5;
		}
		
	}
	
	@Override
	public String toString() { 
		return String.format( "Hourly Employee: %s %s: $%,.2f; %s: %,.2f}",
				super.toString(), "{Wage", getWage(), "Hours", getHours() ); 
	}
	
	

}
