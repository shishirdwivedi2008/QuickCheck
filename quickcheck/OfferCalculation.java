package quickcheck;

public class OfferCalculation {

	
	public int calculateAmount(int amount, int offeramount){
		return amount-offeramount;
	}
	
	public int calculateConvFee(int amount, int conFee){
		return amount+conFee;
	}
	
	public int calculatefinalAmount(int amount, int confee, int discount){
		return amount-discount+confee;
	}
}
