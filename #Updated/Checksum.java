import java.util.Scanner;
class Checksum
{	public static void main(String args[])
	{	Scanner sc = new Scanner(System.in);
		int i;
		System.out.print("Enter the number of bits to be sent : ");
		int n = sc.nextInt();
		int data[] = new int[n];
		System.out.print("Enter the data bits one by one : ");
		for(i=0;i<n;i++)
		data[i]=sc.nextInt();
		int checksum[] = generateChecksum(data);
		System.out.println("Checksum generated = ");
		for(i=0;i<checksum.length;i++)
		System.out.print(checksum[i]+" ");
		int[] datasent = new int[n+checksum.length];
		System.arraycopy(data,0,datasent,0,data.length);
		System.arraycopy(checksum,0,datasent,data.length,checksum.length);
		System.out.println("\nData Sent = ");
		for(i=0;i<datasent.length;i++)
		System.out.print(datasent[i]+" ");
		System.out.print("\nEnter data received : ");
		int rec[] = new int[datasent.length];
		for(i=0;i<rec.length;i++)
		rec[i]=sc.nextInt();
		if(checkError(rec)==false)
			System.out.println("No errors found.");
		else
			System.out.println("Errors found.");	 	}
	public static int[] generateChecksum(int data[])
	{	int a[] = new int[data.length/2],b[] = new int[(data.length/2)],i,c=0;
		System.arraycopy(data,0,a,0,(data.length/2));
		System.arraycopy(data,data.length/2,b,0,(data.length/2));
		int s[] = sumcomp(a,b);
		return s;		 }
	public static boolean checkError(int rec[])
	{	int a[] = new int[rec.length/3], b[] = new int[rec.length/3], c[] = new int[rec.length/3],i,carry=0;
		System.arraycopy(rec,0,a,0,rec.length/3);
		System.arraycopy(rec,rec.length/3,b,0,rec.length/3);
		System.arraycopy(rec,2*rec.length/3,c,0,rec.length/3);
		int suma[] = new int[a.length];
		for(i=a.length-1;i>=0;i--)
		{ 	suma[i]=a[i]^b[i]^carry;
			carry=(a[i]&b[i])|(b[i]&carry)|(carry&a[i]);	 }
		suma = sumcomp(suma,c);
		for(i=0;i<suma.length;i++)
		{	if(suma[i]==1)
			return true;	 }
		return false;	 }
	public static int[] sumcomp(int a[], int b[])
	{	int c=0, s[] = new int[a.length],i;
		for(i=a.length-1;i>=0;i--)
		{ 	s[i]=a[i]^b[i]^c;
			c=(a[i]&b[i])|(b[i]&c)|(c&a[i]);	}
		for(i=0;i<s.length;i++)
			if(s[i]==0)
				s[i]=1;
			else
				s[i]=0;
		return s;	 }	}