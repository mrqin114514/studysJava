package OOP.Arithmetic_.binarySearch_;

/**
 * @author 寝
 * @version 1.0
 * @time 2023/8/4 19:58
 * 观看了人家老师写的代码, 发现好像可以优化, 但是写完了之后又什么感觉都没有, 不过确实也是简化了代码, 一条也是简化!
 */
public class BinarySearch {
    public static void main(String[] args) {
        final int[] array = {2, 5, 6, 7, 19, 23, 25, 28, 29, 34, 44, 77, 88 ,99};
        final int target = 99;

        int index = binarySearch(target, array);

        System.out.println(index);

        System.out.println(binarySearch(1, array));
    }
    public static int binarySearch(int target, int[] orderedArray){
        int i = 0;
        int j = orderedArray.length;

        while (i <= j) {
//            int m = (int)Math.floor((i+j) / 2.0);
            int m = (i + j) / 2;  // java中整数除法会自动取整, 不需要取整函数

//            if (orderedArray[m] == target) return m;

            if (target < orderedArray[m] ) j = m - 1;
            else if (orderedArray[m] < target) i = m + 1;
            else return m;
//            return -1;
        }
        return -1;
    }
    // 问题1, while判断条件为什么不能是<, 必须是<=?
    // 若i == j, 则会直接跳出循环, 导致漏判
    // 问题2, m = (i + j) / 2 有没有问题?
    // 若j的取值接近int能够表示的上限值, 则i + j很有可能会超过上限, 由正转负, 索引不能为负数, 就会暴露异常
    // 由正转负: java中没有无符号变量, 所以默认二进制表示的第一位为符号位, 0为正1为负, 当计算数字过大0就会被累加为1, 也就变成了负数
    /*
    通过<<<和>>>进行乘除运算
    8 >>> 1  : 0000 1000 -> 0000 0100, 过程中进行了除2操作
    8 <<< 1  : 0000 1000 -> 0001 0000, 过程中进行了除2操作
     */
    // 问题3, 为什么要都写成小于符号?
    // 因为你的数组是升序排列, 写成小于符号和数组方向一致, 给人一种统一感

}
