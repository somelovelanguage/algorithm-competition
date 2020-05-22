import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.Scanner; 

public class SPMS{
	int stu_num_g=0;
	int[] removed_g= new int[100];
	Student [] students_g = new Student[100];
	public class Student{
		int Chinese;
		int Math;
		int English;
		int Programming;
		String name;
		int Sid;
		int Cid;
	}
	public void add(){
		Student s = new Student();
		int sid,cid,name,Chinese,Math,English,Programming;
		System.out.println("Please enter the SID,CID,name and four scores.Enter 0 to finish");//以英文逗号分隔,依次为sid,cid,name,chinese,math,english,programming
		Scanner sc = new Scanner(System.in); 
	    String enter = sc.nextLine();  //读取字符串型输入 
	    try{
	    	String[] split = enter.split(",");//以逗号分割
		    // int i = Integer.valueOf(my_str).intValue();
			s.Chinese = Integer.valueOf(split[3]).intValue();
			s.Math = Integer.valueOf(split[4]).intValue();
			s.English = Integer.valueOf(split[5]).intValue();
			s.Programming = Integer.valueOf(split[6]).intValue();
			s.Cid = Integer.valueOf(split[1]).intValue();
			s.Sid = Integer.valueOf(split[0]).intValue();
			s.name = split[2];
	    }catch(Exception e){

	    }
	

		students_g[stu_num_g++] = s;
		System.out.println("students'num "+stu_num_g);
	}
	public void dq(int isq){//isq ,1，查询；0，删除；
		while(true){
			int sid=-1;//暂时没用这个
			String name;
			System.out.println("Please enter SID or name .Enter 0 to finish");//输入姓名吧
			Scanner sc = new Scanner(System.in); 
	    	name = sc.nextLine();  //读取字符串型输入
	    	// System.out.println("you just enter "+name);
	    	// 用equals方法比较的是字符串的内容是否相同
	    	if(name.equals("0")||stu_num_g==0)break ;
			for(int i=0;i<stu_num_g;i++){
				// System.out.println("students_g[i].name="+students_g[i].name+" name="+name+" removed_g[i]="+removed_g[i]);
				if(removed_g[i]!=1 && (students_g[i].Sid==sid || students_g[i].name.equals(name))){
					if(isq==1){
						int tot = total(i);
						int average = tot/4;
						int r = rank(i);
						System.out.println("Grade-ranking  sid  cid  name  chinese  math  english  programming\n"+r+"  "+String.valueOf(students_g[i].Sid)+"  "+String.valueOf(students_g[i].Cid)+"  "+students_g[i].name+"  "+String.valueOf(students_g[i].Chinese)+"  "+String.valueOf(students_g[i].Math)+"  "+String.valueOf(students_g[i].English)+"  "+String.valueOf(students_g[i].Programming));
					}
					else{
						removed_g[i]=1;
						stu_num_g--;
						System.out.println("xx student removed");
					}
				}
			}
		}

	}
	public void stat(){
		System.out.println("Please enter class ID,0 for the whole statistics");
		int choice;
		Scanner sc = new Scanner(System.in); 
		String enter = sc.nextLine();  //读取字符串型输入
		choice = Integer.valueOf(enter).intValue();
		print_stat(choice);
	}
	public void print_stat(int choice){
		int Chinese_Score = 0;
		int Math_Score = 0;
	
		for(int i=0;i<stu_num_g;i++){
			if(choice!=0){
				if(removed_g[i]!=1 && students_g[i].Cid==choice){
				Chinese_Score+=students_g[i].Chinese;
				Math_Score += students_g[i].Math;
				}
			}else{
				if(removed_g[i]!=1 ){
				Chinese_Score+=students_g[i].Chinese;
				Math_Score += students_g[i].Math;
			
				}
			}
		}
		System.out.println("Chinese\nAverage Score:"+Chinese_Score/stu_num_g+"\nMath\nAverage Score:"+Math_Score/stu_num_g+"\n");

		
	}
	public int rank(int id){
		int tot = total(id);
		int count=1;
		for(int i=0;i<stu_num_g;i++){
			if(removed_g[i]!=1 && total(i)>tot)count++;
		}
		return count;
	}
	public int total(int i){
		return students_g[i].Chinese + students_g[i].Math+students_g[i].Programming + students_g[i].English;
	}
	public void print_menu(){
		System.out.println("Welcome to Student Performance Management System\n\n1-Add\n2-Remove\n3-Query\n4-Show ranking\n5-Show Statistics\n0-Exit");
	}
	public static void main(String[] args) {
		SPMS spms = new SPMS();
		int exit=0;
		while(exit!=1){

			spms.print_menu();
	      	Scanner sc = new Scanner(System.in); 
	      	int choice = sc.nextInt();
	      	sc.nextLine();
	    	// String choice = sc.nextLine();  //读取字符串型输入  
			if(choice==1)spms.add();
			if(choice==2)spms.dq(0);
			if(choice==3)spms.dq(1);
			if(choice==4)System.out.println("it hurts students' self-esteem,dont do that");
			if(choice==5)spms.stat();
			if(choice==0)exit=1;
		}
	}
}
