
import java.util.Arrays;

public class FastSort{
	int[] A;
	int size;
	public  FastSort(int s,int [] array){
		this.A = new int[s];
		this.size = s;
		for(int i=0;i<s;i++){
			A[i]=array[i];
		}
	}
	public void fast_sort(int x,int y){
		int base = A[x];
		int lp=x;
		int rp=y;
		while(lp!=rp){
			for(int i=rp;i>lp;i--){
				if(base>A[i]){
					A[lp]=A[i];
					break;	
				}else rp--;
			}
			for(int j=lp;j<rp;j++){
				if(base<A[j]){
					A[rp]=A[j];
					break;
				} else lp++;		
			}

		}
		A[lp] = base;
		if(lp>x+1)fast_sort(x,lp-1);//闭区间
		if(y>lp+1) fast_sort(lp+1,y);
		
		
	}
	public void track(){
		
		System.out.println(Arrays.toString(A));
		
	}
	
	public static void main(String[] args) {
		// int [] array = new int[]{2,3,1,2,7,4} ;
		// int [] array = new int[]{2,3,1,2,7,4} ;
		int [] array = new int[]{1,2,3,4,5,6} ;
		// int [] array = new int[]{1,0} ;
		FastSort solution = new FastSort(6,array);
		solution.fast_sort(0,5);
		solution.track();
	}
}