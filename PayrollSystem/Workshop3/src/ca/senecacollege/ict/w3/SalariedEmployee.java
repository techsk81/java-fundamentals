package ca.senecacollege.ict.w3;

public class SalariedEmployee extends Employee{
	
	private double weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		
		this.weeklySalary = weeklySalary;

	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		try {
			if (weeklySalary <= 0.0) {
				
				this.weeklySalary = weeklySalary;
				
			}
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
	}
	
	public double getPaymentAmount() {
		
		return getWeeklySalary();
	}
    
	@Override
	public String toString() { 
		return String.format( "Salaried Employee: %s %s: $%,.2f}",
	super.toString(), "Salary {weekly salary", getWeeklySalary());
	}

	

}
