class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String s : strs){
            res = res.concat(s.length() + "_" + s);
        }
        return res;
    }

    public List<String> decode(String str) {
         StringBuilder length = new StringBuilder();
        List<String> res = new ArrayList<>();
        int i = 0; //5_Hello4_boys4_this2_is10_encodinggg
        while(i < str.length()){
            if(str.charAt(i) != '_'){
                length.append(str.charAt(i));
                i++;
                continue;
            }

            String s = str.substring(i + 1, i + 1 + Integer.parseInt(length.toString()));
            res.add(s);
            i += Integer.parseInt(length.toString()) + 1;
            length = new StringBuilder();
        }
        return res;
    }
}
