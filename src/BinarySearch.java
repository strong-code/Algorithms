import java.util.Arrays;
//import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		
		//Fill our array with random numbers
//		Random r = new Random();
//		for (int i = 0; i < 10; i++) {
//			arr[i] = r.nextInt(15);
//		}
		
		Arrays.sort(arr);
		System.out.println(findElem(5, arr));
	}
	
	public static int findElem(int key, int array[]) {
		int low = 0;
		int high = array.length-1;
		
		while (high >= low) {
			int mid = low + (high - low)/2;
			
			if (key < array[mid]) {
				high = mid-1;
			} else if (key > array[mid]) {
				low = mid+1;
			} else return mid;
		}
		
		return -1; //if our key is not in the list
	}

}