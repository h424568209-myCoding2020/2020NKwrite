package Write1;
import java.util.*;
public class Main2 {
    //插入到第一个容量大于等于target的地方,在处理连续相同值时取从最左边开始遍历，标准的对半搜索做不到的，
    // （之前用Arrays.binarySearch怎么都不对，后来明白了）
    public static int findTOInsert(int[] nums, int target) {
        int low = 0, hig = nums.length - 1, mid;
        while (low <= hig) {
            mid = (low + hig) >>> 1;
            if (nums[mid] >= target) {
                hig = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static long getMaxProfit(int[] a, List<int[]> nums) {
        long sum = 0;
        int left = a.length;
        int k;
        boolean[] status = new boolean[a.length];
        for (int[] num : nums) {
            if (left == 0) break;
            else {
                k = findTOInsert(a, num[0]);
                while (k < a.length && status[k]) k++;
                if (k < a.length) {
                    status[k] = true;
                    left--;
                    sum += num[1];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            List<int[]> nums = new ArrayList<>(m);
            int b, c;
            for (int i = 0; i < m; i++) {
                b = sc.nextInt();
                c = sc.nextInt();
                nums.add(new int[]{b, c});
            }
            Arrays.sort(a);
            Collections.sort(nums, (int[] n1, int[] n2) -> n2[1] - n1[1]);
            System.out.println(getMaxProfit(a, nums));
        }
        sc.close();
    }
}