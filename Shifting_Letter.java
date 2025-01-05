public class Shifting_Letter {
    // 848. Shifting Letter I
    public String shiftingLettersI(String s, int[] shifts) {
        int shift = 0;
        char[] str = s.toCharArray();

        for (int i = str.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26; // to wrap around if goes beyond 26
            int index_str = str[i] - 'a';
            str[i] = (char) ((index_str + shift) % 26 + 'a'); // integer index to character
        }
        return new String(str);
    }

    // 2381. Shifting Letter II
    public String shiftingLetters(String s, int[][] shifts) {
        char[] str = s.toCharArray();
        int[] prefix_diff = new int[str.length + 1];
        for (int[] shift : shifts) {
            // left (0 - backward & 1 - forward )
            prefix_diff[shift[0]] += shift[2] == 1 ? 1 : -1;
            // right
            prefix_diff[shift[1] + 1] += shift[2] == 1 ? -1 : 1;
        }

        int sum = 0;

        for (int i = 0; i < str.length; i++) {
            sum = (sum + prefix_diff[i]) % 26; // wrap around if goes beyond 26
            if (sum < 0)
                sum += 26; // if sum -ve

            int index_str = str[i] - 'a';
            str[i] = (char) ((index_str + sum) % 26 + 'a'); // integer index to character
        }
        return new String(str);
    }

}
