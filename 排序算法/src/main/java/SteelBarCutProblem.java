/**
 * @ClassName SteelBarCutProblem
 * http://www.imooc.com/wiki/algorithmlesson/cutsteelrod.html 动态规划，钢条切割问题
 * @Description TODO
 * @Author 陈急舟
 * @Date 2020/08/07 14:46:34
 * @Version 1.0
 */
import java.util.Scanner;

public class SteelBarCutProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] r = new int[p.length];
        int[] s = new int[p.length];

        System.out.println("请输入1到" + (p.length - 1) + "之间任意一个自然数: ");
        int n = scanner.nextInt();

        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (q < (p[j] + r[i - j])) {
                    q = p[j] + r[i - j];
                    s[i] = j;
                }
            }
            r[i] = q;
        }

        System.out.println("长度为" + n + "米长的钢材最大切割收益为：" + r[n]);
        System.out.println("对应的具体每一段的切割长度如下：");
        while (n > 0) {
            System.out.println(s[n]);
            n = n - s[n];
        }
    }
}
