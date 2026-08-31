class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('_').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int startIndex = i;
                while(str.charAt(i) != '_'){
                    i++;
                }
            int length = Integer.parseInt(str.substring(startIndex, i));
            String currentString = str.substring(i+1, i+1+length);
            result.add(currentString);
            i = i + 1 + length;
        }
        return result;
    }
}
