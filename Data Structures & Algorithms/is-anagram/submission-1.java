class Solution {
    public boolean isAnagram(String s, String t) {
        // s = racecar, t = carrace
        if(s.length() != t.length()) return false;

        int arr[] = new int[26];
        for(int i = 0; i < s.length(); ++i){
                arr[s.charAt(i) - 'a']++;
                arr[t.charAt(i) - 'a']--;
        }

        for(int e : arr){
            if(e != 0) return false;
        }
        return true;
    }
}
