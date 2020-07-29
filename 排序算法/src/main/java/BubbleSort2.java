import java.util.Arrays;

/**
 * @ClassName BubbleSort2
 * @Description 冒泡排序优化 数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
 * 设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
 * 这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去
 * @Author 陈急舟
 * @Date 2020/07/28 11:34:58
 * @Version 1.0
 */
public class BubbleSort2 {
    public static void sort(int... arr){
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int switchNums = 0;
            boolean flag = false;
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if(arr[j] > arr[j + 1]){
                    int a= arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                    flag = true;
                }
                switchNums ++;
                count ++;
            }
            System.out.println("第" + (i + 1) + "次循环,共交换" + switchNums + "次,结果：" + Arrays.toString(arr));
            if(!flag) {
                break;
            }
        }
        System.out.println("排序调用次数count：" + count);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {16, 5, 8, 9, 10};
        sort(arr);
    }
}
