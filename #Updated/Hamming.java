import java.util.Scanner;
class Hamming
{	public static void main(String args[])
	{	Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of bits : ");
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int i;
		System.out.println("Enter "+n+" bits one by one : ");
		for(i=1;i<=n;i++)
			a[i] = sc.nextInt();
		int b[] = getCode(a,n);
		putParity(b,b.length);
		System.out.println("The Hamming Code is : ");
		for(i=1;i<b.length;i++)
			System.out.print(b[i]+" ");
		System.out.println("\nEnter the code received at the end : ");
		int c[] = new int[b.length];
		for(i=1;i<c.length;i++)
			c[i] = sc.nextInt();
		if(checkError(c,c.length)==0)
			System.out.println("Error not found.");
		else
			System.out.println("Error found at position : "+checkError(c,c.length));	}
	public static int[] getCode(int a[],int n)
	{	int b[],i=1,j=0,parity=0;
		while(i<=n)
		{	if(Math.pow(2,parity)==i+parity)	 parity++;
			else	i++;	}
		b=new int[parity+n+1];
		int k=1;
		for(i=1;i<b.length;i++)
			if(Math.pow(2,j)==i)
			{	b[i]=0;
				j++;	}
			else	b[i]=a[k++];
		return b;	}
	public static void putParity(int b[],int n)
	{	int i,j=0;
		for(i=1;i<n;i++)
			if(Math.pow(2,j)==i)
			{	if(checkOnes(i,b,n)%2==1)
					b[i]=1;
				j++;	}	}
	public static int checkOnes(int i,int b[],int n) 
	{	int k,l,ones=0;
		l=i;
		k=(2*l);
		while(l<n&&k<n)
		{	while(l<k)
			{	if(b[l]==1)	ones++;
				l++;	}
			l+=i;
			k+=(2*i);	}
		while(l<n)
		{	if(b[l]==1)	 ones++;
				l++;	}
		return ones;	}
	public static int checkError(int c[],int n)
	{	int i,j=0, bad=0;
		for(i=1;i<n;i++)
			if(Math.pow(2,j)==i)
			{	if(checkOnes(i,c,n)%2==1)	bad+=i;
				j++;	}
		return bad;	}		}

