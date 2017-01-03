package quickcheck;

import java.util.List;

public class VarianceCalcualtion {
    List<Integer> list;
    double meanvalue=0;
    double variance=0.0;
    double standardDeviation=0.0;
    
    /**
     * calculate Mean value.
     * @param list
     * @return
     */
    public double calculateMean(List<Integer> list){
    	int sum=0;
    	this.list=list;
    	for(int i=0;i<list.size();i++){
    		sum=sum+list.get(i);
    	}
    	meanvalue=sum/list.size();
    	return meanvalue; 
    }
	
    /**
     * Calcualte Variance
     * @return
     */
    public double calcualteVariance(){
    	for(int i=0;i<list.size();i++){
    		variance=variance+Math.pow(list.get(i)-meanvalue, 2);
    	}
    	variance=variance/list.size();
    	return variance;
    }
    
    /**
     * Calcualteb Standard deviation
     * @return
     */
    public double calculateStandardDeviation(){
    	
    	return Math.sqrt(variance);
    }
    
}
