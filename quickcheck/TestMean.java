package quickcheck;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.somePairs;

public class TestMean {

	@Test
	public void testMeanCalculation() {
		boolean flag;
		for (List<Integer> any : someLists(integers(0, 10))) {
			System.out.println("Checking for Value" + any);

			VarianceCalcualtion var = new VarianceCalcualtion();
			double meanValue = var.calculateMean(any);
			Collections.sort(any);
			int least = any.get(0);
			int max = any.get(any.size() - 1);
			if (meanValue < max && meanValue > least)
				flag = true;
			else
				flag = false;
			Assert.assertTrue(flag);
		}
	}
	@Test
	public void testMeanCalculationForNegativeValues(){
		boolean flag;
		for (List<Integer> any : someLists(integers(Integer.MIN_VALUE, 0))) {
			System.out.println("Checking for Value" + any);

			VarianceCalcualtion var = new VarianceCalcualtion();
			double meanValue = var.calculateMean(any);
			Collections.sort(any);
			int least = any.get(0);
			int max = any.get(any.size() - 1);
			if (meanValue > max && meanValue < least)
				flag = true;
			else
				flag = false;
			Assert.assertTrue(flag);
		}
	}
	
	@Test
	public void testMeanCalculationForAnyValues(){
		boolean flag;
		for (List<Integer> any : someLists(integers())) {
			System.out.println("Checking for Value" + any);

			VarianceCalcualtion var = new VarianceCalcualtion();
			double meanValue = var.calculateMean(any);
			Collections.sort(any);
			int least = any.get(0);
			int max = any.get(any.size() - 1);
			if (meanValue > max && meanValue < least)
				flag = true;
			else
				flag = false;
			Assert.assertTrue(flag);
		}
	}
}
