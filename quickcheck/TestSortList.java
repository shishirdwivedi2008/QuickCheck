package quickcheck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import net.java.quickcheck.collection.Pair;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.somePairs;


public class TestSortList {

	@Test
	public void sortedListCreation() {
		for (List<Integer> any : someLists(integers())) {
			System.out.println("Checking for Value"+ any);
			SortList sortedList = new SortList(any);
			List<Integer> expected = sort(any);
			Assert.assertEquals(expected, sortedList.toList());
		}
	}

	private List<Integer> sort(List<Integer> any) {
		ArrayList<Integer> sorted = new ArrayList<Integer>(any);
		Collections.sort(sorted);
		return sorted;
	}

	@Test
	public void collectionAdd() {
		for (Pair<Integer, List<Integer>> any : somePairs(integers(), lists(integers()))) {
			Integer element = any.getFirst();
			Collection<Integer> collection = any.getSecond();

			boolean changedCollection = false;
			boolean exceptionThrown = false;
			try {
				changedCollection = collection.add(element);
			} catch (Exception e) {
				assertException(e);
				exceptionThrown = true;
			}
			Assert.assertTrue(collection.contains(element) != exceptionThrown);
			Assert.assertTrue(changedCollection == containsInstance(collection, element));
		}
	}

	private void assertException(Exception e) {
		Assert.assertTrue(e instanceof UnsupportedOperationException || e instanceof ClassCastException
				|| e instanceof IllegalArgumentException || e instanceof IllegalStateException);
	}

	private boolean containsInstance(Collection<?> collection, Object element) {
		for (Object e : collection)
			if (e == element)
				return true;
		return false;
	}
}
