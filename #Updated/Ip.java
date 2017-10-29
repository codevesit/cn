import java.io.*;
class Ip
{
public static void main(String args[])throws IOException
    {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter the ip ");
        String s =br.readLine();
        Boolean status = true;
        String[] parts=s.split("\\.");
        int num[] = new int[4];
		
        if(parts.length!=4)
            status =false;
        if(status)
        {
            for(int i=0 ; i<4 ; i++)
            {
                if(parts[i].length()!=1)
                {
                    if(parts[i].charAt(0) == '0')
                    {
                        status =false;
                        break;
                    }
                    else
                    {
                        if(parts[i].charAt(0) == '-')
                        {
                            status = false;
                            break;
                        }
                        else
                        {
                            num[i]=Integer.parseInt(parts[i]);
                            if(!(num[i]>0 && num[i] <=255))
                            {
                                status = false;
                                break;
                            }
                        }
                    }
                }
				else
				{
					
                            num[i]=Integer.parseInt(parts[i]);
                            if(!(num[i]>=0 && num[i] <=255))
                            {
                                status = false;
                                break;
                            }
                       
				}
            }
        }
		char c;
		c='A';
		int i =0;
        if(status)
            {
				if(num[i]>=0 && num[i]<=127)
					c='A';
				if(num[i]>=128 && num[i]<=191)
					c='B';
				if(num[i]>=192 && num[i]<=223)
					c='C';
				if(num[i]>=224 && num[i]<=239)
					c='D';
				if(num[i]>=240 && num[i]<=255)
					c='E';
				
				switch(c)
				{
					case 'A':
					{
						System.out.println("Class A");
						System.out.println("Default mask is "+num[0]+".255.255.255");
						System.out.println("Net id is "+num[0]+".0.0.0");
						
						System.out.println("First address is");
						System.out.println(num[0]+".0.0.0");
						System.out.println("Last address is");
						System.out.println(num[0]+".255.255.255");
						break;
					}
					case 'B':
					{
						System.out.println("Class B");
						System.out.println("Default mask is "+num[0]+"."+num[1]+".255.255");
						System.out.println("Net id is "+num[0]+"."+num[1]+".0.0");
						
						System.out.println("First address is");
						System.out.println(num[0]+"."+num[1]+".0.0");
						System.out.println("Last address is");
						System.out.println(num[0]+"."+num[1]+".255.255");
						break;
					}
					case 'C':
					{
						System.out.println("Class C");
						System.out.println("Default mask is "+num[0]+"."+num[1]+"."+num[2]+".255");
						System.out.println("Net id is "+num[0]+"."+num[1]+"."+num[2]+".0");
						
						System.out.println("First address is");
						System.out.println(num[0]+"."+num[1]+"."+num[2]+".0");
						System.out.println("Last address is");
						System.out.println(num[0]+"."+num[1]+"."+num[2]+".255");
						break;
					}
					case 'D':
					{
						System.out.println("Class D");
						break;
					}
					case 'E':
					{
						System.out.println("Class E");
						break;
					}
					
				}
			}
		else 
			System.out.println("In valid");
    }
}