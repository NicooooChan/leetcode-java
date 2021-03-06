/**
 * @ClassName ActivitySelect
 * @Description TODO
 * 贪心算法之活动选择
 * http://www.imooc.com/wiki/algorithmlesson/activityselect.html
 * @Author 陈急舟
 * @Date 2020/08/07 15:35:30
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class ActivitySelect {

    public static void main(String args[]){
        //活动集合a
        int a[] = {1,2,3,4,5,6,7,8,9,10,11};
        //活动开始时间集合s
        int s[] ={1,3,0,5,3,5,6,8,8,2,12};
        //活动结束集合f
        int f[] ={4,5,6,7,9,9,10,11,12,14,16};
        //活动选择存放集合A
        List<Integer> A =  new ArrayList<>();

        int n = s.length;
        A.add(a[0]);
        int k =0;

        //遍历选择活动
        for (int i=1; i<n; i++){
            if(s[i] >= f[k]){
                A.add(a[i]);
                k = i;
            }
        }

        System.out.println("活动选择问题的选择活动结果为：");
        System.out.println(A);

    }
}

