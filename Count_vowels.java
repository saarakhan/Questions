public class Count_vowels {
    static boolean isEqual(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    // O(n + q)
    public static int[] optimize(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;

        // prefix sum array
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < n; i++) { // O(n)
            prefixSum[i + 1] = prefixSum[i]; // same value as prev if start & end are not vowel
            if (isEqual(words[i].charAt(words[i].length() - 1)) && isEqual(words[i].charAt(0))) {
                prefixSum[i + 1]++;
            }
        }

        int[] res = new int[m];
        for (int i = 0; i < queries.length; i++) { // O(q)
            res[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }
        return res;
    }

    // 93/94 Testcase pass O(n+n) = O(n)
    public static void BruteForce() {
        String[] words = { "a", "e", "i" };
        int n = words.length;
        Boolean[] isVowel = new Boolean[n];
        int[][] queries = { { 0, 2 }, { 0, 1 }, { 2, 2 } };
        int[] res = new int[queries.length];

        for (int i = 0; i < n; i++) {
            if (isEqual(words[i].charAt(words[i].length() - 1)) && isEqual(words[i].charAt(0))) {
                isVowel[i] = true;
            } else {
                isVowel[i] = false;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] first_el = queries[i];
            int li = first_el[0], ri = first_el[1];
            int count = 0;
            for (int j = li; j <= ri; j++) {
                if (isVowel[j] == true) {
                    count++;
                }
            }
            res[i] = count;
        }
    }
}