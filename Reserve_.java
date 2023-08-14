package OOP.homwork02.reserve;

/**
 * @author 寝
 * @version 1.0
 * @time 2023/8/14 13:11
 * 将字符串中指定内容进行反转, abcde -> adcbe
 */
public class Reserve_ {
    String reserve (String element, int startIndex, int lastIndex){
        if (element.length() <= 1){
            return element;
        }
        char[] arr = element.toCharArray();

        int middle = (lastIndex - startIndex) >>> 1;
        for (int i = 0; i < middle; i++) {
//            char temp = arr[i + startIndex];
            char end = arr[lastIndex - 1 - i];
            arr[lastIndex -1 - i] = arr[i + startIndex];
            arr[i + startIndex] = end;
        }
        String s = new String(arr);
        return s;
    }

    public static void main(String[] args) {
        Reserve_ a = new Reserve_();
        String s = a.reserve("abcde", 1, 4);  // start是闭区间, last是开区间
        System.out.println(s);
    }

}
