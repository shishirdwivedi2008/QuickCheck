package quickcheck;

import org.testng.Assert;
import org.testng.annotations.Test;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.CombinedGeneratorsIterables;
import net.java.quickcheck.generator.PrimitiveGenerators;
import net.java.quickcheck.generator.support.IntegerGenerator;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;

import java.util.Iterator;
import java.util.List;

import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.somePairs;

public class TestAmount {

	@Test
	public void checkAmount(){
	  AmountCalculation amount=new AmountCalculation();
	  Generator<Integer> itr= (IntegerGenerator) PrimitiveGenerators.integers();	
	  for(int i=0;i<1000;i++){
		  int amount1=itr.next();
		  System.out.println(amount1);
		  int finalamount=amount.calculateAmount(amount1);
		  if(finalamount>amount1) 
			  Assert.assertTrue(true);
		  else{
			  Assert.assertTrue(false);
		  }
	  }
	}
}
