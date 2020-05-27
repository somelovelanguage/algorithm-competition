// dynamic programming


import java.util.Random;
public class Dynamic {
	
	
	private  int pure_recursion(int[][]a){
		return pure_recursion_helper(a,0,0);
	}
	private  int pure_recursion_helper( int[][]a, int i, int j){
		return a[i][j] + (i==a.length-1?0:Math.max(pure_recursion_helper(a,i+1,j),pure_recursion_helper(a,i+1,j+1)));
	}
	private int reverse_recursion(int[][]a){
		int [][] d = new int[a.length][a.length];
		for(int j=0;j<a.length;j++)d[a.length-1][j]=a[a.length-1][j];
		for(int i=a.length-2;i>-1;i--){
			for(int j=0;j<=i;j++){
				d[i][j]=a[i][j]+Math.max(d[i+1][j],d[i+1][j+1]);
			}

		}
		return d[0][0];
	}

	public static void main(String[] args) {
		int n = 3;
		int [][]arr = new int[n][n];
		// int i2 = r.nextInt(18) - 3; // 生成[-3,15]区间的整数
		Random r = new Random();
	 	Dynamic solution = new Dynamic();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=r.nextInt(15);
				}
		}

		System.out.println(solution.pure_recursion(arr));
		System.out.println(solution.reverse_recursion(arr));

	}
}
