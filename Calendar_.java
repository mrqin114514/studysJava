package OOP.time.Calendar_;

import java.util.Calendar;

/**
 * @author 寝
 * @version 1.0
 * @time 2023/8/13 14:45
 */
public class Calendar_ {


    public static void main(String[] args) {
        Calendar n = Calendar.getInstance();
        System.out.println("年" + n.get(Calendar.YEAR));
        System.out.println("月" + n.get(Calendar.MONTH) + 1);  // 从0开始计算, 需要加1
        System.out.println("日" + n.get(Calendar.DAY_OF_MONTH));
        System.out.println("时" + n.get(Calendar.HOUR));  // 十二进制
        System.out.println("时" + n.get(Calendar.HOUR_OF_DAY));  // 二十四进制
        System.out.println("分" + n.get(Calendar.MINUTE));
        System.out.println("秒" + n.get(Calendar.SECOND));
        // Calendar没有提供专用的格式化方法, 需要程序员自己组合
    }
}
