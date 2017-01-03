package quickcheck;

import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someArrays;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.somePairs;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someMaps;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someSets;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someSortedLists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someUniqueValues;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static net.java.quickcheck.generator.PrimitiveGenerators.strings;
import static net.java.quickcheck.generator.PrimitiveGenerators.nonEmptyStrings;
import static net.java.quickcheck.generator.CombinedGenerators.maps;
import static net.java.quickcheck.generator.CombinedGenerators.sets;



import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import net.java.quickcheck.Generator;
import net.java.quickcheck.collection.Pair;

public class ValuesWhichYouCanGenerate {

	public static void main(String[] args) {
		
		//Generate List
	/*	for (List<Integer> any : someLists(integers())) {
			System.out.println(any);
		}*/
		//Generate array
		/*for (Integer[] arr : someArrays(integers(), Integer.class)) {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}

		//Generate Key Value where value is lis of value
		for (Pair<Integer, List<Integer>> any : somePairs(integers(), lists(integers()))) {
			System.out.println("Checking for Value" + any);
		}
		
		/*
		//Generate Key Value where value is lis of value
		for (Pair<Integer, Integer> any : somePairs(integers(), integers())) {
			System.out.println("Checking for Value" + any);
		}
		
		//Generate list of strings
		for(List<String> str: someLists(strings())){
			System.out.println(str);
		}
		
		
		
		//Generate unique strings
		for(String str: someUniqueValues(strings())){
			 System.out.println(str);
		}
		
		*/
		
	/*	////Generate Sorted list
		for(List<Integer> sortedList:someSortedLists(integers())){
			System.out.println(sortedList);
		}
		//Generate unique int
		for(int unique:someUniqueValues(integers())){
			System.out.println(unique);
		}*/
		/*
		//Generate unique string
		for(String uniqueStr:someUniqueValues(strings())){
			System.out.println(uniqueStr);
		}
		*/
		//Generate Non empty string
		/*for(String uniqueStr:someUniqueValues(nonEmptyStrings())){
			System.out.println(uniqueStr);
		}*/
		for(Set<Set<String>> map:someSets(sets(strings()))){
			System.out.println(map);
		}
		
	}
}
