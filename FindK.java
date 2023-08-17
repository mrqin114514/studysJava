public class FindK {
    public static void main(String[] args)
    {
        // 从一组N个数中, 确定第K个最大者, 输出
        double num = Algorithm1(new double[]{12,1.3,12,1.1,10,1.5,5.3,1.5,9.1,6.8,7.3}, 6);
        System.out.println(num);
        double number = Algorithm2(new double[]{12,1.3,12,1.1,10,1.5,5.3,1.5,9.1,6.8,7.3}, 6);
        System.out.println(number);

    }
    // Algorithm1, 通过冒泡排序等初级算法, 以递减的顺序排序, 返回第K个位置上的数
    public static double Algorithm1(double[] Array, int K)
    {
        for (int i = 1; i <= Array.length; i++)
        {
            for (int j = 0; j < Array.length - i; j++)
            {
                if (Array[j] < Array[j + 1])
                {
                    double temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
        }
        return Array[K - 1];
    }
    // Algorithm2, 将前K个元素读入数组, 并以递减的顺序对其排序, 接着将剩余的元素逐个读入,
    // 当新元素小于数组中的第K个元素则忽略之, 否则就将其放到数组正确的位置上, 并将最后一个元素挤出数组, 算法终止时, 将数组最后一个元素作为答案返回
    public static double Algorithm2(double[] array, int K)
    {
        double[] tempArray = new double[K];  // 创建一个长度为K的数组, 这样数组最后一位始终可以作为答案返回
        int sum = K;

        for (int n = 0; n < K; n++)  // 将原数组的前K个元素给到新数组中
        {
            tempArray[n] = array[n];
        }
        // 先由循环依次判断新数组最后一个元素与原数组剩余元素谁大谁小, 如果新数组没比过就进循环从后向前依次判断大小, 将其塞入正确位置并将K挤出新数组
        // 我忽略了一点, 数组创建之初我就没有对他们进行排序, 所以他们是乱序的, 这样比较是没有意义的
        // 我应该先对新数组进行排序
        for (int n = 1; n <= tempArray.length; n++)
        {
            for (int j = 0; j < tempArray.length - n - 1; j ++)
            {
                if (tempArray[n] < tempArray[n - 1])
                {
                    double temp = tempArray[n];
                    tempArray[n] = tempArray[n - 1];
                    tempArray[n - 1] = temp;
                }
            }
        }
        for (int n = 0; n < array.length - K; n++)
        {
            if (tempArray[K - 1] < array[K + n])
            {
                // 这里只需要循环新数组大小 - 1即可, 因为最后一位已经比完了, 没输是不会进到这里面的, 原数组只需要拿出array[K]来比
                // 如果想要节省循环次数, 可以考虑逆向遍历, 逆向遍历的话只需要考虑从下标K-1到下标0的方向即可, 不要想太多影响思考
                /*
                for (int j = K - 1; j >= 0; j--)
                {
                    if (tempArray[j] < array[K] & j != 0)  // 如果array[K]比它大, 但并不一定比后面所有大, 可以给一个计数变量, 用来记录下标
                    {
                        sum -= 1;  // 如果array[K]还是大那就让预定下标进一, 如果j
                    }
                    else if (tempArray[0] < array[K])  // 如果array[K]比所有数都打就将它放到下标0上
                    {
                        double temp = tempArray[0];
                        tempArray[0] = array[K];
                        for (int f = 1; f < K; f++)
                        {
                            double temp2 = tempArray[f];
                            tempArray[f] = temp;
                        }

                    }
                    else  // 既然能运行到else, 就说明array[K]不是最大的, 就可以进行赋值操作了
                    {

                    }

                }

                 */
                // 还是应该直接一点, 选择直接将temp Array[K - 1]替换掉, 重新进行一次排列,

                tempArray[K - 1] = array[K];
                for (int j = 0; j < K - 1; j++)
                {
                    for (int f = 0; f < K - 1 - j; f++)
                    {
                        if (tempArray[f] < tempArray[f + 1])
                        {
                            double temp = tempArray[f];
                            tempArray[f] = tempArray[f + 1];
                            tempArray[f + 1] = temp;
                        }
                    }
                }
            }
        }
        return tempArray[K - 1];
    }
}
