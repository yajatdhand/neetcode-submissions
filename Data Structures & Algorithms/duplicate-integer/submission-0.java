class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
            for(int i : nums){
                if(!set.add(i)){
                    return true;
                }
            }
            return false;
    }
}