package OOP.Arithmetic_.binarySearch_;

/**
 * @author 寝
 * @version 2.0
 * @time 2023/8/11 12:35
 * 这样写可以在查找最左目标值的基础上完善返回值, 若未查找到目标值则返回该值应该存放的下标位置
 */
public class BinarySearchLiftMost2 {
    public static void main(String[] args) {

        int[] arr = {1,3,6,6,6,6,6,6,6,7,9};
        System.out.println(binarySearchLiftMost(arr, 4));
    }
    static int binarySearchLiftMost(int[] array, int target){
        int i = 0;
        int j = array.length - 1;
        int m ;
        while(i <= j){
            m = (i + j) >>> 1;
            if (array[m] >= target){
                j = m - 1;
            }else {
                i = m + 1;
            }
        }
        return i;

    }
}
