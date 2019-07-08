
public class MinMaxProblem {

	public static void main(String[] args) {
		int arr[] = { 5, 4, 1, 3, 6, 1 };
		
		stuff(arr);
	}

	public static void stuff( int arr []) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minCount = 0;
		int maxCount = 0;
		int total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min) {
				minCount++;
			}
			
			if (arr[i] == max) {
				maxCount++;
			}
			
			if (arr[i] < min) {
				min = arr[i];
				minCount = 1;
			}
			
			
			if (arr[i] > max) {
				max = arr[i];
				maxCount = 1;
			}	
			
			total += arr[i];
		}
		
		total = total - (max*maxCount) - (min*minCount);
		
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
		System.out.println("Min Count: "+minCount);
		System.out.println("Max Count: "+maxCount);
		System.out.println("Total minus min & max: "+total);
		System.out.println();
	}
}
