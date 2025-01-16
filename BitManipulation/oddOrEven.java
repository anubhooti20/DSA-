public class oddOrEven {
    public static void solution(int n){
        int bitMask=1;
        if((n & bitMask)==0){
            //even number
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }
    public static void main(String args[]){
        solution(78);
        solution(43);
    }
}
