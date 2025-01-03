public class No_ways_to_split {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 0 };
        int n = nums.length;
        int right_sum = 0; // total sum
        int total_splits = 0;

        // calculate total_sum
        for (int num : nums) {
            right_sum += num;
        }

        // decrease the sum from total_sum and check if 1st element , 2nd... > remaining
        // sum
        for (int i = 0; i < n; i++) {
            int left_sum = nums[i];
            right_sum -= nums[i]; // total_sum - index_el
            if (left_sum > right_sum) {
                total_splits++;
            }
        }
        System.out.println("Total number of splits = " + total_splits);
    }
}
