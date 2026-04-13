class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        int c = 0;
        int max_c = c;
        for(int i : nums){
            c = 0;       
            if(!hs.contains(i-1)){
                while(hs.contains(i)){
                    c++;
                    i++;
                }
                if(c > max_c)
                    max_c = c;
                
            }
                
            
        }
        return max_c;
    }
}
