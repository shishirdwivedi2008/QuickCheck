package quickcheck;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestStandardDeviation {

	@Test
	public void testSD() {
		SoftAssert soft = new SoftAssert();
		boolean flag;
		for (List<Integer> any : someLists(integers(0, 1000000))) {
			System.out.println("Checking for Value" + any);

			VarianceCalcualtion var = new VarianceCalcualtion();
			double meanValue = var.calculateMean(any);
			double varianceValue = var.calcualteVariance();
			double sd = var.calculateStandardDeviation();
			if (varianceValue > meanValue && sd < meanValue && sd < varianceValue)
				flag = true;
			else
				flag = false;
			soft.assertTrue(flag);
		}
	}

	@Test
	public void testSDWithAnyValue() {
		SoftAssert soft = new SoftAssert();
		boolean flag;
		for (List<Integer> any : someLists(integers())) {
			System.out.println("Checking for Value" + any);

			VarianceCalcualtion var = new VarianceCalcualtion();
			double meanValue = var.calculateMean(any);
			double varianceValue = var.calcualteVariance();
			double sd = var.calculateStandardDeviation();
			if (varianceValue > meanValue && sd < meanValue && sd < varianceValue)
				flag = true;
			else
				flag = false;
			soft.assertTrue(flag);
		}
	}
}
