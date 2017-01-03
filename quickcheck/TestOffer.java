package quickcheck;

import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.somePairs;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.java.quickcheck.collection.Pair;

public class TestOffer {

	@Test
	public void testOffer(){
		OfferCalculation offer=new OfferCalculation();
		SoftAssert soft=new SoftAssert();
		boolean flag=false;
		for (Pair<Integer, List<Integer>> any : somePairs(integers(), lists(integers()))) {
			System.out.println("Checking for Value"+ any);
			for(int i=0;i<any.getSecond().size();i++){
			   if(offer.calculateAmount(any.getFirst(), any.getSecond().get(i))>0) flag=true;
			      soft.assertTrue(flag);
			}
			
		}
	}
	
	@Test
	public void testOfferConv(){
		OfferCalculation offer=new OfferCalculation();
		SoftAssert soft=new SoftAssert();
		boolean flag=false;
		for (Pair<Integer, List<Integer>> any : somePairs(integers(), lists(integers()))) {
			System.out.println("Checking for Value"+ any);
			for(int i=0;i<any.getSecond().size();i++){
			 int amount= offer.calculateConvFee(any.getFirst(), any.getSecond().get(i));
			 if(amount>any.getFirst()) flag=true;
			      soft.assertTrue(flag);
			}
			
		}
	}
	
	@Test
	public void testOfferConvAndDiscount(){
		OfferCalculation offer=new OfferCalculation();
		SoftAssert soft=new SoftAssert();
		boolean flag=false;
		for (Pair<Integer, List<Integer>> any : somePairs(integers(), lists(integers()))) {
			System.out.println("Checking for Value"+ any);
			for(int i=0;i<any.getSecond().size();i++){
			 int amount= offer.calculatefinalAmount(any.getFirst(), any.getSecond().get(i),any.getSecond().get(i+1));
			 if(amount>0) flag=true;
			      soft.assertTrue(flag);
			}
			
		}
	}

}
