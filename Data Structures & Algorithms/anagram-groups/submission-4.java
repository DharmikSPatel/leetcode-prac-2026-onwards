class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // try the object hash table method? like a string obj with hashcode functiion overreide
        List<List<String>> list = new ArrayList<>();



        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            System.out.println("list " + list);
            System.out.println("listsize " + list.size());
            int len = list.size();
            boolean foundHome = false;
            for(int j = 0; j < len; j++){
                System.out.println("\tinside with " + s + " " + j);
                List<String> inner_list = list.get(j);
                System.out.println("\tinner list" + inner_list);
                String firstS = inner_list.get(0);

                if (isAnn(s, firstS)){
                    inner_list.add(s);
                    foundHome = true;
                    break;
                }
            }
            if (foundHome == false){
                System.out.println("Making New with " + s);
                List<String> newList = new ArrayList<>();
                newList.add(s);
                list.add(newList);
            }
        }
        return list;
    }
    public boolean isAnn(String s, String t){
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
