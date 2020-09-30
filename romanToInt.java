/* Starter Code:
class Solution {
    public int romanToInt(String s) {     
        
    }
}
*/

/* 
  Goal: Given roman numerals as the input, return the integer value
  Tip: Roman numerals are written left to write from largest to smallest, 
       if a smaller number is written before a larger number, it is subtracted.
       
       I - 1
       V - 5
       X - 10
       L - 50
       C - 100
       D - 500 
       M - 1000

  Example: "IV" --> 4 because (V)5 - (I)1 = 4, 
           "MCMXCIV" --> 1994 because (M)1000 + (CM)900 + (XC)90 + (IV)4
*/
class Solution {
    public int romanToInt(String s) {
	    
	    // If s is nonexistant or empty, return 0
	    if(s == null || s.isEmpty()) {
	       return 0; 
	    }
	    
	    // Ensures the roman numeral string are upper case
	    String input = s.toUpperCase();
	    
	    // Local variables
	    char letter;
	    int value = 0;
	    int result = 0;
	    int left = 0;
	    int right = 0;
	    int amount = 0;
	    
	    // Holds the converted roman characters to integer values
	    ArrayList<Integer> sequence = new ArrayList<Integer>();
	    
	    // Holds the sum
	    ArrayList<Integer> sum = new ArrayList<Integer>();
        
        // Get each character in a string
        for(int i = 0; i < input.length(); i++) {
            letter = input.charAt(i);
            
            // Assign values to roman numerals
            switch (letter) {
                case 'I':
                    value = 1;
                    break;
                case 'V':
                    value = 5;
                    break;
                case 'X':
                    value = 10;
                    break;
                case 'L':
                    value = 50;
                    break;
                case 'C':
                    value = 100;
                    break;
                case 'D':
                    value = 500;
                    break;
                case 'M':
                    value = 1000;
                    break;
                default:
                    break;
            }
            
            sequence.add(value);
            
        }

        // If there is only 1 character, return the value. i.e. "I" = 1
        if(sequence.size() == 1) {
            return sequence.get(0);
        }

        /* Example: "MCMXCIV" --> 1994 because (M)1000 + (CM)900 + (XC)90 + (IV)4
        
        First, the sequence arraylist looks like this: [1000, 100, 1000, 10, 100, 1, 5] 
        
        The plan is to loop through all values and decide how to add/subtract values based
        on roman numeral rules. I store all the resulting values into an arraylist because I don't know 
        how many resulting values I will need to add up.
        
        1. If the right == left, add them (ex. "II" = 2 because 1("I") + 1("I") = 2
        2. If right > left, subtract them (ex. "IV" = 4 because right ("V") - left ("I") = 5 - 1 = 4
        3. If the left > right, keep the left value and move on. 
           (ex. "MCM" = 1900 because: 
            * Left = 1000("M") and Right = 100("C"), left > right so keep left and increment
              Resulting sum arraylist: [1000]
            * Left = 100 ("C") and Right = 1000("M"), right > left so subtract them
              Resulting sum arraylist: [1000, 900]
            * Add up all the values in the sum arraylist: 1000 + 900 = 1900)
        
        
        */
        for(int j = 0; j < sequence.size(); j++) {
            
            // Check if left and right exist (we need 2 numbers, and stay in bounds of arraylist)
            if(sequence.size() > 1 && j < sequence.size() - 1) {
                
                left = sequence.get(j);
                right = sequence.get(j + 1);
                
                // Roman numeral rule 1, if right and left are equal, add them.
                if(right == left) {
                    amount = left + right;
                    sum.add(amount);
                    
                    // Need to increment to the next set of roman numeral numbers since we added 2 numbers (increment once here, so for loop can increment again == increment 2 times)
                    j++;
                } 
                // Roman numeral rule 2, if right is greater than left, subtract them.
                else if(right > left) {
                    amount = right - left;
                    sum.add(amount);
                    
                    // Need to increment to the next set of roman numeral numbers since we subtracted 2 numbers
                    j++;
                } 
                // If right < left, keep left and move on.
                else {
                    sum.add(left);
                    
                    // The for loop will increment for us since it increments 1 time
                }
                
            } 
            // This will add the last number in the sequence arraylist to the sum arraylist (i.e. "III" = 3, the last "I" will be added to 2 since "II" is calculated above.
            else {
                amount = sequence.get(sequence.size() - 1);
                sum.add(amount);
            }
        }
        
        // Add up all the values in the sum arraylist
        for(int k = 0; k < sum.size(); k++) {
            result += sum.get(k);
        }
        
        return result;
    }
}