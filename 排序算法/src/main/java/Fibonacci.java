/**
 * @ClassName Fibonacci
 * @Description TODO
 * @Author 陈急舟
 * @Date 2020/08/07 10:00:13
 * @Version 1.0
 */
public class Fibonacci {

    public static void main(String[] args){
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(9));
        System.out.println(fibonacci(10));
    }

    //斐波那契数列数列的计算
    private static int fibonacci(int n){
        //如果是终止条件，按照要求返回终止条件对应结果
        if( n==1 || n==2 ){
            return 1;
        }else {
            //非终止条件，按照要求把大的问题拆分成小问题，调用自身函数递归处理
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

}
