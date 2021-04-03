/**
 * URL: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
 * Tags: 
 * 
 * Best Time Complexity:
 * Best Space Complexity:
 */
import java.util.Arrays;

public class Array3kSmallest{

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Ans: " + sol.kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3) );
        System.out.println("------------------");
        System.out.println("Ans: " + sol.kthSmallest(new int[]{7, 10, 4, 20, 15}, 4) );
        System.out.println("------------------");
        System.out.println("Ans: " + sol.kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3) );
    }

}

class Solution{
    public static int kthSmallest(int[] arr, int k) 
    { 
        int n = arr.length;
        if(n <= 0 || n < k || k <= 0){
            //Invalid 
            return -1;
        }
        System.out.print("Given: " + Arrays.toString(arr));
        for(int i = n-1; i >= 0; i--){
            // System.out.print("\ni:" + i );
            minHeapify(arr, n, i);
        }
        System.out.println("\nHeap: " + Arrays.toString(arr));
        
        int heapSize = n;
        
        while(heapSize > 0 && heapSize >= n-k){
            int tmp = arr[0];
            arr[0] = arr[heapSize-1];
            arr[heapSize-1] = tmp;
            minHeapify(arr, heapSize -1, 0);
            heapSize--;
        }
        System.out.println("K-Sorted: " + Arrays.toString(arr));
        return arr[n-k];
    } 

    private static void minHeapify(int[] arr, int n, int i){
        int left = 2 * i + 1, right = 2 * i + 2;
        int smallest = i;
        if(left < n && arr[left] < arr[smallest]){
            smallest = left;
        }
        if(right < n && arr[right] < arr[smallest]){
            smallest = right;
        }
        if(i != smallest){
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            // System.out.print("\n\tchange: " + Arrays.toString(arr));
            minHeapify(arr, n, smallest);
        }else{
            // System.out.print("\n\tasis: " + Arrays.toString(arr));
        }
    }
}
