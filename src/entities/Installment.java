package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate dueDate;
	private Double amount;
	
	public Installment() {
		
	}
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public Double getAmount() {
		return amount;
	}
	
	public String toString() {
		return fmt.format(getDueDate()) + " - " + String.format("%.2f", getAmount());
	}

}
