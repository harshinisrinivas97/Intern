package sample;

import java.util.*;

public class denomination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2000,500,100,50,10};
		int tot[]= {0,0,0,0,0};
		int avail[]= {20,20,20,20,20};
		
		int n;
		int availnet=53200;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Enter the amount : ");
		int net=sc.nextInt();
		
		if(net>availnet || net<10) {
			System.out.println("Amount cannot be denominated");
		}
		else {
			System.out.println("The entered amount can be denominated as follows :");
			for(int i=0;i<arr.length;i++) {
				n=net/arr[i];
				if(n>avail[i]) {
					tot[i]=avail[i];
					net=net-(n*arr[i])+((n-avail[i])*arr[i]);
					avail[i]=0;
				}
				else {
					tot[i]=n;
					avail[i]-=tot[i];
					net-=n*arr[i];
				}
				if(net==0) {
					break;
				}
			}
			int total=0;
			System.out.println("Value\tNo.of notes\tTotal\tRem notes");
			for(int i=0;i<tot.length;i++) {
				total+=arr[i]*tot[i];
				System.out.println(arr[i]+" \t "+tot[i]+"\t\t "+(arr[i]*tot[i])+" \t "+(avail[i]));
			}
			
			availnet=0;
			for(int i=0;i<avail.length;i++) {
				availnet+=avail[i]*arr[i];
				tot[i]=0;
			}
			System.out.println("Remaining amount : "+availnet);
		}
		}while(availnet!=0);
	}

}
