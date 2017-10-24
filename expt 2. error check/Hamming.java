package errorcheck;

import java.util.Scanner;

public class Hamming {
    String input;
    
    Hamming(String x){
        input = x;
    }
    
    void input(){
        char inputArr[] = new char[input.length()];
        inputArr = input.toCharArray();
        int i=2,valid = 0;
        int arrSize;
        while((Math.pow(2,i)-i-1) <= input.length()){
            if((Math.pow(2,i)-i-1) == input.length()){
                System.out.println("Data size is valid");
                valid = 1;
                arrSize = (int)(Math.pow(2,i) - 1);
                char hammingArr[] = new char[arrSize];
                makeHammingCode(hammingArr,inputArr,i);
            }
            i++;
        }
        if(valid == 0){
            System.out.println("Data is invalid");
        }
    }
    
    void makeHammingCode(char hammingArr[],char inputArr[],int bits){
        int i,j,k=bits-1;
        for(i=0,j=0; i < hammingArr.length; i++){
            if( i == (int)(hammingArr.length-Math.pow(2,k))){
                hammingArr[i]='0';
                k--;
            }
            else{
                hammingArr[i]=inputArr[j];
                j++;
            }
        }
        for(i=0; i < bits; i++){
            int count = (int)(hammingArr.length-Math.pow(2,i));
            int parity = count;
            int range = (int)(Math.pow(2,i));
            int countParity = 0;
            while (count >= 0){
                int countrange = range;
                while(countrange > 0){
                    
                    if(hammingArr[count] == '1'){
                        countParity++;
                    }
                    countrange--;
                    count--;
                }
                count = count - range;
            }
            if(countParity%2 == 0){
                hammingArr[parity]='0';
            }
            else{
                hammingArr[parity]='1';
            }
        }
        System.out.println("Hamming Code is:");
        for(i=0; i < hammingArr.length; i++){
            System.out.print(hammingArr[i]);
        }
        System.out.println();
        validate();
    }
    
    void validate(){
        String validateInput;
        System.out.println("Enter the input stream to verify");
        Scanner sc = new Scanner(System.in);
        validateInput = sc.next();
        char hammingArr[] = new char[validateInput.length()];
        hammingArr=validateInput.toCharArray();
        int i,valid = 0,k=2,bits;
        while(validateInput.length() >= (Math.pow(2,k)-k-1)){
            if((Math.pow(2,k)-k-1) == input.length()){
                bits = k;
                char errorBit[] = new char[bits];
                for(i=0; i < bits; i++){
                    int count = (int)(hammingArr.length-Math.pow(2,i));
                    int parity = count;
                    int range = (int)(Math.pow(2,i));
                    int countParity = 0;
                    while (count >= 0){
                        int countrange = range;
                        while(countrange > 0){

                            if(hammingArr[count] == '1'){
                                countParity++;
                            }
                            countrange--;
                            count--;
                        }
                        count = count - range;
                    }
                    if(countParity%2 != 0){
                        valid = 1;
                        errorBit[i] = '1';
                    }
                    else{
                        errorBit[i] = '0';
                    }
                }
                if( valid == 0){
                    System.out.println("No Error Detected");
                }
                else{
                    int position = 0;
                    System.out.print("Error detected at position from LSB:");
                    for(i=0; i < errorBit.length; i++){
                        if(errorBit[i] == '1'){
                            position = position + (int)(Math.pow(2, i));
                        }
                    }
                    System.out.println(position);
                }
                break;
            }
            k++;
        }
    }
}
