/* Code given:
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
      // Code goes here
    }
};
*/

// My answer
/* 
  Goal: Return a vector of integers that hold the indices of the values that add up to the target
*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        //global variables
        vector<int> vec; // Return value will go in here
        int sum = 0;
        
        //Iterate through the vector
        for(int i = 0; i < nums.size(); i++) {
            
            for(int j = i + 1; j < nums.size(); j++) {
            
                //Get the first number, add with second
                sum = nums[i] + nums[j];
                    
                    //Check if the two numbers reach the target value
                    if(sum == target) {
                        
                        //If they do, add them to the vector
                        vec.push_back(i);
                        vec.push_back(j);
                        return vec;
                    } //End of if statement
                    
            }//End of for loop
        }//End of for loop
        
        return vec; //Returns empty vector if no answer
    }//end of twosum

};