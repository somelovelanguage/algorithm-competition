// dynamic programming
package dynamic;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
public class Dynamic {
	
	
	private  int pure_recursion(int[][]a){
		return pure_recursion_helper(a,0,0);
	}
	private  int pure_recursion_helper(@NotNull int[][]a, int i, int j){
		return a[i][j] + (i==a.length-1?0:Math.max(pure_recursion_helper(a,i+1,j),pure_recursion_helper(a,i+1,j+1)));
	}
	private int memory_recursion(@NotNull int[][]a){
		int [][] d = new int[a.length][a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<=i;j++){
				d[i][j]=-1;
			}

		}
		return memory_recursion_helper(a,d,0,0);
	}
	private int memory_recursion_helper(int [][]a, @NotNull int [][]d, int i, int j){
		if(d[i][j]==-1)return d[i][j]= a[i][j] + (i==a.length-1?0:Math.max(memory_recursion_helper(a,d,i+1,j),memory_recursion_helper(a,d,i+1,j+1)));
		return d[i][j];
	}
	private int reverse_recursion(@NotNull int[][]a){
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

		System.out.println("纯递归:"+solution.pure_recursion(arr));
		System.out.println("逆序、递归: "+solution.reverse_recursion(arr));
		System.out.println("记忆递归: "+solution.memory_recursion(arr));

	}
}
