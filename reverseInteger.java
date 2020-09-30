class Solution {
    public int reverse(int x) {
        
        // Convert int to string
        String input = Integer.toString(x);
        
        // Store the reverse as a string
        String result = "";
        
        // Put it into a char array
        char[] storage = input.toCharArray(); 
        
        // If there is a negative ('-') char, stop the for loop before the ('-') char
        int reverseLength = 0;
        
        // Checking for the negative ('-') char
        if(Character.compare(storage[0], '-') == 0) {
            result += storage[0];
            reverseLength = 1;
        }
        
        // Reverse the char array
        for(int i = storage.length - 1; i >= reverseLength; i--) {
            result += storage[i];
        }
        
        // Convert reverse string to an int
        try {
            return Integer.parseInt(result);
        } 
        /* If there is an overflow (Java integers are 32-bits aka if there are more than 10 digits = overflow and you should use a "long" instead)
           Since we "shouldn't" alter the method header leetcode has given to a long, we need to use a try-catch block for the overflow cases
        */
        catch(NumberFormatException e) {
            return 0;
        }
        
    }
}