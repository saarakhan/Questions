public class Unique_3_length_palindrome {
    public int countPalindromicSubsequence(String s) {
        // set to store each element
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int cnt = 0;
        for (char c : uniqueChars) {
            // first and last index of char
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);

            // hashset -> chars between left and right index and unique
            HashSet<Character> mid_char = new HashSet<>();
            if (left != right) { // if both the index are different
                for (int i = left + 1; i < right; i++) {
                    mid_char.add(s.charAt(i)); // add every unique element to set mid_char
                }
            }
            cnt += mid_char.size();
        }
        return cnt;
    }
}
