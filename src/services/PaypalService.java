package services;

public class PaypalService implements OnlinePaymentService {

	double calc = 0.0;
	
	@Override
	public double interest(double amount, Integer months) {
		calc = amount + (amount * 0.01 * months);
		return calc;
	}

	@Override
	public double paymentFee(double amount) {
		double fee = calc * 0.02;
		return fee;
	}

}
