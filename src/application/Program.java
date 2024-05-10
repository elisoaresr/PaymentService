package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;


public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Welcome to Payment Service.");
		System.out.println();
		System.out.println("Enter contract details below:");
		System.out.print("ID Contract: ");
		int id = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract amount: ");
		double amount = sc.nextDouble();
		System.out.print("Enter the number of installments: ");
		int n = sc.nextInt();

		Contract obj = new Contract(id, date, amount);
		ContractService service = new ContractService(new PaypalService());
		service.processContract(obj, n);

		System.out.println("Parcelas: ");
		for (Installment installment : obj.getInstalments()) {
			System.out.println(installment);
		}

		sc.close();

	}

}
