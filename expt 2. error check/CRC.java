package errorcheck;

import java.util.Scanner;

public class CRC {
    
    String input, divisor;
    
    CRC(String x, String y){
        input = x;
        divisor = y;
    }
    
    void print(){
        int inputLenght, divisorLenght;
        inputLenght = input.length();
        divisorLenght = divisor.length();
        char inputArrAppended[]= new char[divisorLenght+inputLenght-1];
        char divisorArr[] = new char[divisorLenght];
        char inputArr[]= new char[inputLenght];
        inputArr=input.toCharArray();
        divisorArr=divisor.toCharArray();
        int i;
        for(i=0;i <inputLenght;i++){
            inputArrAppended[i]=inputArr[i];
        }
        for(i=inputLenght; i<divisorLenght+inputLenght-1; i++){
            inputArrAppended[i] = '0';
        }
        System.out.println("This is appended array ");
        CRCDivide(inputArrAppended,divisorArr);
    }
    
    void CRCDivide(char input[], char divisor[]){
        char inputDiv[] = new char[input.length];
        char quotient[] = new char[input.length - divisor.length + 1];
        char remainder[] = new char[divisor.length -1];
        System.arraycopy(input, 0, inputDiv, 0, inputDiv.length);
        int i,j;
        for(i=0; i < input.length; i++){
            System.out.print(inputDiv[i]);
        }
        System.out.println();
        for(i=0; i<=(input.length - divisor.length); i++){
            if(inputDiv[i] == '1'){
                quotient[i] = '1';
                for(j=0; j < divisor.length; j++){
                    if(inputDiv[i+j] == divisor[j]){
                        inputDiv[i+j] = '0';
                    }
                    else{
                        inputDiv[i+j] = '1';
                    }
                }
            }
            else{
                quotient[i] = '0';
            }
        }
        for(i=(input.length - divisor.length + 1),j=0; i< input.length; i++,j++){
            remainder[j] = inputDiv[i];
        }
        System.out.println("Remainder");
        for(i=0; i < remainder.length; i++){
            System.out.print(remainder[i]);
        }
        System.out.println();
        System.out.println("Quotient");
        for(i=0; i < quotient.length; i++){
            System.out.print(quotient[i]);
        }
        System.out.println();
        System.out.println("The output message is");
        System.arraycopy(input, 0, inputDiv, 0, inputDiv.length - remainder.length);
        for(i=0; i < input.length; i++){
            System.out.print(inputDiv[i]);
        }
        System.out.println();
        checkCRC(inputDiv,divisor);
    }
    
    void checkCRC(char check[], char divisor[]){
        String inputStream;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the stream to send");
        inputStream = sc.next();
        char inputArr[] = new char[inputStream.length()];
        char remainder[] = new char[divisor.length -1];
        inputArr = inputStream.toCharArray();
        int i,j;
        for(i=0; i<=(inputArr.length - divisor.length); i++){
            if(inputArr[i] == '1'){
                for(j=0; j < divisor.length; j++){
                    if(inputArr[i+j] == divisor[j]){
                        inputArr[i+j] = '0';
                    }
                    else{
                        inputArr[i+j] = '1';
                    }
                }
            }
        }
        int checkValid = 0;
        for(i=(inputArr.length - divisor.length + 1),j=0; i< inputArr.length; i++,j++){
            if(inputArr[i] == '1'){
                checkValid = 1;
            }
            remainder[j] = inputArr[i];
        }
        if(checkValid == 1){
            System.out.println("Stream is invalid");
            System.out.println("Remainder");
            for(i=0; i < remainder.length; i++){
                System.out.print(remainder[i]);
            }
            System.out.println();
        }
        else{
            System.out.println("Stream is valid");
        }  
    }
}
