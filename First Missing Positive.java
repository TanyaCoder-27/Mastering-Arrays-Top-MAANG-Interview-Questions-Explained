/*
First Missing Positive
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]<nums.length &&  nums[i]>0  && nums[i] != nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[temp-1]; // you can write nums[nums[i]-1] as nums[temp-1] since temp = nums[i]
                nums[temp-1] = temp;    
            }
            else{
                i++;
            }
        }

        for(int k=0;k<nums.length;k++){
            if(nums[k]!=k+1){
                return k+1;
            }
        }
        return nums.length+1;
    }
}

/*

Step-by-Step Explanation:
Function Definition:
                                        

public int firstMissingPositive(int[] nums) {
The function firstMissingPositive takes an array of integers nums as input and returns the smallest missing positive integer.

---Initial Index Setup:

int i = 0;
Initialize a variable i to 0, which will be used to iterate through the array.

---Rearrange the Array:
 
while (i < nums.length) {
    if (nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
        int temp = nums[i];
        nums[i] = nums[temp - 1];
        nums[temp - 1] = temp;
    } else {
        i++;
    }
}
This while loop continues until i reaches the length of the array.

Condition: nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]

Check: The value nums[i] should be within the bounds of the array (0 < nums[i] < nums.length).

Check: The value should be positive.

Check: nums[i] should not already be in its correct position (i.e., at index nums[i] - 1).

Swap:

If all conditions are met, swap the value at nums[i] with the value at its correct position (nums[nums[i] - 1]).

--- Find the First Missing Positive:

for (int k = 0; k < nums.length; k++) {
    if (nums[k] != k + 1) {
        return k + 1;
    }
}

Iterate through the rearranged array.

If an index k is found where the value is not k + 1, return k + 1 as the first missing positive integer.

--- Return the Next Positive Number:

return nums.length + 1;
If all indices are in their correct positions, return nums.length + 1 as the smallest missing positive integer.

Example:
Let's go through an example:

Input: nums = [3, 4, -1, 1]

Step 1: Rearrange the array so that each positive number is in its correct index position.

Initial: [3, 4, -1, 1]

After first swap: [-1, 4, 3, 1]

After second swap: [1, -1, 3, 4]

Step 2: Find the first missing positive integer.

Check nums[0] == 1, move to the next.

Check nums[1] != 2 -> return 2.

Output: 2

This method ensures an efficient solution with a time complexity of O(n) and uses constant space.


*/
