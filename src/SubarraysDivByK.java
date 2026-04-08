import java.util.HashMap;
import java.util.Scanner;

public class SubarraysDivByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int rem = ((prefixSum % k) + k) % k;

            if (remainderCount.containsKey(rem)) {
                count += remainderCount.get(rem);
            }

            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        System.out.println(count);
    }
}
