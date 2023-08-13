package OOP.time.Datetime_;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 寝
 * @version 1.0
 * @time 2023/8/13 11:38
 */
public class DataTime {
    SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
    Date t = new Date();
    void showTime(){
        System.out.println(time.format(t));
    }

    public static void main(String[] args) {
        new DataTime().showTime();
    }
}
