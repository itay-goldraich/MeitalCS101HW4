
public class Recursion {
    // For Q8
    public static int steps = 0;

    public static void main(String[] args) {
        //System.out.println(gcd(4, 6));
        //System.out.println(gcd(54, 24));
        //System.out.println(gcd(56, 42));
        mainQuestion8();
    }

    public static int gcd (int a, int b){
        if(a == b){
            return a;
        }
        else if(a > b){
            return gcd(a-b, b);
        }
        else{
            return gcd(a, b-a);
        }
    }

    public static String removeVowels (String str){
       char [] vowels = new char[] {'a','e','i','o','u','A','E','I','O','U'};
        return removeSingleVowel(str, vowels, 0);
    }
    private static String removeSingleVowel (String str, char [] vowels, int index){
        int loc = str.indexOf(vowels[index]);
        if( loc == -1 ){
            return removeSingleVowel(str, vowels, index +1);
        }
        else{
            str = str.substring(0, loc) + str.substring(loc+1);
            return removeSingleVowel(str, vowels, index);
        }
    }

    public static String convert (int num, int base){
    int quotient = num / base;
    int remainder = num % base;

    if (quotient == 0) // base case
    {
        return "" + remainder;      
    }
    else
    {
        return convert(quotient, base) + "" + remainder;
    }        
}

    public static String camelcase (String sentence){
        return ToUpperCaseAfterSpace(toLowercase(sentence));
    }

    private static String ToUpperCaseAfterSpace(String str){
        return singleLetterToUpperCase(str, str.indexOf(" "));
    }

    private static String singleLetterToUpperCase(String str, int i){
        if(i == -1){
            return str;
        }
        char letter = str.charAt(i);
        letter = (char)((int)letter - (int)'a'+ (int)'A');
        str = str.substring(0, i-1) + letter + str.substring(i+1);
        i = str.indexOf(" ");
        if(i+1< str.length()){
            return singleLetterToUpperCase(str, i+1);
       }
       return str;

    }

    private static String toLowercase(String str){
        return singleLetterToLowercase(str, 0);
    }
    private static String singleLetterToLowercase (String str, int i){
        char letter = str.charAt(i);
        if (letter >= 'A' && letter <= 'Z') {
            letter = (char)((int)letter - (int)'A'+ (int)'a');
            str = str.substring(0, i-1) + letter + str.substring(i+1);
        }
        if(i+1< str.length()){
             return singleLetterToLowercase(str, i+1);
        }
        return str;
    }

    public static int sumArray (int [] arr){
        return sumArray(arr,0);
    }
    public static int sumArray (int [] arr, int n){
        if(n == arr.length){
            return 0;
        }
        return arr[n] + sumArray(arr,n+1);
    }
    public static int binarySearch (int [] sortedArr, int value){
        return binarySearch(sortedArr,0,sortedArr.length-1,value);
    }
    private static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
             if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }


    public static boolean isSubarr (int [] smaller, int [] bigger){
        return isSubarr(bigger, smaller, 0);
    }

    private static boolean isSubarr (int [] arr, int [] subarr, int indexArr){
        if(indexArr == arr.length){
            return false;
        }
        if(arr[indexArr] == subarr[0]){
            if(isSubarr(arr, subarr, indexArr, 0)){
                return true;
            }
        }
        return isSubarr(arr, subarr, indexArr+1);
       }

    private static boolean isSubarr (int [] arr, int [] subarr, int indexArr, int indexSubArr){
        if(indexSubArr == subarr.length){
            return true;
        }
        if (indexArr == arr.length){
            return false;
        }
        if (arr[indexArr] == subarr[indexSubArr]){
            return isSubarr(arr, subarr, indexArr+1,indexSubArr+1);
        }
        return false;
    } 

    public static void mainQuestion8() {
        // Put your testing code here. For example:
        int[][] a = { {3, 4, 5},
                      {2, 2, 0},
                      {1, 0, 1} };
        System.out.println(" Value of maximal path = " + maxVal(a)); 
        System.out.println(" Number of recursive steps = " + steps);
        steps = 0;                       
        System.out.println(" Value of maximal path = " + effMaxVal(a)); 
        System.out.println(" Number of recursive steps = " + steps);
    }

    // Returns the value of the maximal path in the given 2D array
    public static int maxVal(int[][] arr) {
        return maxVal(arr, 0, 0);
    }
    
    // Returns the value of the maximal path in the given 2D array, starting at location (i,j)
    private static int maxVal(int[][] arr, int i, int j) {
        steps++;
        if(i == arr.length){
            return 0;
        }
        if(j == arr[0].length){
            return 0;
        }
        return arr[i][j] + Math.max(maxVal(arr,i+1,j),maxVal(arr,i,j+1));
    }
    
    // Returns the value of the maximal path in the given 2D array, efficiently.
    public static int effMaxVal(int[][] arr) {
        // Creates a 2D array named memo, of the same dimensions as arr.
        // This array will be used for memorizing maxVal computations.
        // After creating the memo array, initializes all its elements to -1.
        // Next, initializes the value of the bottom-right cell of memo to the 
        // value of the bottom-right (destination) cell of arr.

        // Put the array creation and initialization code here:
        int[][] memo = new int[arr.length][arr[0].length];
        memoToMinusOne(memo, 0);
        // Computes the value of the maximal path, using the memo array: 
        effMaxVal(arr, 0, 0, memo);

        // The maximal value is now stored in memo[0][0]:
        return memo[0][0];
    }
    private static void memoToMinusOne (int[][] memo, int cul){
        if(cul == memo.length){
            //do nothing
        }
        else{
            memoToMinusOne(memo,cul,0);
            memoToMinusOne(memo, cul +1);
        }

    }
    private static void memoToMinusOne (int[][] memo, int cul, int row){
        if(row == memo[0].length){
            //do nothing
        }
        else{
            memo[cul][row] = -1;
            memoToMinusOne(memo,cul,row+1);
        }

    }
    
    // Returns the value of the maximal path in the given 2D ar ray, starting
    // at location (i,j), efficiently. By "efficiently" we mean as follows:
    // If the value was already computed, returns the value using memo.
    // Otherwise, computes the value, stores the value in memo,
    // and returns the value.
    // SIDE EFFECT: This function changes the contents of the given memo array.
    private static int effMaxVal(int[][] arr, int i, int j, int[][] memo) {
        steps++;
        // Replace the following statement with your code:
        if(memo[i][j] == -1){
            memo [i][j] = arr[i][j] + Math.max(Continue(arr,i+1,j,memo),Continue(arr, i, j+1, memo)); 
        }
        return memo[i][j];
    }

    private static int Continue (int[][] arr, int i, int j, int[][] memo){
        if(i == memo.length){
            return 0;
        }
        if(j == memo[0].length){
            return 0;
        }
        return effMaxVal(arr,i,j,memo);
    }
}
