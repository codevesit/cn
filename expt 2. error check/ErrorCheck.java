package errorcheck;

import java.util.Scanner;

public class ErrorCheck {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int choice,exit=1;
        while(exit == 1){
            System.out.println("Enter your choice \n1.CRC\n2.Hamming Code\n3.CheckSum");
            choice = sc.nextInt();
            String input;
            switch(choice){
                case 1:
                    String divisor;
                    System.out.println("Enter the input and divisor");
                    input = sc.next();
                    divisor = sc.next();
                    CRC c = new CRC(input,divisor);
                    c.print();
                    break;
                case 2:
                    System.out.println("Enter the data bits");
                    input = sc.next();
                    Hamming h = new Hamming(input);
                    h.input();
                    break;
                case 3:
                    String input1,input2;
                    System.out.println("Enter the two messages");
                    input1 = sc.next();
                    input2 = sc.next();
                    Checksum check = new Checksum(input1,input2);
                    check.init();
                    break;
                default:
                    System.out.println("Wrong choice. You will pay for it.");
            }
            System.out.println("Enter 0 to exit");
            exit = sc.nextInt();
        }
    }
    
}
