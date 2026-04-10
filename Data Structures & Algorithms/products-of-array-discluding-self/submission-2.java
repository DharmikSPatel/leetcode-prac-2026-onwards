class Solution {
    public int[] productExceptSelf(int[] nums) {
        //prefix
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for(int i = 1; i < nums.length; i++){
            pre[i] = nums[i-1] * pre[i-1];
        }
        System.out.println(Arrays.toString(pre));

        int len = nums.length;
        int[] suf = new int[nums.length];
        suf[len-1] = 1;
        for(int i = len-2; i >= 0; i--){
            suf[i] = nums[i+1] * suf[i+1];
        }
        System.out.println(Arrays.toString(suf));

        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ret[i] = pre[i] * suf[i];
            
        }
        return ret;
    }
}  
