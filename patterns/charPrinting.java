public class charPrinting {
    public static void main(String args[]){
        int n=4;
        char ch='A';

        //outer loop
        for(int line =0; line<=n;line++){
            for(int chars=1;chars<=line;chars++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
