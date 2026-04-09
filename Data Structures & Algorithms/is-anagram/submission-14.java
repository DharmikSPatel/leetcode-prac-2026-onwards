class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            int count = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), ++count);
        }

        for (int i = 0; i < t.length(); i++){
            if ( ((Integer)hm.get(t.charAt(i)) != null) && hm.get(t.charAt(i)) > 0){
                int new_count = hm.get(t.charAt(i))-1;
                hm.put(t.charAt(i), new_count);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
