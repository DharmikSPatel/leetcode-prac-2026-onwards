class Solution {

    public String encode(List<String> strs) {
        String code = "";
        for(String str : strs){
            code = code + str.length() + "#" + str;
        }
        System.out.println(code);
        return code;
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<String>();
        String d = "#";
        for(int i = 0; i < str.length();){
            String len_s = str.substring(i, str.indexOf(d, i));
            i+=len_s.length() + 1;
            int len = Integer.parseInt(len_s);
            String s = str.substring(i, i+len);
            i+=len;
            System.out.println(s);
            list.add(s);
        }
        return list;
    }
}
