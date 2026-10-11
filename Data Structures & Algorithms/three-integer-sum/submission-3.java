class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < n; ++j){
                int sum = nums[i] + nums[j];
                if(set.contains(-sum)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-sum);
                    temp.sort(null);
                    ans.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(ans); 
    }
}
