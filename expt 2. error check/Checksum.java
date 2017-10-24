package errorcheck;

public class Checksum {
    
    String input1, input2 ;
    
    Checksum(String x, String y){
        input1 = x;
        input2 = y;
    }
    
    
    void init(){
        int a1[]= new int[8];
        int a2[]= new int[8];
        int carry[]= new int[9];
        int checksum[]= new int[8];
        int total[]= new int[8];
        char b[] = new char[5];
        char c[]= new char[7];
        int incr[] = {0,0,0,0,0,0,0,1};
        b=input1.toCharArray();
        c=input2.toCharArray();
        int i;
        for(i=7;i>=0;i--){
            if(b[i] == '1')
                a1[i] = 1;
            else
                a1[i] = 0;
        }
        for(i=7;i>=0;i--){
            if(c[i] == '1')
                a2[i] = 1;
            else
                a2[i] = 0;
        }
        setcarry(carry);
        
        /*SEND CODE*/
        System.out.print("First message ");
        for(i=7;i>=0;i--){
            System.out.print(a1[i]);
        }
        System.out.print("\nSecond message ");
        for(i=7;i>=0;i--){
            System.out.print(a2[i]);
        }
        add(a1,a2,carry,checksum);
        if(carry[8]==1){
            setcarry(carry);
            add(checksum,incr,carry,checksum);
        }
        complement(checksum);
        System.out.print("\nChecksum generated ");
        for(i=7;i>=0;i--){
            System.out.print(checksum[i]);
        }
        
        
        /*RECEIVER*/
        
        System.out.print("\nFirst message received ");
        for(i=7;i>=0;i--){
            System.out.print(a1[i]);
        }
        System.out.print("\nSecond message received ");
        for(i=7;i>=0;i--){
            System.out.print(a2[i]);
        }
        System.out.print("\nChecksum received ");
        for(i=7;i>=0;i--){
            System.out.print(checksum[i]);
        }
        
        setcarry(carry);
        add(a1,a2,carry,total);
        for(i=7;i>=0;i--){
            carry[i]=0;
        }
        add(total,checksum,carry,total);
        
        if(carry[8]==1){
            setcarry(carry);
            add(total,incr,carry,total);
        }
        complement(total);
        System.out.print("\nChecksum at receiver's end ");
        for(i=7;i>=0;i--){
            System.out.print(total[i]);
        }
        System.out.println();
        
    }
    
    /* System.out.println(input+divisor);
        for(i=7;i>=0;i--){
            System.out.print(a[i]);
        }
        System.out.print("\nThis is char array ");
        for(i=7;i>=0;i--){
            System.out.print(c[i]);  */
    
        
    
    void convert(String input,int b[]){
        int i;
        char a[]=input.toCharArray();
        for(i=7;i>=0;i--){
            if(a[i] == '1')
                b[i] = 1;
            else
                b[i] = 0;
        }
    }
    
    void add(int a[],int b[],int c[],int sum[]){
        int i;
        for(i=7;i>=0;i--){
            sum[i]=a[i]+b[i]+c[i];
            if(sum[i]>1){
                sum[i]=sum[i]-2;
                c[i+1]=1;
            }
            
        }
          
    }
    
    void complement(int a[]){
        int i;
        for(i=7;i>=0;i--){
            if(a[i]==1)
                a[i]=0;
            else
                a[i]=1;
        }
    }
    
    void setcarry(int a[]){
        int i;
        for(i=7;i>=0;i--)
            a[i]=0;
    }
    
}