
import java.util.Arrays;

public class Solution{
	int[] A;
	int[] T;
	int size;
	public  Solution(int s,int [] array){
		this.A = new int[s];
		this.T = new int[s];
		this.size = s;
		for(int i=0;i<s;i++){
			A[i]=array[i];
		}
	}
	public void merge_sort(int x,int y){
	//左闭右开
		if(y-x>1){
			int m = x+(y-x)/2;
			int p = x,q=m,i=x;
			merge_sort(x,m);
			merge_sort(m,y);
			while(p<m || q<y){
				if(q>=y || (p<m&&A[p]<=A[q]))T[i++]=A[p++];
				else T[i++]=A[q++];
			}
			for(i=x;i<y;i++)A[i]=T[i];
		}
	}
	public void track(){
		
		System.out.println(Arrays.toString(A));
		
	}
	
	public static void main(String[] args) {
		// int [] array = new int[]{2,3,1,2,7,4} ;
		// int [] array = new int[]{2,3,1,2,7,4} ;
		int [] array = new int[]{1,0} ;
		Solution solution = new Solution(2,array);
		solution.merge_sort(0,2);
		solution.track();
	}
}