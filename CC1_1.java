public class CC1_1 {

    // Improved Version
    public boolean isUnique(String line) {
        // edge cases: null, 0, >256
        if(line == null)
            return false;
        int len = line.length();
        if(len == 0)
            return true;
        if(len > 256)
            return false;
        // count as a flag, if true ==> it was seen before
        boolean[] count = new boolean[256];
        for(int i = 0; i < len; i++)
        {
            char c = line.charAt(i);
            if(count[c])
                return false;
            else
                count[c] = true;
        }
        return true;
    }

    /** Initialize Version
     *  jason51122 commented:
     *  1. There are 2 for loops in your program. You can use only one to achieve the same goal.
     *  2. You did not check the edge case when input is null.
     *  3. You should return the result directly if the length of string is 0 or bigger than 256.
     */
    public boolean isUnique_bad(String line) {
        int[] count = new int[256];
        for(int i = 0; i < line.length(); i++)
            count[line.charAt(i)]++;
        for(int i = 0; i < 256; i++) {
            if(count[i] > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String line = "fskfhsjkfhjskhfweryiuwryiwu";
        System.out.print(new CC1_1().isUnique(line));
    }

}
