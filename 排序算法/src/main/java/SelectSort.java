import java.util.Arrays;

/**
 * @ClassName SelectSort1
 * @Description 选择排序
 * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
 * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
 * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
 * 平均时间复杂度：O(n2)
 * @Author 陈急舟
 * @Date 2020/07/28 13:16:16
 * @Version 1.0
 */
public class SelectSort {
    public static void sort(int... arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = (i + 1); j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {42, 20, 17, 13, 28, 14, 23, 15};
        sort(arr);
    }
}
