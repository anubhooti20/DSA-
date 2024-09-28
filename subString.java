public class subString {
    public static String substring(String str,int si,int ei){
        String substr="";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }

    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' '&&i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
            }
            return sb.toString();
      }

    public static String compress(String str){
        String newStr="";
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i) ==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr+=str.charAt(i);
            if(count>1){
                newStr+=count.toString();
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        // String str="HelloWorld";
        // System.out.println(str.substring(0,5));
        //System.out.println(substring(str, 0, 6));
        // String fruits[]={"apple","mango","banana"};

        // String largest=fruits[0];
        // for(int i=1; i<fruits.length; i++){
        //     if(largest.compareTo(fruits[i])<0){
        //         largest=fruits[i];
        //     }
        // }
        // System.out.println(largest);



        // StringBuilder sb=new StringBuilder("");
        // for(char ch='a';ch<='z';ch++){
        //     sb.append(ch);
        // }
        // //O(26)
        // //O(n^2)
        // System.out.println(sb.length());


        // String str="hi, i am anubhooti";
        // System.out.println(toUpperCase(str));

        String str="aaabbcccdd";
        System.out.println(compress(str));
    }
    
}
