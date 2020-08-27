/**
 * @ClassName Knapsack
 * @Description TODO
 * 背包问题 贪心算法
 * http://www.imooc.com/wiki/algorithmlesson/knapsackproblem.html
 * @Author 陈急舟
 * @Date 2020/08/07 15:49:25
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {

    /**
     * 物品内部类
     */
    private static class Item implements Comparable<Item>{
        int type;
        double weight;
        double value;
        double unitValue;

        public Item(int type, double weight){
            this.type = type;
            this.weight = weight;
        }

        public Item(int type, double weight,double value){
            this.type = type;
            this.weight = weight;
            this.value = value;
            this.unitValue = value/weight;
        }

        @Override
        public int compareTo(Item o) {
            return Double.valueOf(o.unitValue).compareTo(this.unitValue);
        }
    }

    public static void main(String[] args){
        //背包容量
        double capacity = 30;
        //物品类型初始化数组
        int[] itemType = {1,2,3,4,5};
        //物品重量初始化数组
        double[] itemWeight = {10,5,15,10,30};
        //物品价值初始化数组
        double[] itemValue = {20,30,15,25,10};

        //初始化物品
        List<Item> itemList = new ArrayList<>();
        for(int i=0;i<itemType.length;i++){
            Item item = new Item(itemType[i],itemWeight[i],itemValue[i]);
            itemList.add(item);
        }
        //物品按照单价降序排序
        Collections.sort(itemList);

        //背包选择
        List<Item> selectItemList = new ArrayList<>();
        double selectCapacity = 0;
        for(Item item : itemList){
            if( (selectCapacity + item.weight) <= capacity){
                selectCapacity = selectCapacity + item.weight;
                Item selectItem = new Item(item.type,item.weight);
                selectItemList.add(selectItem);
            }else {
                Item selectItem = new Item(item.type, capacity-selectCapacity);
                selectItemList.add(selectItem);
                break;
            }
        }

        //选择结果输出
        for (Item item : selectItemList){
            System.out.println("选择了类型："+ item.type+" 的物品，重量为："+item.weight);
        }

    }
}

