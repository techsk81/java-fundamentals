package ca.senecacollege.ict.w3;

public class CommissionEmployee extends Employee {

	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double comissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		
		this.grossSales = grossSales;
		this.commissionRate = comissionRate;
	}
	
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		
		try {
			if (grossSales <= 0) {
				
				this.grossSales = grossSales;
			}
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
		
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setComissionRate(double comissionRate) {
		
		try {
			if (comissionRate > 0.0 && comissionRate < 0.1) {
				
				this.commissionRate = comissionRate;
				
			}
		} catch (ArithmeticException e) {
			
			System.out.println(e);
		}
	}
	
	public double getPaymentAmount() {
		
		return commissionRate * grossSales;
	}
	
	@Override
	public String toString() { 
		return String.format( "%s: %s %s: $%,.2f; %s: %.2f}", 
				"Comission Employee", super.toString(), 
				"Comission {Gross Sales", getGrossSales(), 
				"Commission Rate", getCommissionRate() ); 
	} 

	
	

}
