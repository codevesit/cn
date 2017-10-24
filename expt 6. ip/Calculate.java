
package ip;


public class Calculate {
    int ip[],subnet;
    Calculate(int a[], int s){
        ip = a;
        subnet = s;
    }
    
    void print(){
        for(int i=0;i<ip.length;i++){
            System.out.println(ip[i]);
        }
    }
}
