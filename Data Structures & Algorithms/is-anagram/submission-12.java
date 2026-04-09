class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            int count = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), ++count);
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        for (int i = 0; i < t.length(); i++){
            if ( ((Integer)hm.get(t.charAt(i)) != null)){
                System.out.println("in here for " + t.charAt(i));
                int new_count = hm.get(t.charAt(i))-1;
                System.out.println(new_count);
                if (new_count > 0)
                    hm.put(t.charAt(i), new_count);
                else{
                    hm.remove(t.charAt(i));
                }
            }
            else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        return true;
    }
}
