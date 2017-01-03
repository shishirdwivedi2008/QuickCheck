package quickcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

	private List<Integer> list;

	public SortList(List<Integer> list) {
		this.list = new ArrayList<Integer>(list);
		sort(list);
	}

	
	/**
	 * Faulty implementation of Sort
	 * @param list
	 * @return
	 */
	public List<Integer> sort(List<Integer> list){
		for(int i=0;i<list.size()-1;i++){
			if(list.get(i)>list.get(i+1)){
				int temp=list.get(i);
				list.set(i,list.get(i+1));
				list.set(i+1, temp);
			}
		}
		
		return null;
	}
	public List<Integer> toList() {
		return list;
	}
}
