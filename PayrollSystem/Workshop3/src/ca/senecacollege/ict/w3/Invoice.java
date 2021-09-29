package ca.senecacollege.ict.w3;

public class Invoice implements Payable {

	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public double getPaymentAmount() {
		return getPricePerItem();
		
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public String toString() {
		
		return String.format("%s %s %d %,.2f", "Part Number: ", getPartNumber(), "Part Description: ",
				getPartDescription(), "Quantity: ", getQuantity(), "Price per Item: ", getPricePerItem());
	}
	
}
