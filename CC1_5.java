
public class CC1_5 {

	public String compress(String line) {
		int len = line.length();
		char prev = line.charAt(0);
		int cnt = 1;
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i < len; i++) {
			if(line.charAt(i) == prev)
				cnt++;
			else {
				sb.append(prev);
				sb.append(String.valueOf(cnt));
				prev = line.charAt(i);
				cnt = 1;
			}
		}
		sb.append(prev);
		sb.append(String.valueOf(cnt));
		String new_str = sb.toString();
		if(new_str.length() >= len)
			return line;
		else
			return new_str;
	}
	
	public static void main(String[] args) {
		String line = "abcdefghijkl";
		System.out.println(new CC1_5().compress(line));
	}

}
