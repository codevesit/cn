import java.util.Scanner;
        class CRC
        {    public static void main(String args[])
          { 	  int i;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter number of bits of divisor : ");
                int divisorn = sc.nextInt();
                System.out.print("Enter number of bits to be sent : ");
                int n = sc.nextInt();
                int data[] = new int[n+divisorn-1];
                System.out.print("Enter the data bits one by one : ");
                for(i=0;i<n;i++)
                    data[i]=sc.nextInt();
	 int datatemp[] = data.clone();
                int divisor[] = new int[divisorn];
                System.out.print("Enter the divisor bits one by one : ");
                for(i=0;i<divisorn;i++)
                divisor[i]=sc.nextInt();
	int remain[] = divide(data,divisor);
	int code[] = new int[n+remain.length];
	for(i=0;i<n;i++)
	code[i]=datatemp[i];
	int k=i;
	for(i=0;i<remain.length;i++)
	code[k++]=remain[i];
	System.out.print("The data sent will be : ");
	for(i=0;i<code.length;i++)
	System.out.print(code[i]+" ");
	System.out.print("\nEnter the data received : ");
	int rec[] = new int[code.length];
	for(i=0;i<code.length;i++)
	rec[i]=sc.nextInt();
if(checkError(rec,divisor)==false) 	System.out.println("No errors found.");
	else 					System.out.println("Errors found.");		}
	public static int[] divide(int dividend[], int divisor[])
	{    int i,j,q=0,k;
	for(i=0;i<dividend.length&&(dividend.length-i)>=divisor.length;i++)
	if(dividend[i]==1)	
for(j=0,k=i;j<divisor.length&&k<dividend.length;j++,k++)
	if(divisor[j]==dividend[k])		dividend[k]=0;
	else					dividend[k]=1;
	int remain[] = new int[dividend.length-i];
	for(j=0;j<remain.length;j++,i++)
		remain[j]=dividend[i];
	return remain;  				 }
	public static boolean checkError(int rec[], int divisor[])
	{         int rem[] = divide(rec,divisor);
	for(int i=0;i<rem.length;i++)
	if(rem[i]==1)
	return true;
	return false; 					 }		}
