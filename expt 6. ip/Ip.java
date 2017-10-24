package ip;

import java.util.Scanner;

public class Ip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ip");
        int a[] = new int[4];
        for(int i=0;i<=3;i++){
            a[i]=sc.nextInt();
        }
        if( a[0] >= 0 && a[0] <= 126){
            System.out.println("Class A");
        }
        else if( a[0] >= 128 && a[0] <= 191){
            System.out.println("Class B");
        }
        else if( a[0] >= 192 && a[0] <= 223){
            System.out.println("Class C");
        }
        else if( a[0] >= 224 && a[0] <= 239){
            System.out.println("Class D");
        }
        else if( a[0] >= 240 && a[0] <= 254){
            System.out.println("Class E");
        }
        System.out.println("Enter 1 to enter subnet innet mask");
        int check = sc.nextInt();
        int subnet ;
        if(check == 1){
            System.out.println("Enter the subnet innet mask");
            subnet = sc.nextInt();
            System.out.println(subnet);
            Calculate c = new Calculate(a,subnet);
            c.print();
        }
        
    }
    
}
