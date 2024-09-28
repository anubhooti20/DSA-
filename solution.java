import java.util.ArrayList;
import java.util.Arrays;

public class solution {
    public static int search(ArrayList<Integer> arr, int n, int target) {
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr.get(mid) == target) {
                return mid;
            }
            
            if (arr.get(low) <= arr.get(mid)) { // Left part is sorted
                if (arr.get(low) <= target && target <= arr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right part is sorted
                if (arr.get(mid) <= target && target <= arr.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = arr.size();
        int target = 5;
        int ans = search(arr, n, target);
        if (ans == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at " + ans);
        }
    }
}
