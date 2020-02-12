package Write1;

import java.util.ArrayList;

public class Solution {
    //输入n个整数，找出最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length== 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            list.add(input[i]);
        }
        for(int i = k ; i < input.length;  i++){
            int num = this.max(list);
            int tmp = list.get(num);
            if(input[i] < tmp){
                list.set(num,input[i]);
            }
        }
        return list;
    }

    private int max(ArrayList<Integer> list) {
        int max = list.get(0);
        int j = 0 ;
        for(int i = 1 ; i < list.size() ; i++) {
            if(list.get(i) > max){
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},2));
    }
}
