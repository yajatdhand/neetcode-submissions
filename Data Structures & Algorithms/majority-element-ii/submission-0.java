class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : nums) map.put(e, map.getOrDefault(e, 0) + 1);

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n / 3) ans.add(entry.getKey());
            if(ans.size() == 2) break;
        }

        return ans;
    }
}