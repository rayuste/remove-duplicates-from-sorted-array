class Solution {

    public void moveElementToEnd(int[] arr, int index) {
        if (index >= arr.length)
            return;
        
        int saved_element = arr[index];
        
        for (int i = 0; i < arr.length; i++) {
            if (i <= index) continue;
            arr[i-1] = arr[i];
        }
        
        arr[arr.length-1] = saved_element;
    }
    
    
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size < 2)
            return size;
        
        int curr = 0;
        int next = 1;
        int result = 1;
        int times_ran = 0;
        
        while (next < size && times_ran < size) {
            int curr_num = nums[curr];
            int next_num = nums[next];
            
            if (curr_num > next_num)
                break;
            
            if (curr_num != next_num) {
                result++;
                curr++;
                next++;
            } else
                moveElementToEnd(nums, next);
            
            times_ran++;
        }
        
        return result;
    }
    
}