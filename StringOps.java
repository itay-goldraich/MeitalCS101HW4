import org.junit.platform.commons.util.LruCache;

/*** you may only use the following String functions
1.  str.charAt(int i);
2.  str.length();
3.  str.substring(int start);
4.  str.substring(int start,int end);
*/
public class StringOps {
    public static void main(String[] args) {
        System.out.println(trim("aaaababaaaa",'a'));
        System.out.println(trim("aaaaaaaaaa",'a'));
        System.out.println(trim("abaaabafdsgdfgjbaaaa",'a'));
    }
    public static String trim(String str,char ch) {
        int left = 0;
        int right = str.length();
        boolean leftFlag =true;
        boolean rightFlag =true;
        int i = 0;
        while ((leftFlag || rightFlag) && i<str.length()){
            if(leftFlag){
                char letter = str.charAt(i);
                if(letter != ch){
                    leftFlag = false;
                    left = i;
                }
            }
            if(rightFlag){
                char letter = str.charAt(str.length()-i-1);
                if(letter != ch){
                    rightFlag = false;
                    right = str.length()-i;
                }
            }
            i++;
        }
        if(left>=right || (leftFlag && rightFlag)){
            return "";
        }
        return str.substring(left, right);   
    }
    public static int lastIndexOf(String str, char ch) {
        // Write your code here:
        return -1;
    }

    public static String toBinary (int x){
        // Write your code here:
        return "";
    }
    public static String [] tokenize(String str) {
        // Write your code here:
        return new String [0];
    }

public static String lowercase(String str) {
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 96 || str.charAt(i) < 65) {
                newstr = newstr + (char) str.charAt(i);
            } else {
                newstr = newstr + (char) (str.charAt(i) + 32);
            }
        }
        return newstr;
    }

    public static String camelcase(String str) {
        String lowercasestr = lowercase(str);
        String newstr = "";
        boolean isnextletterbig = false;
        for (int i = 0; i < str.length(); i++) {
            if (lowercasestr.charAt(i) == 32) {
                if(newstr.length() != 0){
                    isnextletterbig = true;
                }
            }
            else{ 
                if (isnextletterbig) {
                    char temp = lowercasestr.charAt(i) ;
                    temp = (char)((int)temp - 32);
                    newstr +=  "" + temp;
                    isnextletterbig = false;
                } 
                else{
                    newstr +=  "" + lowercasestr.charAt(i);
                }
            }
        }      
        return newstr;
    }
       

    public static int compareTo(String str1, String str2) {
        int check = 0;
        int min = Math.min((str1.length()), (str2.length()));
        str1 = lowercase(str1);
        str2 = lowercase(str2);
        for (int i = 0; i < min; i++) {

            if (str1.charAt(i) < str2.charAt(i)) {
                if (check == 0) {
                    check = -1;
                }
               
            } else if (str1.charAt(i) > str2.charAt(i)) {
                if (check == 0) {
                    check = 1;
                }
               

            }
        }
        if (str1.length() != str2.length()) {
            if (str1.length() < str2.length()) {
                if (check == 0) {
                    check = -1;
                }
              
            }
            if (str1.length() > str2.length()) {
                    if (check == 0) {
                        check = 1;
                    }
                  
            } 
        }
        return check;
    }

    public static int stringToInt(String str) {
        int num = 0;

        if ((str.charAt(0) != '-') && (str.charAt(0) != '+')) {
            for (int i = str.length() - 1; i >= 0; i--) {
                num = num + (str.charAt(i) - 48) * (int) (Math.pow(10, ((str.length() - 1) - i)));
            }
        } else {
            for (int i = str.length() - 1; i >= 1; i--) {
                num = num + (str.charAt(i) - 48) * (int) (Math.pow(10, ((str.length() - 1) - i)));
            }
            if (str.charAt(0) == '-') {
                num *= -1;
            }
            if (str.charAt(0) == '+') {
                num *= 1;
            }
        }
        return num;
    }

    public static String expand(String str) {
        String expand = "";
        int i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            int returnum = 0;
            i++;
            boolean flag = true;
            while (flag) {
                if (i >= str.length()) {
                    flag = false;
                } else {
                    if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                        returnum = (returnum * 10) + stringToInt("" + str.charAt(i));
                        i++;
                    } else {
                        flag = false;
                    }
                }
            }
            for (int j = 0; j < returnum; j++) {
                expand = expand + letter;
            }
        }

        return expand;
    }
}



