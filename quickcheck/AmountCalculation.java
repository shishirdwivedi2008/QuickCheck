package quickcheck;

public class AmountCalculation {
	
	public int calculateAmount(int amount){
		if(amount<0)
			return -1;
		else{
			int add=(int)(Math.random()*1000);
		    return amount+add;
		}
	}

}
