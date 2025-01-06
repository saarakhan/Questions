public class Move_balls {
    // Brute Force O(n2)
    public static int[] minOperationsI(String boxes) {
        char[] box = boxes.toCharArray();
        int n = box.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            // find the postition where 1 exist
            for (int j = 0; j < n; j++) {

                if (box[j] == '1') {
                    res[i] += Math.abs(j - i);
                }
            }
        }
        return res;
    }

    // optimise O(n)
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ops=0, cnt=0; // count the number of balls and ops count moving ball
        int[] ans = new int[n];

        // left part  

        for(int i=0; i<n; i++) {
            ans[i] += ops;
            cnt += (boxes.charAt(i) == '1') ? 1 : 0;
            ops += cnt;
        }

        ops=0;
        cnt=0;
        // right part
        for( int i=n-1; i>=0; i--) {
            ans[i] += ops;
            cnt += (boxes.charAt(i) == '1') ? 1 : 0;
            ops += cnt;
        }

        return ans;
    }


    public static void main(String[] args) {
        String str = "001011";
    }
}
