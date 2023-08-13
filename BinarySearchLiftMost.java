package OOP.Arithmetic_.binarySearch_;

/**
 * @author 寝
 * @version 1.0
 * @time 2023/8/11 12:35
 */
public class BinarySearchLiftMost {
    public static void main(String[] args) {

        int[] arr = {1,3,6,6,6,6,6,6,6,7,9};
        System.out.println(binarySearchLiftMost(arr, 6));
    }
    static int binarySearchLiftMost(int[] array, int target){
        int i = 0;
        int j = array.length - 1;
        int m ;
        int candidate = -1;
        while(i <= j){
            m = (i + j) >>> 1;
            if (array[m] == target){
                candidate = m;
                j = m - 1;
            }
            if (array[m] < target){
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
        return candidate;

    }
}
