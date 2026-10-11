class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCnt = 0;
        Set<Integer> set = new HashSet<>();
        for(int e : nums) set.add(e);

        for(int e : set){
            if(!set.contains(e - 1)){
                int cnt = 1;
                while(set.contains(e + 1)){
                    cnt++;
                    e = e + 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
        }
        return maxCnt;
    }
}
