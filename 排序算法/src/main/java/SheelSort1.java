import java.util.Arrays;
/**
 * @ClassName SheelSort1
 * @Description 希尔排序
 * @Author 陈急舟
 * @Date 2020/08/04 10:50:17
 * @Version 1.0
 */
public class SheelSort1 {
    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i++) {
                sort(arr, gap, i);
            }
        }
    }

    public static void sort(int[] arr, int gap, int index) {
        int data = arr[index];
        int i;
        for (i = index - gap; i >= 0 && data < arr[i]; i = i - gap) {
            arr[i + gap]  = arr[i];
        }
        arr[i + gap] = data;
    }


    public static void main(String[] args) {
        int[] arr =  {42, 20, 17, 13, 28, 14, 23, 15};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
