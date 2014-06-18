
public class CC1_7 {

	/** Time: O(M*N), Space: O(1)
	 *  Algorithm: 
	 *  1. mark first_row_zero = true / first_col_zero = true if first row / column has 0s
	 *  2. if row i has 0s, mark matrix[i][0] = 0 (1 <= i < M)
	 *  3. if column j has 0s, mark matrix[0][j] = 0 (1 <= j < N)
	 *  4. matrix[i][j] = 0 if matrix[i][0] = 0 || matrix[0][j] = 0 (1 <= i < M, 1 <= j < N)
	 *  5. matrix[i][0] = 0 if first_row_zero = true, matrix[0][j] = 0 if first_col_zero = true
	 */
	public void zero(int[][] matrix) {
		if(matrix == null)
			return;
		int m = matrix.length;
		if(m == 0)
			return;
		int n = matrix[0].length;
		boolean first_row_zero = false;
		boolean first_col_zero = false;
		// mark first_col_zero = true if first column has 0s
		for(int i = 0; i < m; i++)
			if(matrix[i][0] == 0)
			{
				first_col_zero = true;
				break;
			}
		// mark first_row_zero = true if first row has 0s
		for(int j = 0; j < n; j++)
			if(matrix[0][j] == 0)
			{
				first_row_zero = true;
				break;
			}
		// Step 2 & 3
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		// Step 4
		for(int i = 1; i < m; i++)
			for(int j = 1; j < n; j++)
			{
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		// Step 5
		if(first_row_zero)
		{
			for(int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}
		if(first_col_zero)
		{
			for(int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
	}
	
	/** Time: O(M*N), Space: O(M+N)
	 *  Algorithm: use two arrays to mark if row / column has 0s.
	 */
	public void zero_old(int[][] matrix) {
		if(matrix == null)
			return;
		int m = matrix.length;
		if(m == 0)
			return;
		int n = matrix[0].length;
		boolean[] row_zero = new boolean[m];
		boolean[] col_zero = new boolean[n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
			{
				if(matrix[i][j] == 0)
				{
					row_zero[i] = true;
					col_zero[j] = true;
				}
			}
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
			{
				if(row_zero[i] || col_zero[j])
					matrix[i][j] = 0;
			}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,0,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
		new CC1_7().zero(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
	}

}
