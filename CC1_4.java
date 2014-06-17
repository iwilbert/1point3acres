
public class CC1_4 {

	public void replace(char[] line) {
		int len;					// original length;
		int cnt = 0;				// space count
		for(len = 0; line[len] != '\0'; len++)
		{
			if(line[len] == ' ')
				cnt++;
		}
		int new_len = len + cnt*2;	// length of new string
		int k = new_len - 1;		// starts from the end of new string
		for(int i = len - 1; i >= 0; i--)		// i starts from the end of original string
		{
			if(line[i] == ' ')
			{
				line[k] = '0';
				line[k-1] = '2';
				line[k-2] = '%';
				k -= 2;
			}
			else
				line[k] = line[i];
			k--;
		}
    }
	
	public static void main(String[] args) {
		char[] line = new char[10];
		line[0] = 'A';
		line[1] = ' ';
		line[2] = 'B';
		line[3] = ' ';
		line[4] = 'C';
		System.out.println(line);
		new CC1_4().replace(line);
		System.out.println(line);
	}
	
}
