package ca.senecacollege.ict.w3;

public class BasePlusCommisionEmployee extends CommissionEmployee{

	private double baseSalary;

	public BasePlusCommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double comissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, comissionRate);
	
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		
		try {
			if (baseSalary <= 0.0) {
				
				this.baseSalary = baseSalary;
				
			}
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
		
	}
	
	public double getPaymentAmount() {
		
		return (getCommissionRate() * getGrossSales()) + baseSalary;
	}
	
	@Override
	public String toString() { 
		return String.format( "%s %s; %s: $%,.2f", 
				"Base Plus", super.toString(), 
				"Base Salary", getBaseSalary() ); 
	}

	
}
