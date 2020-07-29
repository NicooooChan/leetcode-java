import java.util.Arrays;

/**
 * @ClassName MpSort
 * @Description 冒泡排序
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 *
 * 过程：
 *
 * 比较相邻的两个数据，如果第二个数小，就交换位置。
 * 从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
 * 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
 * @Author 陈急舟
 * @Date 2020/07/28 09:45:27
 * @Version 1.0
 */
public class BubbleSort1 {
    public static void sort(int... arr){
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int switchNums = 0;
            for (int j = 0; j < (arr.length - i - 1); j++) {
                 if(arr[j] > arr[j + 1]){
                    int a= arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                 }
                switchNums ++;
                 count ++;
            }
            System.out.println("第" + (i + 1) + "次循环,共交换" + switchNums + "次,结果：" + Arrays.toString(arr));
        }
        System.out.println("排序调用次数count：" + count);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 9, 1};
        sort(arr);
    }
}
