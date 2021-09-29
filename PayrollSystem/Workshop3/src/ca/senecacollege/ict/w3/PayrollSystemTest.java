package ca.senecacollege.ict.w3;

/**********************************************
Workshop 3
Course: JAC444
Last Name: Kapila
First Name: Shivani
ID: 113561179
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 21/02/14
**********************************************/

public class PayrollSystemTest {
	
	public static void main(String[] args) {
	
		//create four objects of each subclass of Employee
		
		SalariedEmployee salariedEmployee = new SalariedEmployee("Tim", "Binburton", "111-111-111", 500.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Nyi", "Gusdon", "222-222-222", 10.23, 10);
		CommissionEmployee comissionEmployee = new CommissionEmployee("Lint", "Sylge", "333-333-333", 9000, .07);
		BasePlusCommisionEmployee basePlusComissionEmployee = new BasePlusCommisionEmployee("Wunye", "Insu", "444-444-444", 6000, .07, 500);
		
		System.out.println("\n------------------Print each Employee object individually; using toString------------------\n");
	
		System.out.printf("%s\n%s: $%,.2f\n\n",
				salariedEmployee, "earned", salariedEmployee.getPaymentAmount());
		System.out.printf("%s\n%s: $%,.2f\n\n",
				hourlyEmployee, "earned", hourlyEmployee.getPaymentAmount() );
		System.out.printf("%s\n%s: $%,.2f\n\n",
				comissionEmployee, "earned", comissionEmployee.getPaymentAmount());
		System.out.printf("%s\n%s: $%,.2f\n\n",
				basePlusComissionEmployee,"earned", basePlusComissionEmployee.getPaymentAmount() );
		
		//print each employee object polymorphically
		
		Employee employees[] = new Employee[4];
		
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = comissionEmployee;
		employees[3] = basePlusComissionEmployee;
		
		System.out.println("\n\n------------------Print each Employee object polymorphically------------------\n");

		for(Employee emp: employees) {
			
			if(emp instanceof BasePlusCommisionEmployee) {
				
				BasePlusCommisionEmployee employee = (BasePlusCommisionEmployee) emp;
				
				double salary = employee.getBaseSalary();
				employee.setBaseSalary(1.10 * salary);
				
				System.out.printf("Reward of additional 10 percent to base salary: $%,.2f\n", employee.getBaseSalary());
				
			}

			
			System.out.printf("%s %s: $%,.2f\n\n", emp, "\nearned", emp.getPaymentAmount());

		}
		
		//print specific class for each object
		
		System.out.println("\n\n------------------Determine specific class for each Employee object------------------\n");
		for(int i = 0; i < employees.length; i++) {
			System.out.printf("Employee " + i + " is of class " + 
					employees[i].getClass().getName() + "\n");
		}

	}

}
