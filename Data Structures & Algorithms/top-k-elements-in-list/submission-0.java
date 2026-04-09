class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        //build the freqs

        //k = num
        //v = freq
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            int curr_count = freq.getOrDefault(n, 0);
            freq.put(n, curr_count+1);
            //is there a better way to do this with .contains()?
        }
        freq.forEach((ke, v) -> System.out.println(ke + ": " + v));
        //build the reverse array
        Map<Integer, ArrayList<Integer>> reverse = new HashMap<Integer, ArrayList<Integer>>();
        freq.forEach((key, value) -> {
            ArrayList<Integer> list = reverse.getOrDefault(value, new ArrayList<Integer>());
            list.add(key);
            reverse.put(value, list);
        });
        reverse.forEach((ke, v) -> System.out.println(ke + ": " + v));
        System.out.println("Here");
        //get counts
        int[] ret = new int[k];
        int ptr = 0;
        for(int i = len; i > 0; i--){
            ArrayList<Integer> list = reverse.getOrDefault(i, new ArrayList<Integer>());
            for(int j = 0; j < list.size() && ptr < k; j++){
                ret[ptr] = list.get(j);
                ptr++;
            }
        }
        return ret;
    }
}
