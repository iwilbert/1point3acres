
public class Problem2 {

	public boolean isPerm(String str1, String str2) {
		// edge cases: null, len not equal, len = 0
        if(str1 == null || str2 == null)
        	return false;
        int m = str1.length();
        int n = str2.length();
        if(m != n)
        	return false;
        if(m == 0)
        	return true;
        // count character occurrences
        int[] count = new int[256];
        for(int i = 0; i < m; i++)
        	count[str1.charAt(i)]++;
        for(int i = 0; i < n; i++)
        {
        	char c = str2.charAt(i);
        	count[c]--;
        	if(count[c] < 0)
        		return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "elhlo";
		System.out.print(new Problem2().isPerm(str1, str2));
	}
	
}
